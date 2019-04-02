package org.beetl.core.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 文本解析成beetl脚本,按照各种定位符，html标记解析成对应的Fragment，然后再格式化，最后输出成beetl脚本
 * @author xiandafu
 *
 */
public class TextParser {

	Map<Integer, String> textVars = new HashMap<Integer, String>();
	int textNameSuffix = 0;
	PlaceHolderDelimeter pd;
	ScriptDelimeter sd;
	Source source = null;
	StringBuilder script = new StringBuilder(64);
	//脚本的回车符，antlr解析会忽略掉
	public final static char cr1 = '\n';
	// 操作系统回车换行符号
	public final static String systemCrStr = System.getProperty("line.separator");
	 
	
//	List<Fragment> list = new ArrayList<Fragment>();
	SourceFragement sourceFragement = new SourceFragement();
	HtmlTagConfig htmlTagConfig = null;
	//文本里的回车
	String textCr = null;

	public TextParser(PlaceHolderDelimeter pd, ScriptDelimeter sd) {
		this.pd = pd;
		this.sd = sd;
	}

	public TextParser(PlaceHolderDelimeter pd, ScriptDelimeter sd, HtmlTagConfig htmlTagConfig) {
		this(pd, sd);
		this.htmlTagConfig = htmlTagConfig;
	}

	public void doParse(Reader orginal) throws IOException {

		scan1(orginal);
		//合并
		sourceFragement.merge();
		
		//得到beetl脚本
		for (Fragment f : sourceFragement.list) {
			if(f.getStatus()==FragmentStatus.del) {
				continue;
			}
			script.append(f.getScript());
		}
		
		String cr =  source.findCr();
		
		if(cr!=null) {
			this.textCr = cr;
		}else {
			this.textCr = systemCrStr;
		}


	}

	protected void scan1(Reader orginal) throws IOException {
		StringBuilder temp = new StringBuilder();
		int bufSzie = 1024;
		char[] cs = new char[bufSzie];
		int len = -1;

		while ((len = orginal.read(cs)) != -1) {
			temp.append(cs, 0, len);

		}

		cs = temp.toString().toCharArray();
		source = new Source(cs);
		source.init(this, pd, sd, htmlTagConfig);
		Fragment test = new TextFragment(source);
		Fragment next = null;
		while(true) {
			next = test.consumeAndReturnNext();
			sourceFragement.add(test);
			if(next==null) {
				break;
			}else {
				test = next;
			}
		}
		
	
	}





	public StringBuilder getScript() {
		return script;
	}

	public Map<Integer, String> getTextVars() {
		return textVars;
	}

	public Integer getRandomeTextVarName() {
		return textNameSuffix++;
	}

	public void setTextVars(Map<Integer, String> textVars) {
		this.textVars = textVars;
	}

	
	
	public String getTextCr() {
		return textCr;
	}

	public static void main(String[] args) throws IOException {
		PlaceHolderDelimeter pd = new PlaceHolderDelimeter("${".toCharArray(), "}".toCharArray(), "#{".toCharArray(),
				"}".toCharArray());
		ScriptDelimeter sd = new ScriptDelimeter("@".toCharArray(), null, "<%".toCharArray(), "%>".toCharArray());

		HtmlTagConfig htmlConfig = new HtmlTagConfig();
//		String text = "<%a=1;%>\nabcd";
		String text =""+
				"<%a%>\n" +
				"<%b%>   \n"
				 ;

//		String text ="  @a;";
		StringReader str = new StringReader(text);
		TextParser textParser = new TextParser(pd, sd, htmlConfig);
		textParser.doParse(str);

		System.out.println(textParser.getTextVars());
		String line = null;
		BufferedReader reader = new BufferedReader(new StringReader(textParser.getScript().toString()));
		System.out.println("==============================");
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

	}

}
