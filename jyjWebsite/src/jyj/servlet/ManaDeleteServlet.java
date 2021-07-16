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
import jyj.dao.ManagerDao;
import jyj.entity.Manager;

public class ManaDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ManaDeleteServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Manager manager = (Manager)session.getAttribute("manager");
        ManagerDao managerDao = new ManagerDao();
        if (managerDao.deletemanagerBymanagername(manager.getManagerName())) {
            response.sendRedirect(request.getContextPath() + "/Login.jsp");
        } else {
            request.setAttribute("error", "DeleteError");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
