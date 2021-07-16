//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jyj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jyj.entity.Manager;

public class ManagerDao {
    public ManagerDao() {
    }

    public boolean isExist(int id) {
        return this.querymanagerById(id) != null;
    }

    public boolean isExist(String managerName) {
        return this.querymanagerByManagername(managerName) != null;
    }

    public boolean addManager(Manager manager) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "insert into JYJ3621.managerInfo(id,managerName,password,email) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, manager.getId());
            ps.setString(2, manager.getManagerName());
            ps.setString(3, manager.getPassword());
            ps.setString(4, manager.getEmail());
            count = ps.executeUpdate();
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps);
        }

        return count > 0;
    }

    public boolean deletemanagerBymanagername(String managerName) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "delete from JYJ3621.managerInfo where managerName=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, managerName);
            count = ps.executeUpdate();
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps);
        }

        return count > 0;
    }

    public boolean updatemanagerById(int id, Manager manager) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "update JYJ3621.managerInfo set id=?,managerName=?,password=?,email=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, manager.getId());
            ps.setString(2, manager.getManagerName());
            ps.setString(3, manager.getPassword());
            ps.setString(4, manager.getEmail());
            ps.setInt(5, id);
            count = ps.executeUpdate();
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps);
        }

        return count > 0;
    }

    public boolean updatemanaPswByManagername(String managerName, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "update JYJ3621.managerInfo set password=? where managerName=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, pwd);
            ps.setString(2, managerName);
            count = ps.executeUpdate();
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps);
        }

        return count > 0;
    }

    public boolean updatemanagerByManagername(String managerName, Manager manager) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "update JYJ3621.managerInfo set id=?,managername=?,password=?,email=? where managerName=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, manager.getId());
            ps.setString(2, manager.getManagerName());
            ps.setString(3, manager.getPassword());
            ps.setString(4, manager.getEmail());
            ps.setString(5, managerName);
            count = ps.executeUpdate();
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps);
        }

        return count > 0;
    }

    public Manager querymanagerById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Manager manager = null;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "select * from JYJ3621.managerInfo where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setManagerName(rs.getString("managerName"));
                manager.setPassword(rs.getString("password"));
                manager.setEmail(rs.getString("email"));
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps, rs);
        }

        return manager;
    }

    public Manager querymanagerByManagername(String managerName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Manager manager = null;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "select * from JYJ3621.managerInfo where managername=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, managerName);
            rs = ps.executeQuery();
            if (rs.next()) {
                manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setManagerName(rs.getString("managerName"));
                manager.setPassword(rs.getString("password"));
                manager.setEmail(rs.getString("email"));
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps, rs);
        }

        return manager;
    }

    public Manager querymanagerByEmail(String email) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Manager manager = null;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "select * from JYJ3621.managerInfo where email=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setManagerName(rs.getString("managerName"));
                manager.setPassword(rs.getString("password"));
                manager.setEmail(rs.getString("email"));
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps, rs);
        }

        return manager;
    }

    public List<Manager> queryAllmanager() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Manager> managers = null;
        Manager manager = null;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "select * from JYJ3621.managerInfo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                managers = new ArrayList();
                manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setManagerName(rs.getString("managername"));
                manager.setPassword(rs.getString("password"));
                manager.setEmail(rs.getString("email"));
                managers.add(manager);
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps, rs);
        }

        return managers;
    }

    public Manager checkLogin(String managerName, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Manager manager = null;

        try {
            conn = DataBaseUtils.getConnection();
            String sql = "select * from JYJ3621.managerInfo where managerName=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, managerName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setManagerName(rs.getString("managerName"));
                manager.setPassword(rs.getString("password"));
                manager.setEmail(rs.getString("email"));
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            DataBaseUtils.closeResource(conn, ps, rs);
        }

        return manager;
    }
}
