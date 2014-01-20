package org.beetl.core.cache;

public class ProgramCacheFactory {
	public static String CACHE = "org.beetl.core.cache.LocalCache";

	public static Cache defaulCache() {
		try {
			return (Cache) Class.forName(CACHE).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
