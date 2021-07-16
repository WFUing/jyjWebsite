//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jyj.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jyj.dao.EmployeeDao;
import jyj.entity.Employee;

public class EmpUpdInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmpUpdInfoServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        int EmpNo = Integer.parseInt(request.getParameter("empNo"));
        String name = request.getParameter("name");
        Date hireDay = null;
        Date birthDay = null;

        try {
            hireDay = (new SimpleDateFormat("yyyy-MM-dd")).parse(request.getParameter("hireday"));
            birthDay = (new SimpleDateFormat("yyyy-MM-dd")).parse(request.getParameter("birthday"));
        } catch (ParseException var10) {
            var10.printStackTrace();
        }

        String gender = request.getParameter("gender");
        Employee employee = new Employee(EmpNo, name, gender, birthDay, hireDay);
        EmployeeDao employeeDao = new EmployeeDao();
        if (employeeDao.updateEmpByEmpNo(EmpNo, employee)) {
            response.sendRedirect(request.getContextPath() + "/EmpQueryByPageServlet");
        } else {
            request.setAttribute("error", "UpdError");
            request.getRequestDispatcher("/EmpQueryByPageServlet").forward(request, response);
        }

        this.doGet(request, response);
    }
}
