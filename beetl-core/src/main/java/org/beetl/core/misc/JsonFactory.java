package org.beetl.core.misc;

public class JsonFactory {
    static JsonTool tool = null;
    static{
        try{
            tool = new JacksonTool();
        }catch(Throwable ex){
            //类不加载
        }
        if(tool==null){
            try{
                tool = new FastJsonTool();
            }catch(Throwable ex){
                //类不加载
            }
        }

        if(tool==null){
            throw new IllegalStateException("沒有对应的jackson或者fastjson库");
        }


    }

    public static JsonTool get(){
        return tool;
    }
}
