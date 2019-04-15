package org.beetl.core;

import java.util.concurrent.ArrayBlockingQueue;

/**TODO3，需要性能压测
 * 模板渲染和计算中需要的临时存储空间，缓存以提高性能
 */
public class ContextLocalBuffers {
    ArrayBlockingQueue<ContextBuffer> queue = null;
    int bufferMax;
    public ContextLocalBuffers(int num,int bufferMax){
        this.bufferMax = bufferMax;
        queue = new ArrayBlockingQueue<ContextBuffer>(num);
        for(int i=0;i<num;i++){
            ContextBuffer buffer = new ContextBuffer(bufferMax,true);
            queue.add(buffer);
        }
    }

    public ContextBuffer getContextLocalBuffer(){
        ContextBuffer buffer =  queue.poll();
        if(buffer!=null){
            return buffer;
        }
        //临时
        return new ContextBuffer(bufferMax,false);

    }

    public  void putContextLocalBuffer(ContextBuffer buffer){

        if(!buffer.inner){
            //放弃，这是临时生成的
          return ;
        }

        queue.add(buffer);



    }

}
