package controller;

import static util.Ferramentas.direcionaParaHtml;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Loja;
import model.Produto;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/mostraProdutoEComentario")
public class MostraProdutoEComentario extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

			req.setCharacterEncoding("UTF-8");
		try {

				Long id = Long.parseLong(req.getParameter("idDoProduto"));
				Loja loja = new Loja();

				Produto produto = loja.buscaProdutoPorID(id);
				List<Comentario> lista = loja.buscaComentariosDoProdutoPorID(id);

				req.setAttribute("comentarios", lista);
				req.setAttribute("produto", produto);

				direcionaParaHtml(req, resp, "mostraProdutoEComentario.jsp");

		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			direcionaParaHtml(req, resp, "erro.jsp");
		}

	}

}
