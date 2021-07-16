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

public class RegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String clientCheckcode = request.getParameter("validateCode");
        String serverCheckcode = (String)request.getSession().getAttribute("checkcode");
        int id = Integer.parseInt(request.getParameter("id"));
        String managername = request.getParameter("managername");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Manager manager = new Manager(id, managername, password, email);
        ManagerDao managerDao = new ManagerDao();
        if (clientCheckcode.equals(serverCheckcode)) {
            if (managerDao.isExist(id)) {
                request.setAttribute("error", "ReIdError");
                request.getRequestDispatcher("/Regist.jsp").forward(request, response);
            } else if (managerDao.isExist(managername)) {
                request.setAttribute("error", "ReNameError");
                request.getRequestDispatcher("/Regist.jsp").forward(request, response);
            } else if (managerDao.addManager(manager)) {
                HttpSession session = request.getSession();
                session.setAttribute("manager", manager);
                response.sendRedirect("./Index.jsp");
            } else {
                request.setAttribute("error", "AddError");
                request.getRequestDispatcher("/Regist.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "ImageError");
            request.getRequestDispatcher("/Regist.jsp").forward(request, response);
        }

        this.doGet(request, response);
    }
}
