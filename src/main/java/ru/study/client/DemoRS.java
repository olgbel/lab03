package ru.study.client;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "start", urlPatterns = {"/start"})
public class DemoRS //extends HttpServlet
{

//    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
//        try (PrintWriter out = response.getWriter()) {
//            if (user == null || user.trim().isEmpty()) {
//                out.println(formStart(ERROR_LOGIN));
//                return;
//            }
//            HttpSession hs = request.getSession();
//            hs.setAttribute("user", user);
//            out.println(formMain(null));
//        }
    }

//    private String formStart(String message) {
//        StringBuilder sb = new StringBuilder(HEADER).append(START_FORM);
//        // Если сообщение не null, то оно добавляется на страницу
//        if (message != null) {
//            sb.append("<p style='color:red;'>").append(message)
//                    .append("</p>");
//        }
//        sb.append(FOOTER);
//        return sb.toString();
//    }
//
//    private String formMain(String message) {
//        StringBuilder sb = new StringBuilder(HEADER).append(MAIN_FORM);
//        // Если сообщение не null, то оно добавляется на страницу
//        if (message != null) {
//            sb.append("<p>Reply: ").append(message).append("</p>\n");
//        }
//        sb.append(FOOTER);
//        return sb.toString();
//    }
}
