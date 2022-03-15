package io.github.potatob6.Wrapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class EncodingResponse extends HttpServletResponseWrapper {
    public HttpServletResponse httpServletResponse;
    public EncodingResponse(HttpServletResponse response) {
        super(response);
        httpServletResponse = response;
    }
    public void println(String n) {
        String string = new String(n.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        try {
            this.getOutputStream().println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
