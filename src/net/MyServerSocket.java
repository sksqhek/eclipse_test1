package net;

import java.io.*;
import java.net.*;

public class MyServerSocket {
	public static void main(String[] args) {
		try {
			ServerSocket myServerSocket = new ServerSocket(8080);
			System.out.println("Ŭ���̾�Ʈ�� �����ϱ� ��ٸ��� �ֽ��ϴ�.");
			Socket mySocket = myServerSocket.accept(); // Ŭ���̾�Ʈ ���Ӷ����� ���

			System.out.println("Ŭ���̾�Ʈ�� �����߽��ϴ�.");
			// Ŭ���̾�Ʈ ���Ͽ� ��Ʈ���� ����
			BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));
												
			//Ŭ���̳�Ʈ ip �ޱ�
			System.out.println("���� Ŭ���̾�Ʈ�� IP: " + in.readLine());
			
			// Ŭ���̾�Ʈ ���Ͽ� �޽��� ����
			String msg = "";
			while ((msg = in.readLine()) != null) {//Ŭ���̾�Ʈ���Լ� �ޱ�
				out.println(msg);//Ŭ���̾�Ʈ�� ������
				out.flush();
				System.out.println("Ŭ���̾�Ʈ���� ���� �޽���: " + msg);
			}
			mySocket.close();
		} catch (MalformedURLException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}