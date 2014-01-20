package org.beetl.core.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalCache implements Cache {

	Map map = new ConcurrentHashMap();

	@Override
	public Object get(String key) {
		return map.get(key);
	}

	@Override
	public void remove(String key) {
		map.remove(key);

	}

	@Override
	public void set(String key, Object value) {
		map.put(key, value);

	}

	@Override
	public void clearAll() {
		map.clear();

	}

}
