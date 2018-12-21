package com.ipartek.formacion.filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelos.pojos.Usuario;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/privado/*" })
public class LoginFilter implements Filter {

	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		HttpSession session=req.getSession();
		Usuario uLogueado =(Usuario)session.getAttribute("usuario_logueado");
		
		if (uLogueado!=null) {
			chain.doFilter(request, response);
		}else {
			session.setAttribute("error", "Acceso restringido a area privada sin logueo");
			//session.setAttribute("navegador",req.getHeader("USER-AGENT"));
			res.sendRedirect(req.getContextPath()+"/login");
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
