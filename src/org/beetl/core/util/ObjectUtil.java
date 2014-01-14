package org.beetl.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectUtil {
	public static Object copy(Object o) {
		if (o instanceof java.io.Serializable) {
			try {
				ByteArrayOutputStream bs = new ByteArrayOutputStream(128);
				ObjectOutputStream dos = new ObjectOutputStream(bs);
				dos.writeObject(o);
				ByteArrayInputStream is = new ByteArrayInputStream(
						bs.toByteArray());
				ObjectInputStream ios = new ObjectInputStream(is);
				Object copy = ios.readObject();
				return copy;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
	}

	public static String getMethod(String attrName) {
		StringBuilder mbuffer = new StringBuilder("get");
		mbuffer.append(attrName.substring(0, 1).toUpperCase()).append(
				attrName.substring(1));
		return mbuffer.toString();
	}

	public static String getIsMethod(String attrName) {
		StringBuilder mbuffer = new StringBuilder("is");
		mbuffer.append(attrName.substring(0, 1).toUpperCase()).append(
				attrName.substring(1));
		return mbuffer.toString();
	}

	public static void main(String[] args) {

	}
}
