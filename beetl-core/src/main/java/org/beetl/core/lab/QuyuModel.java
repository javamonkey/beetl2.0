package org.beetl.core.lab;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

public class QuyuModel {
    private String yAreaInfo;
    private String URL;
    private String Name="aa";

    public static void main(String[] args) throws Exception {
        QuyuModel bean = new QuyuModel();
        bean.setyAreaInfo("是不是BUG？");

        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("${bean.yAreaInfo}-${bean.Name} -${bean.URL}");
        t.binding("bean", bean);
        String str = t.render();
        System.out.println(str);
    }

    public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getyAreaInfo() {
        return yAreaInfo;
    }

    public void setyAreaInfo(String yAreaInfo) {
        this.yAreaInfo = yAreaInfo;
    }

    
}