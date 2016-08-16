package com.dyx.sts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class AndroidRunable implements Runnable {
	/**
	 * ����ServerSocket
	 */
	private Socket socket = null;

	/**
	 * ���췽��
	 * 
	 * @param socket
	 */
	public AndroidRunable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// ��android�ͻ������hello worild
		String line = null;
		InputStream input;
		OutputStream output;
		String str = "hello world!";
		try {
			// ��ͻ��˷�����Ϣ
			output = socket.getOutputStream();
			input = socket.getInputStream();
			BufferedReader bff = new BufferedReader(new InputStreamReader(input));
			output.write(str.getBytes("gbk"));
			output.flush();
			// ��ر�socket
			socket.shutdownOutput();
			// ��ȡ�ͻ��˵���Ϣ
			while ((line = bff.readLine()) != null) {
				System.out.print("���Կͻ��ˣ�"+line + "\n");
			}
			// �ر����������
			output.close();
			bff.close();
			input.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
