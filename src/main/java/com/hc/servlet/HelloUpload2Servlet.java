package com.hc.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.hc.utils.MyFileUtils;

public class HelloUpload2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// testing 修改的内容
	/**
	 * this is from teacher
	 */
	// a test
	// 第一次修改    提交 c1
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setFileSizeMax(3*1024*1024);
		sfu.setHeaderEncoding("utf-8");
		try {
			List<FileItem> list = sfu.parseRequest(request);
			for (FileItem item : list) {
				System.out.println(item);
				if (item.isFormField()) {
					// 不是上传文件
					System.out.println(item.getString("utf-8"));
				} else {
					String filename = item.getName();
					if (filename.length() > 0) {
						System.out.println(filename);
						InputStream in = item.getInputStream();
						/*
						if (filename.contains("/")) {
							filename = filename.substring(filename.lastIndexOf("/") + 1);
						}
						*/
						String newName = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf(".") );
						String dirName = newName.substring(0, 4);
						dirName = "d:/upload/" + dirName;
						File dir = new File(dirName);
						if (!dir.exists()) {
							dir.mkdirs();
						}
						FileOutputStream output = new FileOutputStream(dirName + "/" + newName);
						int copy = IOUtils.copy(in, output);
						// MyFileUtils.copy(in, dirName + "/" + newName);
						output.close();
						in.close();
					}
				}
				item.delete();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			response.getWriter().write("file size reach max size, 文件长度超长 ！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
