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
import jyj.dao.ManagerDao;

public class ManaUpdPswServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ManaUpdPswServlet2() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String managerName = request.getParameter("managername");
        String password = request.getParameter("password");
        ManagerDao managerDao = new ManagerDao();
        if (managerDao.updatemanaPswByManagername(managerName, password)) {
            request.setAttribute("error", "");
            response.sendRedirect("Index.jsp");
        } else {
            request.setAttribute("error", "UpdateError");
            request.getRequestDispatcher("/ManaUpdPsw.jsp").forward(request, response);
        }

        this.doGet(request, response);
    }
}
