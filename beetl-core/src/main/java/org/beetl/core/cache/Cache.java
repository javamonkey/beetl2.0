package org.beetl.core.cache;

public interface Cache {

	public Object get(String key);

	public void remove(String key);

	public void set(String key, Object value);

	public void clearAll();

}
