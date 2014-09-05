package model;

import java.util.ArrayList;
import java.util.List;

import persistence.CarrinhoDAO;
import persistence.ComentarioDAO;
import persistence.ProdutoDAO;
import persistence.UsuarioDAO;

public class Loja {
	
	ProdutoDAO produtoDAO = new ProdutoDAO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
	
	public List<Produto> listaDeProdutosPorUsuario(Usuario usuario) {
		return produtoDAO.listaProdutoPorUsuario(usuario);
	}
	
	public List<Produto> listaDeProdutos(Usuario usuario) {
		List<Produto> listaTodos = produtoDAO.listaProdutoPorUsuario(usuario);

		for (Produto produto : listaTodos) {
			produto.getId();
			produto.getNome();
			produto.getMarca();
			produto.getDescricao();
			produto.getCategoria();
			produto.getValor();
			for (Comentario coment : produto.getComentarios()) {
				coment.getId();
				coment.getNome();
			}
		}
		return listaTodos;
	}
	
	public List<Produto> listaTodos() {

		return produtoDAO.findAll();

	}

	public void novoProduto(String nome, int valor, String descricao,
			String marca, Categoria categoria, Usuario usuario) {

		Usuario usuarioGerenciado = usuarioDAO.find(usuario.getId());
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setMarca(marca);
		produto.setCategoria(categoria);
		
		usuarioGerenciado.getProdutos().add(produto);
		
		usuarioDAO.update(usuarioGerenciado);

	}

	public void adicionarComentario(String nome, String texto, int idDoProduto) {

		long id = idDoProduto;
		Comentario comentarios = new Comentario();
		comentarios.setNome(nome);
		comentarios.setTexto(texto);

		Produto produto = produtoDAO.find(id);

		produto.getComentarios().add(comentarios);
		
		produto.getComentarios().add(comentarios);

		produtoDAO.update(produto);
		
	}

	public Produto buscaProdutoPorID(Long id) {
		return produtoDAO.find(id);

	}

	public List<Comentario> buscaComentariosDoProdutoPorID(Long id) {
		ComentarioDAO comentarioDAO = new ComentarioDAO();

		Produto produto = produtoDAO.find(id);

		List<Comentario> comentariosDoProduto = comentarioDAO.listaComentarioPorProduto(produto);

	    for (Comentario coment : comentariosDoProduto) {
			coment.getNome();
			coment.getTexto();
		}

		return comentariosDoProduto;
	}

	public void adicionarProdutoAoCarrinho(Long id, Usuario usuario) {
		
		Usuario usuarioGerenciado = usuarioDAO.find(usuario.getId());
		
		Produto produto = new Produto();
		produto.setId(id);
		usuario.setId(id);
		
		
		usuarioGerenciado.getProdutos().add(produto);
		usuarioDAO.update(usuarioGerenciado);

	}
	
	
	
	public List<Produto> produtosDoCarrinhoDoUsuario(Usuario usuario) {
		List<Produto> listaTodosProdutosDoCarrinho = carrinhoDAO.listaProdutoDoCarrinho(usuario);
				

		for (Produto produto : listaTodosProdutosDoCarrinho) {
			produto.getId();
			produto.getNome();
			produto.getMarca();
			produto.getDescricao();
			produto.getCategoria();
			produto.getValor();
			for (Comentario coment : produto.getComentarios()) {
				coment.getId();
				coment.getNome();
			}
			int total = 0;
			for (Produto item : listaTodosProdutosDoCarrinho) {
				total = total + item.getValor();
			}
		}
		return listaTodosProdutosDoCarrinho;
	}
	

//	public List<Long> listaDeIdDosProdutosDoUsuario(Usuario usuario) {
//		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
//		return carrinhoDAO.listaProdutoDoCarrinho(usuario);
//		//return listaDeIdDosProdutosDoUsuario(usuario);
//	}
//
//	public List<Produto> produtosDoCarrinhoDoUsuario(Usuario usuario) {
//
//		List<Long> listaDeIdDosProdutosDoUsuario = listaDeIdDosProdutosDoUsuario(usuario);
//
//		List<Produto> listaDeProdutosDoUsuario = new ArrayList<Produto>();
//
//		for (Long produtoId : listaDeIdDosProdutosDoUsuario) {
//			listaDeProdutosDoUsuario.add(buscaProdutoPorID(produtoId));
//		}
//
//		int total = 0;
//		for (Produto item : listaDeProdutosDoUsuario) {
//			total = total + item.getValor();
//		}
//		return listaDeProdutosDoUsuario;
//	}

	public int somaDosProdutosDoCarrinho(Usuario usuario) {
		List<Produto> listaDeProdutosDoUsuario = produtosDoCarrinhoDoUsuario(usuario);
		int total = 0;
		for (Produto item : listaDeProdutosDoUsuario) {
			total = total + item.getValor();
		}
		return total;
	}

//	public void removerProdutoDoCarrinho(Usuario usuario) {
//		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
//		carrinhoDAO.removerProdutoDoCarrinhoDoUsuario(Usuario usuario);
//		
//	}
	
	
}
