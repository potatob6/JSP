package io.github.yywl5.Servlets;

import io.github.yywl5.Dao.DaoUtils;
import io.github.yywl5.Dao.IOUtils;
import io.github.yywl5.Dao.C3p0Test;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import io.github.yywl5.Models.UserBean;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1.上传文件
            // 设置文件上传的路径和临时路径
            String upload = this.getServletContext().getRealPath("/WEB-INF/upload");
            String temp = this.getServletContext().getRealPath("/WEB-INF/temp");

            Map pmap = new HashMap();
            pmap.put("ip", request.getRemoteAddr());
            // 创建工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 设置内存
            factory.setSizeThreshold(1024 * 1024 * 100);
            // 设置临时目录
            factory.setRepository(new File(temp));

            ServletFileUpload fileupload = new ServletFileUpload(factory);
            // 防止文件中文名乱码
            fileupload.setHeaderEncoding("utf-8");
            // 设置单个文件最大值
            fileupload.setFileSizeMax(1024 * 1024 * 1024 );
            // 设置总文件最大值
            fileupload.setSizeMax(1024 * 1024 * 1024 );
            // 检查表单是否正确
            if (!ServletFileUpload.isMultipartContent(request)) {
                throw new RuntimeException("表单不正确");
            }

            List<FileItem> list = fileupload.parseRequest(request);
            for (FileItem item : list) {
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString("utf-8");
                    pmap.put(name, value);
                } else {
                    // 获取文件名
                    String realname = item.getName();
                    // 设置文件的UUID文件名，防止文件名重复
                    String uuidname = UUID.randomUUID().toString() + "_"
                            + realname;
                    // 计算uuid哈希值
                    String hash = Integer.toHexString(uuidname.hashCode());
                    String savepath = "/WEB-INF/upload";
                    pmap.put("realname", realname);
                    pmap.put("uuidname", uuidname);

                    InputStream in = item.getInputStream();

                    for (char c : hash.toCharArray()) {
                        // 根据哈希值分布存储
                        upload += "/" + c;
                        savepath += "/" + c;
                    }
                    new File(upload).mkdirs();
                    pmap.put("savepath", savepath);

                    OutputStream out = new FileOutputStream(new File(upload,
                            uuidname));
                    IOUtils.In2Out(in, out);
                    IOUtils.close(in, out);
                    // 删除临时文件
                    item.delete();
                }
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = df.format(new Date());
            Timestamp ts = Timestamp.valueOf(time);
            // 2.向数据库写入数据
            UserBean r = new UserBean();
            BeanUtils.populate(r, pmap);
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            String sql = "insert into netdisk values (null,?,?,?,?,?,?,?)";
            runner.update(sql, r.getUuidname(), r.getRealname(),
                    r.getSavepath(),r.getUploadtime(),r.getDescription(), r.getIp(),r.getUsernickname());
            // 3.重定向回主页
            response.sendRedirect("upload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
