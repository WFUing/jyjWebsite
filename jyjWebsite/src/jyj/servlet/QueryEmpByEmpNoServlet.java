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
import jyj.entity.Employee;

public class QueryEmpByEmpNoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QueryEmpByEmpNoServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        int EmpNo = Integer.parseInt(request.getParameter("EmpNo"));
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.queryEmpByEmpNo(EmpNo);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("EmpInfo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

