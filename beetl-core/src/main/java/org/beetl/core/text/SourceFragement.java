package org.beetl.core.text;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储的Beetl片段内容
 */
public class SourceFragement {
    List<Fragment> list = new ArrayList<Fragment>();
    int startLineIndex = 0;
    int startLine = 0;
    public void add(Fragment fr){
        list.add(fr);
        if(fr instanceof  CRFragment){
            trimSpace();
            moveNext(fr);
            return ;
        }

        if(fr.endLine!=startLine){
            //跨行的script
            trimSpace();
            moveNext(fr);
            return;
        }



    }

    /**
     * 下一次要比較的
     * @param fr
     */
    protected  void moveNext(Fragment fr){
        startLineIndex=list.size();
        if(fr instanceof CRFragment) {
        	 startLine=fr.endLine+1;
        }else {
        	 startLine=fr.endLine;
        }
       
    }
    
    

    /**
     *
     */
    public void merge(){
    	check();
        for(int i=0;i<list.size();i++){
            Fragment fr = list.get(i);
            if(fr.getStatus()==FragmentStatus.del){
                continue;
            }
            if(fr instanceof  TextFragment){
            	 TextFragment text = (TextFragment)fr;
                 
                 //往前看，合并CR和TextFragment
                 for(int z = i+1;z<list.size();z++){
                     Fragment nextFr = list.get(z);
                     if(nextFr instanceof  ScriptFragment || nextFr instanceof  PlaceHolderFragment){
                         i=z;
                         break;
                     }
                     nextFr.setStatus(FragmentStatus.del);
                     text.appendTextFragment(nextFr);
                     
                     

                 }
            }
           
        }
    }
    
    private void check() {
    	if(startLineIndex!=list.size()) {
    		//还有剩下的没有格式化
    		trimSpace();
    	}
    }

    /**
     * 格式化
     */
    protected  void trimSpace(){
        boolean hasScript = false;
        for(int i=startLineIndex;i<list.size();i++){
            Fragment fr = list.get(i);
            if(fr instanceof CRFragment){
                continue;
            }
            if(fr instanceof  PlaceHolderFragment){
                //有站位符，不需要过滤，全部输出
                return ;
            }

            if(fr instanceof TextFragment){
                TextFragment textFragment = (TextFragment)fr;
                if(!textFragment.onlySpace()){
                    return ;
                }else{
                    continue;
                }
            }
            //其他情况
            hasScript = true;
        }

        if(!hasScript){
            return ;
        }

        //脚本和文本混合
        Fragment lastScript = null;
        for(int i=startLineIndex;i<list.size();i++){
            Fragment fr = list.get(i);
            if(fr instanceof TextFragment){
                fr.setStatus(FragmentStatus.del);
            }else if(fr instanceof  CRFragment){
                if(lastScript!=null){
                    fr.setStatus(FragmentStatus.del);
                    ((ScriptFragment)lastScript).appendCr();
                }

            }else{
                lastScript = fr;
            }
        }

    }

	
    
}
