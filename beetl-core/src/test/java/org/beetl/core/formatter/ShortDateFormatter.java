package org.beetl.core.formatter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.beetl.core.Format;

public class ShortDateFormatter implements Format {

	@Override
	public Object format(Object data, String pattern) {
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format((Date) data);
	}
}
