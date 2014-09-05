package controller;

import static util.Ferramentas.direcionaParaHtml;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loja;
import model.Usuario;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/comentar")
public class Comentar extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		try {
			Usuario usuario = (Usuario) req.getSession().getAttribute(
					"usuarioLogado");

			
			if (usuario != null) {
				req.getSession().setAttribute("usuarioLogado", usuario);

			String nome = req.getParameter("nome");
			String texto = req.getParameter("texto");
			String id = req.getParameter("idDoProduto");

			Loja loja = new Loja();
			loja.adicionarComentario(nome, texto, Integer.parseInt(id));

			resp.sendRedirect("mostraProduto?idDoProduto=" + id);

			}else {
				req.setAttribute("erro", "usuario ou senha invalida");
				direcionaParaHtml(req, resp, "/login.jsp");
			}
		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			direcionaParaHtml(req, resp, "erro.jsp");
		}
	}
}
