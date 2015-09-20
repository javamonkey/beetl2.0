package org.beetl.ext.nutz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.ext.web.WebRender;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.view.AbstractPathView;

public class BeetlView extends AbstractPathView {
    
    protected WebRender render;

    public BeetlView(WebRender render, String dest) {
        super(dest);
        this.render = render;
    }

    public void render(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Throwable {
        String child = evalPath(req, obj);
        if (child == null) {
            child = Mvcs.getActionContext().getPath();
        }
        if (obj != null && req.getAttribute("obj") == null)
            req.setAttribute("obj", obj);
        if (resp.getContentType() == null)
        	resp.setContentType("text/html");
        render.render(child, req, new LazyResponseWrapper(resp));
    }
}