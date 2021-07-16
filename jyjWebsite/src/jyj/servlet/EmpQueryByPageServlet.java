//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jyj.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jyj.dao.EmployeeDao;
import jyj.entity.Employee;
import jyj.entity.Page;

public class EmpQueryByPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmpQueryByPageServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao employeeDao = new EmployeeDao();
        int count = employeeDao.getTotalCount();
        String cPage = request.getParameter("curPage");
        if (cPage == null) {
            cPage = "1";
        }

        int curPage = Integer.parseInt(cPage);
        Page page = new Page();
        page.setTotalCount(count);
        String pSize = request.getParameter("pageSize");
        if (pSize == null) {
            pSize = "3";
        }

        int pageSize = Integer.parseInt(pSize);
        page.setPageSize(pageSize);
        List<Employee> employees = employeeDao.queryEmpByPage((curPage - 1) * pageSize, pageSize);
        page.setEmployees(employees);
        page.setCurPage(curPage);
        request.setAttribute("p", page);
        request.getRequestDispatcher("EmpIndex.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
