package org.beetl.ext.tag;

import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.BodyContent;
import org.beetl.core.Template;
import org.beetl.ext.fn.RenderTagBodyFunction;

public class HTMLTagSupportWrapper2 extends HTMLTagSupportWrapper {
    protected void callHtmlTag(String path) {
        Template t = null;

        t = gt.getHtmlFunctionOrTagTemplate(path, this.ctx.getResourceId());

        t.binding(ctx.globalVar);
        t.dynamic(ctx.objectKeys);

        if (args.length == 2) {
            Map<String, Object> map = (Map<String, Object>)args[1];
            for (Entry<String, Object> entry : map.entrySet()) {
                t.binding(entry.getKey(), entry.getValue());

            }
        }
        /*
                 *  模板需要调用方法  ${getTagBody(innerTag)},与默认实现不同，并没有先渲染body体，而是延迟处理， 等待调用的时候在获取tag体内容
           参考getTagBody实现类RenderTagBody
         */
        t.binding("innerTag", new RenderTagBodyFunction.TagContentRunner() {

            @Override
            public BodyContent run() {
                return HTMLTagSupportWrapper2.super.getBodyContent();
            }
        });

        t.renderTo(ctx.byteWriter);
    }
}
