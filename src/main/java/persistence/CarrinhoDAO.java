package persistence;

import java.util.List;

import javax.persistence.Query;

import model.Carrinho;
import model.Produto;
import model.Usuario;

public class CarrinhoDAO extends DaoGenerico<Carrinho, Long> {

	public List<Produto> listaProdutoDoCarrinho(Usuario usuario) {

		try {
			Query query = entityManager
					.createQuery("from Carrinho carrinho join fetch carrinho.produtos where carrinho = :carrinho");
			query.setParameter("carrinho", usuario.getCarrinho());
			Carrinho resultado = (Carrinho) query.getSingleResult();
			return resultado.getProdutos();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
