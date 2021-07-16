//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jyj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jyj.entity.Manager;

public class ManaUpdPswServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ManaUpdPswServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Manager manager = (Manager)session.getAttribute("manager");
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if (manager != null) {
            if (id != manager.getId()) {
                request.setAttribute("error", "IdError");
                request.getRequestDispatcher("/ManaUpdPsw.jsp").forward(request, response);
            } else if (!password.equals(manager.getPassword())) {
                request.setAttribute("error", "PswError");
                request.getRequestDispatcher("/ManaUpdPsw.jsp").forward(request, response);
            } else if (!email.equals(manager.getEmail())) {
                request.setAttribute("error", "EmailError");
                request.getRequestDispatcher("/ManaUpdPsw.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "NoError");
                request.getRequestDispatcher("/ManaUpdPsw.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "TimeError");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }

        this.doGet(request, response);
    }
}
