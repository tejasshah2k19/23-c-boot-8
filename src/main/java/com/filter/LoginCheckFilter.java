package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier(value = "1")
@Component
public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest reqX, ServletResponse resX, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) (reqX);

		String url = request.getRequestURL().toString();
		System.out.println("url => " + url);

		// private -> session -> user?
		if (url.contains("/category/")) {
			HttpSession session = request.getSession();
			if (session.getAttribute("user") == null) {
				// login
				request.setAttribute("error", "Please Login Before Accessing the service");
				RequestDispatcher rd = request.getRequestDispatcher("/login");
				rd.forward(request, resX);
			}
		}
		// public -> goAhead

		chain.doFilter(request, resX);

	}

}
