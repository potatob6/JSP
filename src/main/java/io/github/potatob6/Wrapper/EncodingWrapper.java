package io.github.potatob6.Wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * 编码包装器
 * 因为Tomcat默认编码为ISO-8859-1，重新包装成utf-8
 */
public class EncodingWrapper extends HttpServletRequestWrapper {
    public HttpServletRequest req;
    public EncodingWrapper(HttpServletRequest request) {
        super(request);
        req = request;
    }

    @Override
    public String getParameter(String name) {

        String s1 = super.getParameter(name);
        try {
            return new String(s1.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        } catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }
}
