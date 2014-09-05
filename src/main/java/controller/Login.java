package controller;

import static util.Ferramentas.direcionaParaHtml;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GerenciadorDeUsuarios;
import model.Usuario;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {

			String email = req.getParameter("email");
			String senha = req.getParameter("senha");

			GerenciadorDeUsuarios gerenciador = new GerenciadorDeUsuarios();
			Usuario usuarioLogado = gerenciador.tentaLogar(email, senha);

			if (usuarioLogado != null) {
				req.getSession().setAttribute("usuarioLogado", usuarioLogado);
				resp.sendRedirect("home");
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
