package org.beetl.core.text;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储的Beetl片段内容
 */
public class SourceFragement {
    List<Fragment> list = new ArrayList<Fragment>();
    int currentLine = 0;

    int startLineIndex = 0;

    public void add(Fragment fr){
        list.add(fr);
        if(fr instanceof  CRFragment){
            trimSpace();
            startLineIndex=list.size();
        }

    }

    /**
     *
     */
    public void merge(){
        for(int i=0;i<list.size();i++){
            Fragment fr = list.get(i);
            if(fr.status==FragmentStatus.del){
                continue;
            }
            if(!(fr instanceof  TextFragment) ){
                continue;
            }

            //往前看，合并CR和TextFragment
            for(int z = i;z<list.size();z++){
                Fragment nextFr = list.get(z);
                if(nextFr instanceof  ScriptFragment || nextFr instanceof  PlaceHolderFragment){
                    i=z;
                    break;
                }

            }
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
                if(!textFragment.hashSpace()){
                    return ;
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
                fr.status = FragmentStatus.del;
            }else if(fr instanceof  CRFragment){
                fr.status = FragmentStatus.del;
                lastScript.appendCr();

            }else{
                lastScript = fr;
            }
        }

    }
}
