package org.beetl.core.text;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FragmentFormmater {
	List<Fragment> list;
	public FragmentFormmater(List<Fragment> list) {
		this.list = list;
	}
	
	public void format() {
		ListIterator<Fragment> it = list.listIterator();
        while (it.hasNext()) {
         
          
        }
	}
	
	protected ScriptFragment findScript(ListIterator<Fragment> it) {
		 while (it.hasNext()) {
	            Fragment fragment = it.next();
	            if (fragment instanceof ScriptFragment) {
	            	return (ScriptFragment)fragment;
	            }
	     }
		 return null;
	}
	
//	protected ScriptFragment findMoreScript(ScriptFragment first,ListIterator<Fragment> it) {
//		Fragment last = null;
//		 while (it.hasNext()) {
//	            Fragment fragment = it.next();
//	            if(fragment instanceof ScriptFragment && fragment.startLine==first.startLine) {
//	            	last = fragment;
//	            }
//	           
//	     }
//		 return last;
//	}
	
	

    protected Fragment getPrevious(ListIterator<Fragment> it) {
        if (it.hasPrevious()) {
            Fragment fragment = it.previous();
            // reset
            it.next();
            return fragment;
        }
        return null;
    }

    protected boolean inSameLine(Fragment previous, Fragment fragement) {
        return previous.endLine == fragement.startLine;
    }
    
    class LineStatus {
    	
    	List<Fragment> list = new ArrayList<Fragment>(8);
    	boolean hasScript = false;
    	boolean hasHolder = false;
    	boolean hasText = false;
    	public void add(Fragment fr) {
    		list.add(fr);
    		if(fr instanceof ScriptFragment) {
    			hasScript=true;
    		}else if(fr instanceof PlaceHolderFragment) {
    			hasHolder = true;
    		}else if(fr instanceof TextFragment){
    			hasText = true;
    		}else {
    			throw new RuntimeException();
    		}
    	}
    	public void reset() {
    		list.clear();
    		hasScript = false;
    		hasHolder = false;
    		hasText = false;
    	}
    	
    	public void format() {
    		//以下情况不需要格式化
    		if(!hasScript) {
    			return ;
    		}
    		if(!hasText) {
    			return ;
    		}
    		
    		if(hasHolder) {
    			return ;
    		}
    		
    		//格式化
    		if(list.get(0) instanceof TextFragment) {
    			((TextFragment)list.get(0) ).format();
    		}
    		
    		if(list.get(list.size()-1) instanceof TextFragment ) {
    			((TextFragment)list.get(list.size()-1) ).format();
    		}
    		
    	}
    }
}
