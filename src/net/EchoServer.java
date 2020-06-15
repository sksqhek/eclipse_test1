package net;

//package wipi_book_netserver;
import java.net.*;
import java.io.*;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author unascribed
 * @version 1.0
 */
public class EchoServer extends Thread {
	static int ClientCnt = 0;
	Socket sock = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;

	/**
	 * Ŭ���̾�Ʈ ó�� ������ ������
	 * 
	 * @param socket
	 */
	public EchoServer(Socket socket) {
		ClientCnt++;
		System.out.println("��ü " + ClientCnt + " ���� Ŭ���̾�Ʈ�� �����߽��ϴ�.");
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
		}
	}

	/**
	 * Ŭ���̾�Ʈ�� ���ϴ� ����� �����Ѵ�.
	 */
	public void run() {
		byte[] readdata = null;
		try {
			while (true) {
				int length = dis.read();
				readdata = new byte[length];
				int readlen = dis.read(readdata);
				String msg = new String(readdata);
				System.out.println(msg);
				if (readlen > 0) {
					
					if (msg.equals("�����ڼ�")) {
						response(ClientCnt + "");
					}else
					{
						response(msg);
					}
				}				
				
				if (msg.equals("exit")) {
					ClientCnt--;
					System.out.println("Ŭ���̾�Ʈ�� ������ �����߽��ϴ�.");
					System.out.println("���� " + ClientCnt + " ���� Ŭ���̾�Ʈ�� �����߽��ϴ�.");
					closeAll();
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Re>�� �߰��Ͽ� �ٽ� Ŭ���̾�Ʈ���� ������.
	 * 
	 * @param str
	 */
	private void response(String str) {
		try {
			String returnstr = "RE>" + str;
			dos.write((byte) returnstr.getBytes().length);
			dos.write(returnstr.getBytes());
		} catch (Exception e) {
		}
	}

	public void closeAll() {
		try {
			sock = null;
			dis = null;
			dos = null;
		} catch (Exception e) {
		}
	}

	/**
	 * Ŭ���� ��Ʈ�� ������ �޾� ���δ�.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket m_serversocket = null;
		try {
			m_serversocket = new ServerSocket(10000);
			while (true) {
				System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��� �ֽ��ϴ�.");
				Socket socket = m_serversocket.accept();
				new EchoServer(socket).start();
			}
		} catch (Exception e) {
		}
	}
}