package com.dyx.sts;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
	public static void main(String[] args) {
		// ����ServerSocket����
		ServerSocket serivce;
		try {
			// ����ServerSocket����
			serivce = new ServerSocket(4567);
			while (true) {
				// �ȴ��ͻ�������
				Socket socket = serivce.accept();
				// �����߳�
				new Thread(new AndroidRunable(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
