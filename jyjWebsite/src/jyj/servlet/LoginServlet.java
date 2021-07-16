//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jyj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jyj.dao.ManagerDao;
import jyj.entity.Manager;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String managerName = request.getParameter("managerName");
        String password = request.getParameter("password");
        String tenDayAutoLoginFlag = request.getParameter("tenDayAutoLoginFlag");
        ManagerDao managerDao = new ManagerDao();
        Manager manager = managerDao.checkLogin(managerName, password);
        if (manager != null) {
            managerDao.queryAllmanager();
            HttpSession session = request.getSession();
            session.setAttribute("manager", manager);
            session.setMaxInactiveInterval(1800);
            if ("ok".equals(tenDayAutoLoginFlag)) {
                Cookie nameCookie = new Cookie("username", managerName);
                nameCookie.setMaxAge(864000);
                Cookie pwdCookie = new Cookie("password", password);
                pwdCookie.setMaxAge(864000);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }

            response.sendRedirect(request.getContextPath() + "/Index.jsp");
        } else {
            request.setAttribute("error", "LoginError");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }

        this.doGet(request, response);
    }
}
