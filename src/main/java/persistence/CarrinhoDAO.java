package persistence;

import java.util.List;

import javax.persistence.Query;

import model.Carrinho;
import model.Produto;
import model.Usuario;

public class CarrinhoDAO extends DaoGenerico<Carrinho, Long>{

	
	@SuppressWarnings("unchecked")
	public List<Produto> listaProdutoDoCarrinho(Usuario usuario) {
			
			try {
				Query query = entityManager.createQuery("from Carrinho carrinho");
				return query.getResultList();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	
	@SuppressWarnings("unchecked")
	public List<Long> listaDeIdDosProdutos(Usuario usuario) {
		
		try {
			Query query = entityManager.createQuery("from Carrinho carrinho where id_usuario=?");
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	}
