package com.ki.interceptor;

import com.ki.entity.UserEntity;
import com.ki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        String urlPath = request.getRequestURI();

        // static resource -> Ok
        if (urlPath.startsWith("/css") || urlPath.startsWith("/js")) {
            return true;
        }

        // already login -> OK
        if (session.getAttribute("userId") != null) {
            return true;
        }

        ModelAndView modelAndView = new ModelAndView();

        // login path
        if (urlPath.startsWith("/login")) {
            if ("GET".equals(request.getMethod())) {
                // to login operation  -> OK
                return true;
            } else if ("POST".equals(request.getMethod())) {
                // real login operation
                UserEntity user = userRepository.findByUserEmailAndPassword(
                        request.getParameter("email"),
                        request.getParameter("password"));
                if (user != null) {
                    // login success
                    session.setAttribute("userId", user);
                    modelAndView.setViewName("login");
//                    response.sendRedirect(request.getContextPath() + "/");
                    return true;
                }
                // login failed
                modelAndView.setViewName("login");
//                response.sendRedirect(request.getContextPath() + "/login");
                return false;
            }
        }

        // need login
        modelAndView.setViewName("index");
//        response.sendRedirect(request.getContextPath() + "/login");

        return false;
    }
}
