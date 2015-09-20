package org.beetl.ext.nutz;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class LazyResponseWrapper extends HttpServletResponseWrapper {

    public LazyResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    /**
     * 代理getOutputStream,真正write的时候才获取
     */
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream() {
            protected OutputStream proxy;
            public void write(int b) throws IOException {
                if (proxy == null)
                    proxy = getResponse().getOutputStream();
                proxy.write(b);
            }
            
            public void write(byte[] paramArrayOfByte, int off, int len)
                    throws IOException {
                if (proxy == null)
                    proxy = getResponse().getOutputStream();
                proxy.write(paramArrayOfByte, off, len);
            }
        };
    }
}
