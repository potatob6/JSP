package io.github.yywl5.Servlets;

import io.github.yywl5.Dao.DaoUtils;
import io.github.yywl5.Dao.IOUtils;
import io.github.yywl5.Models.UserBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.sql.SQLException;

/**
 * @author 星包客
 */
public class DownServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String sql = "select * from netdisk where id=?";
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        UserBean r = null;
        try {
            r = runner.query(sql, new BeanHandler<UserBean>(UserBean.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (r == null) {
            response.getWriter().write("对不起，资源不存在了");
            return;
        } else {
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(r.getRealname(), "utf-8"));
            response.setContentType(this.getServletContext().getMimeType(
                    r.getRealname()));

            String filepath = this.getServletContext().getRealPath(
                    r.getSavepath() + "/" + r.getUuidname());
            InputStream in = new FileInputStream(new File(filepath));
            OutputStream out = response.getOutputStream();
            IOUtils.In2Out(in, out);
            IOUtils.close(in, out);
            IOUtils.close(in, null);
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
