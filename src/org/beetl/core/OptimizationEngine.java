package org.beetl.core;

import org.beetl.core.statement.Program;

/**
 * 优化引擎，可选配件
 * @author joelli
 *
 */
public interface  OptimizationEngine {
	
	/**试图优化脚本，保持异步优化
	 * @param script
	 */
	public  void optimaze(Program program,Context ctx);
	
	
}
