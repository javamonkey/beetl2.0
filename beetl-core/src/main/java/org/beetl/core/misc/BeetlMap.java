package org.beetl.core.misc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Beetl 实现Map,对双Map封装 get->children.get->parent.get
 * 
 * @author 964700108@qq.com
 * 
 * @version 1.0
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BeetlMap<K, V> implements Map<K, V> {

	private Object EMPTY = new HashMap();

	private Map<K, V> parent = (Map<K, V>) EMPTY;

	private Map<K, V> children = (Map<K, V>) EMPTY;

	private BeetlMap(Map<K, V> parent, Map<K, V> children) {
		this.parent = parent;
		this.children = children;
	}

	@Override
	public int size() {
		return parent.size() + children.size();
	}

	@Override
	public boolean isEmpty() {
		return parent.isEmpty() && children.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return children.containsKey(key) || parent.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return children.containsValue(value) || parent.containsValue(value);
	}

	@Override
	public V get(Object key) {
		return children.containsKey(key) ? children.get(key) : parent.get(key);
	}

	@Override
	public V put(K key, V value) {
		return children.put(key, value);
	}

	@Override
	public V remove(Object key) {
		return children.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		children.putAll(m);
	}

	@Override
	public void clear() {
		children.clear();
		// XXX:无权限删除父区域
	}

	@Override
	public Set<K> keySet() {
		return new MapSet<K>(parent.keySet(), children.keySet());
	}

	@Override
	public Collection<V> values() {
		// XXX:不常使用,不考虑双List实现
		parent.values().addAll(children.values());
		return parent.values();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return new MapSet<java.util.Map.Entry<K, V>>(parent.entrySet(),
				children.entrySet());
	}

	final static class MapSet<E> implements Set<E> {
		static final Set EMPTY = new TreeSet();

		private Set<E> parent = EMPTY;

		private Set<E> children = EMPTY;

		public MapSet(Set<E> parent, Set<E> children) {
			this.parent = parent;
			this.children = children;
		}

		@Override
		public int size() {
			return parent.size() + children.size();
		}

		@Override
		public boolean isEmpty() {
			return parent.isEmpty() && children.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return children.contains(o) || parent.contains(o);
		}

		@Override
		public Iterator<E> iterator() {
			return new It<E>(parent.iterator(), children.iterator());
		}

		@Override
		public Object[] toArray() {
			Set<E> tmp = new TreeSet<E>();
			tmp.addAll(parent);
			tmp.addAll(children);
			return tmp.toArray();
		}

		@Override
		public <T> T[] toArray(T[] a) {
			Set<E> tmp = new TreeSet<E>();
			tmp.addAll(parent);
			tmp.addAll(children);
			return tmp.toArray(a);
		}

		@Override
		public boolean add(E e) {
			return children.add(e);
		}

		@Override
		public boolean remove(Object o) {
			return children.remove(o);
			// XXX:无权力删除父作用域
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			Iterator<?> it = c.iterator();
			while (it.hasNext()) {
				Object o = it.next();
				if (!(children.contains(o) || parent.contains(o))) {
					return false;
				}
			}
			return true;
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			return children.addAll(c);
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// XXX:无权删除父域下的东西
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return children.removeAll(c);
		}

		@Override
		public void clear() {
			children.clear();
		}

		static final class It<A> implements Iterator<A> {
			final static Iterator EMPTY = MapSet.EMPTY.iterator();

			private Iterator<A> parent = EMPTY;

			private Iterator<A> children = EMPTY;

			private boolean isChildren = true;

			public It(Iterator<A> parent, Iterator<A> children) {
				this.parent = parent;
				this.children = children;
			}

			@Override
			public boolean hasNext() {
				return children.hasNext() || parent.hasNext();
			}

			@Override
			public A next() {
				if (children.hasNext()) {
					return children.next();
				} else {
					// XXX:替代本方法抛出异常
					isChildren = false;
					return parent.next();
				}
			}

			@Override
			public void remove() {
				if (isChildren) {
					children.remove();
				}
			}
		}

	}

	public static void main(String[] args) {
		Map<String, Object> parent = new HashMap<String, Object>();
		parent.put("num", 1);
		parent.put("hah", 1);
		parent.put("ss", 1);
		parent.put("dd", 1);
		Map<String, Object> children = new HashMap<String, Object>();
		children.put("qfqf", 2);
		children.put("aaa", 2);
		children.put("ccc", 2);
		children.put("ssss", 2);
		children.put("eee", 2);
		Map<String, Object> params = new BeetlMap<String, Object>(parent,
				children);
		System.out.println(params.size());
		Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> o = it.next();
			System.out.println(o.getKey() + ":" + o.getValue());
		}
	}

}
