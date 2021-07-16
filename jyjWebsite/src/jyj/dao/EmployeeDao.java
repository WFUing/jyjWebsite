//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jyj.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jyj.entity.Employee;

public class EmployeeDao {
    public EmployeeDao() {
    }

    public boolean isExist(int empNo) {
        return this.queryEmpByEmpNo(empNo) != null;
    }

    public boolean addEmp(Employee employee) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "insert into JYJ3621.employees(emp_no,birth_date,name,gender,hire_date) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, employee.getEmpNo());
            Date date = new Date(employee.getBirthDay().getTime());
            ps.setDate(2, date);
            ps.setString(3, employee.getName());
            ps.setString(4, employee.getGender());
            date = new Date(employee.getHireDate().getTime());
            ps.setDate(5, date);
            count = ps.executeUpdate();
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps);
        }

        return count > 0;
    }

    public boolean deleteEmpByEmpNo(int EmpNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "delete from JYJ3621.employees where emp_no=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, EmpNo);
            count = ps.executeUpdate();
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps);
        }

        return count > 0;
    }

    public boolean updateEmpByEmpNo(int EmpNo, Employee employee) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "update JYJ3621.employees set emp_no=?,birth_date=?,name=?,gender=?,hire_date=? where emp_no=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, employee.getEmpNo());
            Date date = new Date(employee.getBirthDay().getTime());
            ps.setDate(2, date);
            ps.setString(3, employee.getName());
            ps.setObject(4, employee.getGender());
            date = new Date(employee.getHireDate().getTime());
            ps.setDate(5, date);
            ps.setInt(6, employee.getEmpNo());
            count = ps.executeUpdate();
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps);
        }

        return count > 0;
    }

    public Employee queryEmpByEmpNo(int EmpNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employee employee = null;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "select * from JYJ3621.employees where emp_no=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, EmpNo);
            rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setEmpNo(rs.getInt("emp_no"));
                employee.setName(rs.getString("name"));
                employee.setGender(rs.getString("gender"));
                java.util.Date date = new Date(rs.getDate("birth_date").getTime());
                employee.setBirthDay(date);
                date = new Date(rs.getDate("hire_date").getTime());
                employee.setHireDate(date);
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps, rs);
        }

        return employee;
    }

    public List<Employee> queryAllEmployees() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Employee> employees = null;
        Employee employee = null;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "select * from JYJ3621.employees";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            employees = new ArrayList();

            while(rs.next()) {
                employee = new Employee();
                employee.setEmpNo(rs.getInt("emp_no"));
                employee.setName(rs.getString("name"));
                employee.setGender(rs.getString("gender"));
                java.util.Date date = new Date(rs.getDate("birth_date").getTime());
                employee.setBirthDay(date);
                date = new Date(rs.getDate("hire_date").getTime());
                employee.setHireDate(date);
                employees.add(employee);
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps, rs);
        }

        return employees;
    }

    public List<Employee> queryEmpByPage(int now, int num) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Employee> employees = null;
        Employee employee = null;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "SELECT * FROM JYJ3621.employees LIMIT ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, now);
            ps.setInt(2, num);
            rs = ps.executeQuery();
            employees = new ArrayList();

            while(rs.next()) {
                employee = new Employee();
                employee.setEmpNo(rs.getInt("emp_no"));
                employee.setName(rs.getString("name"));
                employee.setGender(rs.getString("gender"));
                java.util.Date date = new Date(rs.getDate("birth_date").getTime());
                employee.setBirthDay(date);
                date = new Date(rs.getDate("hire_date").getTime());
                employee.setHireDate(date);
                employees.add(employee);
            }
        } catch (Exception var13) {
            var13.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps, rs);
        }

        return employees;
    }

    public int getTotalCount() {
        int count = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "select count(1) from JYJ3621.employees";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps, rs);
        }

        return count;
    }
}
