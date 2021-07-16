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
import jyj.dao.EmployeeDao;

public class EmpDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmpDeleteServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        EmployeeDao employeeDao = new EmployeeDao();
        int EmpNo = Integer.parseInt(request.getParameter("EmpNo"));
        String pSize = request.getParameter("pageSize");
        if (pSize == null) {
            pSize = "3";
        }

        int pageSize = Integer.parseInt(pSize);
        if (employeeDao.deleteEmpByEmpNo(EmpNo)) {
            response.sendRedirect("./EmpQueryByPageServlet?pageSize=" + pageSize);
        } else {
            request.setAttribute("error", "DeleteError");
            request.getRequestDispatcher("/EmpQueryByPageServlet").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
