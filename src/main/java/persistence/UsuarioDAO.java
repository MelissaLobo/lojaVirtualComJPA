package persistence;

import javax.persistence.Query;

import model.Usuario;

public class UsuarioDAO extends DaoGenerico<Usuario, Long> {

	public Usuario buscaPorLoginESenha(String email, String senha) {
		Usuario usuario = null;

		try {
			Query query = entityManager
					.createQuery("from Usuario usuario where usuario.email = :email AND usuario.senha = :senha");
			query.setParameter("email", email);
			query.setParameter("senha", senha);
			return (Usuario) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public void removerCarrinhoDoUsuario(Usuario usuario) {
		usuario = find(usuario.getId());
		usuario.setCarrinho(null);
		update(usuario);
	}
}