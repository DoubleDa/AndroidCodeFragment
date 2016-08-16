package com.dyx.sts;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
	public static void main(String[] args) {
		// 声明ServerSocket对象
		ServerSocket serivce;
		try {
			// 创建ServerSocket对象
			serivce = new ServerSocket(4567);
			while (true) {
				// 等待客户端连接
				Socket socket = serivce.accept();
				// 开启线程
				new Thread(new AndroidRunable(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
