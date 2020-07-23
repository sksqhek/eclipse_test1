import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Test
{

	static public void main(String args[])
	{
		try {
			BufferedReader fr = new BufferedReader(new FileReader("test.txt"));

			Date date = new Date();

			// 읽을때는 읽은 시간을 표시해주고
			System.out.println("읽은 시간:" + date);
			String s = fr.readLine();//파일에서 한줄 읽기
			System.out.println("읽은 내용:" + s);

			fr.close();
		} catch (IOException e) {
			// 존재하지 않는 파일은 파일이 존재하지않는다는 예외표시
			System.out.println("파일 없음");
		}

	}
}
