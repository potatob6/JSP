package io.github.yywl5.Servlets;

import io.github.yywl5.Dao.DaoUtils;
import io.github.yywl5.Models.UserBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DownListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "select * from netdisk;";
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        List<UserBean> list = null;
        try {
            list = runner.query(sql, new BeanListHandler<UserBean>(UserBean.class));

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        request.setAttribute("list", list);
        request.getRequestDispatcher("downlist.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
