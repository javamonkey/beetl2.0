package org.beetl.core.misc;

import com.alibaba.fastjson.JSON;

public class FastJsonTool implements  JsonTool{

    public FastJsonTool(){
        //just test FastJSON in classpath
        String str = JSON.toJSONString(new Object());
    }

    @Override
    public String render(Object o) {
        return JSON.toJSONString(o);
    }
}
