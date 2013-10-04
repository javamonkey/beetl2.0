package org.beetl.core;

/**
 * 优化引擎，可选配件
 * @author joelli
 *
 */
public interface  OptimizationEngine {
	
	/**试图优化脚本，保持异步优化
	 * @param script
	 */
	public  void optimaze(BeetlScript script,Context ctx);
	
	/**使用该引擎执行脚本
	 * @param script
	 * @param ctx
	 * @param bw
	 */
	public  void execute(BeetlScript script,Context ctx,ByteWriter bw);
	
	/**
	 * 判断是否有优化版,0,表示未优化，1表示优化成功，2表示无法优化，或者优化失败
	 * @param script
	 */
	public   int status(BeetlScript script);
	
}
