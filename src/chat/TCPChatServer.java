package chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPChatServer
{
	public static ArrayList<ServerThread> list;

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		list = new ArrayList<ServerThread>();
		try {
			ServerSocket ss = new ServerSocket(9123);
			System.out.println("������ �����Ǿ����ϴ�");
			while (true) {
				Socket sk = ss.accept();
				System.out.println("Ŭ���̾�Ʈ�� �����߽��ϴ�");
				ServerThread st = new ServerThread(sk);
				list.add(st);
				st.start();
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻� :" + e.getMessage());
		}
	}
}