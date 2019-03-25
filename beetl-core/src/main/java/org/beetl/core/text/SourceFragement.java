package org.beetl.core.text;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储的Beetl片段内容
 */
public class SourceFragement {
    List<Fragment> list = new ArrayList<Fragment>();
    int currentLine = 0;
    int currentIndx = 0;
    int startLineIndex = 0;

    public void add(Fragment fr){
        list.add(fr);
        currentIndx++;
        if(fr instanceof  CRFragment){
            trimSpacce();
        }
        if(fr.endLine)

    }

    /**
     * 格式化
     */
    protected  void trimSpacce(){
        boolean hasScript = false;
        for(int i=startLineIndex;i<currentIndx;i++){
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
            }else {
                hasScript = true;
            }
        }

        if(!hasScript){
            return ;
        }
        for(int i=startLineIndex;i<currentIndx;i++){
            Fragment fr = list.get(startLineIndex);
            if(fr instanceof TextFragment){
                fr.status = FragmentStatus.del;
            }else if(fr instanceof  CRFragment){
                fr.status = FragmentStatus.del;
            }
        }

    }
}
