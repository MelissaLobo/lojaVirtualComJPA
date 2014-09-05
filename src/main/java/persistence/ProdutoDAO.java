package persistence;

import java.util.List;

import javax.persistence.Query;

import model.Produto;
import model.Usuario;

public class ProdutoDAO  extends DaoGenerico<Produto, Long>{

@SuppressWarnings("unchecked")
public List<Produto> listaProdutoPorUsuario(Usuario usuario) {
		
		try {
			Query query = entityManager.createQuery("from Produto produto");
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
