package controller;

import static util.Ferramentas.direcionaParaHtml;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import model.Loja;
import model.Usuario;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/cadastrarProduto")
public class CadastrarProduto extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {

			Usuario usuario = (Usuario) req.getSession().getAttribute(
					"usuarioLogado");

			if (usuario != null) {
				req.getSession().setAttribute("usuarioLogado", usuario);

				String nome = req.getParameter("nome");
				int valor = Integer.parseInt(req.getParameter("valor"));
				String descricao = req.getParameter("descricao");
				String marca = req.getParameter("marca");
				Categoria categoria = Categoria.valueOf(req
						.getParameter("categoria"));

				Loja loja = new Loja();
				loja.novoProduto(nome, valor, descricao, marca, categoria,
						usuario);

				direcionaParaHtml(req, resp, "/listaDeProdutos.jsp");

			} else {
				req.setAttribute("erro", "usuario ou senha invalida");
				direcionaParaHtml(req, resp, "/login.jsp");
			}

		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			direcionaParaHtml(req, resp, "erro.jsp");
		}
	}

}
