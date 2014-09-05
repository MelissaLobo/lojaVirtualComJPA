package controller;

import static util.Ferramentas.direcionaParaHtml;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/formularioCadastrarProduto")
public class FormularioCadastraProduto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setAttribute("categorias", Categoria.values());

		direcionaParaHtml(req, resp, "/cadastrarProduto.jsp");

	}

}
