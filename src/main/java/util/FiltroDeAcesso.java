package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import static util.Ferramentas.*;

@WebFilter(urlPatterns = "/lojaVirtual/*")
public class FiltroDeAcesso implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		Usuario usuario = (Usuario) req.getSession().getAttribute(
				"usuarioLogado");
		if (usuario == null) {
			direcionaParaHtml(req, resp, "/login.jsp");

		}
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}

}
