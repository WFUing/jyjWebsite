//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jyj.servlet;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DownloadServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String fileName = request.getParameter("filename");
        response.addHeader("content-Type", "application/octet-stream");
        response.addHeader("content-Disposition", "attachement;filename=" + fileName);
        InputStream in = this.getServletContext().getResourceAsStream("/images/" + fileName);
        ServletOutputStream out = response.getOutputStream();
        byte[] bs = new byte[10];
        boolean var7 = true;

        int len;
        while((len = in.read(bs)) != -1) {
            out.write(bs, 0, len);
        }

        out.close();
        in.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
