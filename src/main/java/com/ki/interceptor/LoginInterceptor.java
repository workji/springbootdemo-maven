package com.ki.interceptor;

import com.ki.entity.UserEntity;
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
        HttpSession session = request.getSession();
        String urlPath = request.getRequestURI();
        String preUrl = (String)session.getAttribute("preUrl");

        // when logout remove session flg
        if (urlPath.startsWith("/logout")) {
            session.removeAttribute("user");
            // reload to login page
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
         }

        // already login -> OK
        if (session.getAttribute("user") != null) {
            session.removeAttribute("preUrl");
            preUrl = null;
            return true;
        }

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
                    session.setAttribute("user", user);
                    response.sendRedirect(request.getContextPath() + (preUrl!=null?preUrl:"/"));
                    return false;
                } else {
                    // login error
                    response.sendRedirect(request.getContextPath() + "/login");
                    return false;
                }
            }
        }

        // save pre url for login success to redirect
        session.setAttribute("preUrl", urlPath);
        // other Not logged path reload to login page
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }
}
