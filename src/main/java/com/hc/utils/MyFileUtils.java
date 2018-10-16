package com.hc.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFileUtils {

	public static void copy(InputStream in, String filename) throws IOException {
		byte[] buff = new byte[10240];
		int len = 0;
		FileOutputStream fos = new FileOutputStream(filename);
		while((len = in.read(buff)) != -1) {
			fos.write(buff, 0, len);
		}
		fos.close();
	}

}
