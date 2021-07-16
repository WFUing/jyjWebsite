//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jyj.entity;

public class Manager {
    private int id;
    private String managerName;
    private String password;
    private String email;

    public Manager() {
    }

    public Manager(int id, String managerName, String password, String email) {
        this.id = id;
        this.managerName = managerName;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManagerName() {
        return this.managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "MangerDao [id=" + this.id + ", managerName=" + this.managerName + ", password=" + this.password + ", email=" + this.email + "]";
    }
}
