package com.ki.interceptor;

import com.ki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

        System.out.println("RequestURL: " + request.getRequestURL());
        System.out.println("ContextPath: " + request.getContextPath());
        String uri = request.getScheme() + "://" +   // "http" + "://
                request.getServerName() +       // "myhost"
                ":" +                           // ":"
                request.getServerPort() +       // "8080"
                request.getRequestURI() +       // "/people"
                "?" +                           // "?"
                request.getQueryString();       // "lastname=Fox&age=30"

        String wantURL = request.getRequestURL()+"?"+request.getQueryString();
        System.out.println(wantURL);

//        String userName = (String)request.getAttribute("email");
//        String password = (String)request.getAttribute("password");
//        switch (request.getRequestURI().split("/")[0]) {
//            case "login":
//                UserEntity user = userRepository.findByUserEmailAndPassword(userName, password);
//                if (user == null) {
//                    System.out.println("Login Error");
////                    response.sendRedirect("/login");
////                    return false;
//                }
//                session.setAttribute("username", userName);
//                break;
//            default:
//                userName = (String)session.getAttribute("username");
//                if (userName == null) {
////                    response.sendRedirect("/login");
////                    return false;
//                }
////        }

        return true;
    }
}
