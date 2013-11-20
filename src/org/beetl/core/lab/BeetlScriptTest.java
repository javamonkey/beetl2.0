package org.beetl.core.lab;

import java.io.InputStreamReader;
import java.io.Reader;

import org.beetl.core.BeetlScript;
import org.beetl.core.ByteWriter;
import org.beetl.core.Context;

import com.beetl.performance.Log;
import com.beetl.performance.lab.User;

public class BeetlScriptTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Reader reader = new InputStreamReader(GrammerTest.class.getResourceAsStream("/org/beetl/core/lab/grammer.txt"),"utf-8");
		String[] staticText = new String[]{"world"};
		//run the script
		
		ByteWriter bw = new ByteWriter();
		Context ctx = new Context();
		ctx.set("user", new User());
		BeetlScript script = new BeetlScript(null);
		script.parse(reader, staticText);
		Log.key1Start();
		System.out.println("-----------模板输出");
		for(int i=0;i<1;i++){
			script.execute(ctx, bw);
		}
		Log.key1End();
		Log.display();

	}

}
