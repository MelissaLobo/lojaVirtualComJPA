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
@WebServlet(urlPatterns = "/carrinhoDeCompras")
public class CarrinhoDeCompras extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {

			Usuario usuario = (Usuario) req.getSession().getAttribute(
					"usuarioLogado");

			if (usuario != null) {
				req.getSession().setAttribute("usuarioLogado", usuario);

				Loja loja = new Loja();
				loja.produtosDoCarrinhoDoUsuario(usuario);

				req.setAttribute("produtosCarrinho", loja.produtosDoCarrinhoDoUsuario(usuario));
				req.setAttribute("total", loja.somaDosProdutosDoCarrinho(usuario));

				direcionaParaHtml(req, resp, "lojaVirtual/carrinhoDeCompras.jsp");

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