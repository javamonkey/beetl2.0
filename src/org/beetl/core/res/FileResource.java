package org.beetl.core.res;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.beetl.core.Resource;

public class FileResource extends Resource {

	File file = null;

	public FileResource(File file) {
		this.file = file;

	}

	@Override
	public Reader openReader() {
		Reader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					file),
					((FileResourceLoader) this.getResourceLoader()).charset));
		} catch (UnsupportedEncodingException e) {
			return null;
		} catch (FileNotFoundException e) {
			return null;
		}
		return br;
	}

	@Override
	public String getContent(int startLine, int endLine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

}
