package org.beetl.ext.nutz;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;
import org.beetl.core.exception.BeetlException;
import org.nutz.mvc.View;

import junit.framework.TestCase;

public class BeetlViewMakerTest extends TestCase {
    
    BeetlViewMaker maker;
    MapResourceLoader loader;

    protected void setUp() throws Exception {
        maker = new BeetlViewMaker();
        loader = new MapResourceLoader();
        maker.groupTemplate.setResourceLoader(loader);
    }

    protected void tearDown() throws Exception {
        if (maker != null){
            maker.depose();
        }
    }

    public void test_view_render() throws Throwable {
        // 存入模板
        loader.put("/hello", "${obj.array.~size},${obj.array[0]}");
        
        // 创建视图
        View view = maker.make(null, "beetl", "/hello");
        
        // 准备好返回值
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("array", new String[]{"http://wendal.net"});
        
        // 用于接收视图渲染的结果
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        // mock出req和resp
        HttpServletRequest req = mockReq(map);
        HttpServletResponse resp = mockResp(out);
        
        // 渲染
        view.render(req, resp, map);
        
        // 对比结果
        assertEquals("1,http://wendal.net", new String(out.toByteArray()));
    }

    protected HttpServletResponse mockResp(final OutputStream out) throws IOException {
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(resp.getOutputStream()).thenReturn(new ServletOutputStream() {
            public void write(int b) throws IOException {
                out.write(b);
            }
        });
        return resp;
    }
    
    protected HttpServletRequest mockReq(final Object re) {
        HttpServletRequest req = mock(HttpServletRequest.class);
        List<String> names = new ArrayList<String>();
        names.add("obj");
        when(req.getAttributeNames()).thenReturn(Collections.enumeration(names));
        when(req.getAttribute("obj")).thenReturn(re);
        return req;
    }
}

class MapResourceLoader extends HashMap<String, String> implements ResourceLoader {
    
    private static final long serialVersionUID = 5361058943317379270L;
    
    public boolean isModified(Resource key) {
        return true;
    }
    public void init(GroupTemplate gt) {}
    public String getResourceId(Resource resource, String key) {
        return key;
    }
    public Resource getResource(final String key) {
        return new Resource(key, this) {
            public Reader openReader() {
                String val = get(key);
                if (val == null) {
                    BeetlException ex = new BeetlException(BeetlException.TEMPLATE_LOAD_ERROR);
                    ex.resourceId = key;
                    throw ex;
                }
                return new StringReader(val);
            }
            
            public boolean isModified() {
                return true;
            }
        };
    }
    public boolean exist(String key) {
        return containsKey(key);
    }
    public void close() {}
}
