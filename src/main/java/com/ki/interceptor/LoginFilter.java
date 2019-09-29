package com.ki.interceptor;


import com.ki.entity.UserEntity;
import com.ki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Autowired
    UserRepository userRepository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Login Filter In");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();

        String userName = (String)request.getParameter("email");
        String password = (String)request.getParameter("password");
        String uri = request.getRequestURI().split("/")[1];

        switch (uri) {
            case "login":
                UserEntity user = userRepository.findByUserEmailAndPassword(userName, password);
                if (user == null) {
                    System.out.println("Login Error");
                    response.sendRedirect("login.html");
                }
                System.out.println("Login OK");
                session.setAttribute("username", userName);
                break;

            default:
                userName = (String)session.getAttribute("username");
                if (userName == null) {
                    System.out.println("Login Ng");
                    response.sendRedirect("login.html");
                }
                System.out.println("Login UserName: " + userName);
        }


        System.out.println("Before Filter Do");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("After Filter Do");
    }

    @Override
    public void destroy() {
        System.out.println("Login Filter Out");
    }
}
