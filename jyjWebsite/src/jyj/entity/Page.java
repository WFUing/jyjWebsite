//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jyj.entity;

import java.util.List;

public class Page {
    private int curPage;
    private int pageSize;
    private int totalCount;
    private int totalPage;
    private List<Employee> employees;

    public Page() {
    }

    public Page(int curPage, int pageSize, int totalCount, int totalPage, List<Employee> employees) {
        this.curPage = curPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.employees = employees;
        this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
    }

    public int getCurPage() {
        return this.curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String toString() {
        return "Page [curPage=" + this.curPage + ", pageSize=" + this.pageSize + ", totalCount=" + this.totalCount + ", totalPage=" + this.totalPage + ", employees=" + this.employees + "]";
    }
}
