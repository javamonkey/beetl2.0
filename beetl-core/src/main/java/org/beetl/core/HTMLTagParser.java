package org.beetl.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于解析htmltag，转化成宏调用
 * @author joelli
 * @create 2013-6-12
 */
public class HTMLTagParser {

	int index = 0;
	char[] cs = null;
	boolean isStart;
	String tagName = null;
	boolean isEmptyTag = false;
	Map<String, String> expMap = new HashMap<String, String>();
	Map<String, Character> quatMap = new HashMap<String, Character>();

	public HTMLTagParser(char[] cs, int index, boolean isStart) {
		this.cs = cs;
		this.index = index;
		this.isStart = isStart;
	}

	public void parser() {
		if(!findTagName()) return ;
		while (isStart && next())
			;
	}

	private boolean findTagName() {
		int start = index;
		boolean hasLetter = false ;
		char c = 0;
		while (start < cs.length) {
			c = cs[start];
			start++;
			if(isStart){
				if (hasLetter) {
					if(c==' '){
						this.tagName = new String(cs, index, start - index-1).trim();
						index = start ;
						return true;
					}else if(c=='>'){
						this.tagName = new String(cs, index, start - index-1).trim();
						index = start;
						return false ;
					}else if(c=='/'&&cs[start]=='>'){
						this.tagName = new String(cs, index, start - index-1);
						index = start+1;
						isEmptyTag = true;
						return false;
					}else if(!isID(c)){
						throw new RuntimeException("解析出错，html tag不合法："+new String(cs, index, start - index));
					}
					
				}else if(c!=' '){
					if(!isID(c)){
						throw new RuntimeException("解析出错，html tag不合法："+new String(cs, index, start - index));
					}
					hasLetter = true ;
				}
			}else{
				//</@input>
				if (hasLetter&&c == '>') {
					this.tagName = new String(cs, index, start - index-1).trim();
					index = start;
					return false;
				}else if(c!=' '){
					if(!isID(c)){
						throw new RuntimeException("解析出错，html tag不合法："+new String(cs, index, start - index));
					}
					hasLetter = true ;
					
				}
			}
			
		}
		throw new RuntimeException("ERROR");
	}

	public boolean isEmptyTag() {
		return this.isEmptyTag;
	}
	
	/**判断是否是id
	 * joelli
	 */
	private boolean isID(char c){
		if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||c=='_' ||c==':'||(c>='0'&&c<='9')){
			return true;
		}else{
			return false ;
		}
	}

	private boolean next() {
		StringBuilder keySb = new StringBuilder();
		StringBuilder expSb = new StringBuilder();
		String key = null;
		String exp = null;
		int status = 0;
		char quot = '\'';

		while (index < cs.length) {
			char ch = cs[index];
			index++;
			switch (status) {
			case 0: {
				if(ch=='>'){					
					return false;
				}else if (ch != '=') {
					if(ch==' '){
						continue;
					}else if(!isID(ch)){
						throw new RuntimeException("解析出错，html tag '"+this.tagName+"' 属性不合法："+keySb.toString()+ch);
					}
					keySb.append(ch);
					continue;
				} else {
					key = keySb.toString().trim();
					status = 1;
					continue;
				}

			}
			case 1: {
				if (ch== '\'') {
					quot = '\'';
					status = 2;

				} else if (ch == '\"') {
					quot = '\"';
					status = 2;
				}else if(ch!=' '){
					throw new RuntimeException("解析出错，html tag '"+this.tagName+"' 属性不合法："+keySb.toString());
					
				}
				continue;
			}
			case 2: {
				if (ch == quot) {
					if (cs[index - 1] != '\\') {
						// 结束
						exp = expSb.toString().trim();
						status = 3;
						continue;

					} else {
						// escape
						expSb.append(ch);
						continue;
					}
				} else {
					expSb.append(ch);
					continue;
				}
			}

			case 3: {
				this.expMap.put(key, exp);
				quatMap.put(key,Character.valueOf(quot));
				// 继续往前，如果碰到了'>'或者'/>'者表示结束，如果碰到其他分空字符，则是下一个属性
				if (ch == '>') {
					return false;
				} else if (ch == '/' && cs[index] == '>') {
					this.isEmptyTag = true;
					index = index+1;
					return false;

				} else if (ch != ' ') {
					index--;
					return true;
				}

			}

			}
		}
		throw new RuntimeException("解析出错，html tag '"+this.tagName+"' 属性不合法");
		
	}

	public int getIndex() {
		return index;
	}


	public String getTagName() {
		return tagName;
	}

	
	public Map<String, String> getExpMap() {
		return expMap;
	}
	
	public Map<String, Character> getQuatMap() {
		return this.quatMap;
	}

	public void setExpMap(Map<String, String> expMap) {
		this.expMap = expMap;
	}

	

	public static void main(String[] args) {
		String input = "<#img_cut p=\"[{k:'name',v:'2'}]\" />";
		HTMLTagParser htmltag = new HTMLTagParser(input.toCharArray(),2,true);
		htmltag.parser();
		System.out.println(htmltag.getTagName());
		System.out.println(htmltag.getExpMap());
		System.out.println(htmltag.isEmptyTag());
		

	}

}
