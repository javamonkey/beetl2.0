package org.beetl.core.lab;

import java.io.InputStreamReader;
import java.io.Reader;

import org.beetl.core.BeetlScript;
import org.beetl.core.ByteWriter;
import org.beetl.core.Context;

import com.beetl.performance.Log;

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
		ctx.set("name", "hello");
		BeetlScript script = new BeetlScript(null);
		script.parse(reader, staticText);
		Log.key1Start();
		for(int i=0;i<1;i++){
			script.execute(ctx, bw);
		}
		Log.key1End();
		Log.display();

	}

}
