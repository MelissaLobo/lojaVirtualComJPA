package controller;

import static util.Ferramentas.direcionaParaHtml;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loja;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/produtos")
public class ListaDeProdutos extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Loja loja = new Loja();

		req.setAttribute("produtos", loja.listaTodos());

		direcionaParaHtml(req, resp, "/listaDeProdutos.jsp");
	}
}
