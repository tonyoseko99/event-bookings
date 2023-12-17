package com.tonnyseko.servlet.filters;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Priority;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Priority(2)
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpRequest.getSession();

        String servletPath = httpRequest.getServletPath();
        System.out.println(servletPath);

        if (httpSession.isNew() || StringUtils.isBlank((String) httpSession.getAttribute("loggedInId"))) {
            httpSession.invalidate();

            if (servletPath.equals("/login") || servletPath.contains(".jsp") || servletPath.equals("/registration") || servletPath.equals("/rest")) {
                chain.doFilter(request, response);
            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                response.getWriter().flush();
            }
        } else {
            if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId")))
                chain.doFilter(request, response);
            else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                response.getWriter().flush();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
