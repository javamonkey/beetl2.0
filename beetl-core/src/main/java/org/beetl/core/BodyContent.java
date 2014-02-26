package org.beetl.core;

import java.io.IOException;

public interface BodyContent
{
	public String getBody();

	public void fill(ByteWriter bw) throws IOException;

}
