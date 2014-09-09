package persistence;

import java.util.List;

import javax.persistence.Query;

import model.Comentario;
import model.Produto;

public class ComentarioDAO extends DaoGenerico<Comentario, Long> {

	@SuppressWarnings("unchecked")
	public List<Comentario> listaComentarioPorProduto(Produto produto) {

		try {
			Query query = entityManager
					.createQuery("from Comentario comentario");
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
