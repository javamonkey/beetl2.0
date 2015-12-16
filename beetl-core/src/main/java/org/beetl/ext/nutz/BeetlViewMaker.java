package org.beetl.ext.nutz;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.misc.BeetlUtil;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.web.WebRender;
import org.nutz.ioc.Ioc;
import org.nutz.lang.Streams;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.View;
import org.nutz.mvc.ViewMaker;

/**
 * <p>Beelt for Nutz</p>
 * <b>使用方法</b><p></p>
 * <code>
 * @Views(BeetlViewMaker.class) <p></p>
 * 
 * @Ok("beetl:/hello.html")
 * </code><p/>
 * <b>本实现的默认配置</b><p></p>
 * <code>
 * RESOURCE_LOADER=org.beetl.core.resource.WebAppResourceLoader <p></p>
 * DIRECT_BYTE_OUTPUT=true <p></p>
 * ERROR_HANDLER=org.beetl.ext.nutz.LogErrorHandler <p></p>
 * </code><p></p>
 * @author wendal
 * 
 */
public class BeetlViewMaker implements ViewMaker {
    
    private static final Log log = Logs.get();

    public GroupTemplate groupTemplate;
    
    public WebRender render;
    
    public BeetlViewMaker() throws IOException {
        // 主动设置webroot, 解决maven项目下,Beetl无法找到正确的webapp路径的问题
    		String webroot = null;
    		if(Mvcs.getServletContext()!=null){
    			webroot = Mvcs.getServletContext().getRealPath("/");
    	        if (!Strings.isBlank(webroot))
    	            BeetlUtil.setWebroot(webroot);
        }
    		 
        init();
    }
    
    public void init() throws IOException {
        log.debug("beetl init ....");
        Configuration cfg = Configuration.defaultConfiguration();
        Properties prop = new Properties();
        InputStream ins = Configuration.class.getResourceAsStream("/beetl.properties");
        if (ins != null) {
            log.debug("found beetl.properties, loading ...");
            try {
                prop.load(ins);
            }
            finally {
                Streams.safeClose(ins);
            }
        }
        if (!prop.containsKey(Configuration.RESOURCE_LOADER)) {
            // 默认选用WebAppResourceLoader,除非用户自定义了RESOURCE_LOADER
            log.debug("no custom RESOURCE_LOADER found , select WebAppResourceLoader");
            cfg.setResourceLoader(WebAppResourceLoader.class.getName());
        }
        if (!prop.containsKey(Configuration.DIRECT_BYTE_OUTPUT)) {
            // 默认启用DIRECT_BYTE_OUTPUT,除非用户自定义, 一般不会.
            log.debug("no custom DIRECT_BYTE_OUTPUT found , set to true");
            // 当DIRECT_BYTE_OUTPUT为真时, beetl渲染会通过getOutputStream获取输出流
            // 而BeetlView会使用LazyResponseWrapper代理getOutputStream方法
            // 从而实现在模板输出之前,避免真正调用getOutputStream
            // 这样@Fail视图就能正常工作了
            cfg.setDirectByteOutput(true);
        }
        if (!prop.containsKey(Configuration.ERROR_HANDLER)) {
            // 没有自定义ERROR_HANDLER,用定制的
            cfg.setErrorHandlerClass(LogErrorHandler.class.getName());
        }
        groupTemplate = new GroupTemplate(cfg);
        render = new WebRender(groupTemplate);
        log.debug("beetl init complete");
    }

    public void depose() {
        if (groupTemplate != null)
            groupTemplate.close();
    }

    public View make(Ioc ioc, String type, String value) {
        if ("beetl".equals(type))
            return new BeetlView(render, value);
        return null;
    }
}
