import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Translation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame main_frame = new JFrame("Midline, translation");
		main_frame.setSize(1500, 700);
		JButton drawLine = new JButton("Draw Line");
		main_frame.add(drawLine);
		JButton moveLine = new JButton("Translation");
		main_frame.add(moveLine);
		DrawBase drawbase = new DrawBase();
		drawbase.setSize(1500, 700);
		main_frame.add(drawbase);
		drawLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawLine1 drawline1 = new DrawLine1();
				drawline1.setSize(500, 500);
				main_frame.add(drawline1);
				drawline1.setBounds(0, 0, 500, 500);
				main_frame.repaint();
			}
		});
		moveLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���� �ۼ��� ���� ����
			}
		});
		main_frame.setLayout(null);
//�߰��� textfield, button ���� setbounds�� ��ġ �����ϱ� 
		moveLine.setBounds(800, 575, 100, 30);
		drawLine.setBounds(300, 575, 100, 30);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setVisible(true);
	}
}

class DrawLine1 extends JPanel {// �� �׸���
	public void paintComponent(Graphics s) {
		// super.paintComponent(s);
		s.drawLine(100, 100, 200, 400);
	}
}

class DrawBase extends JPanel {
	public void paintComponent(Graphics s) {
		// super.paintComponent(s);
		s.drawLine(500, 0, 500, 700);// ���μ� 3���� �׾ ��ǥ����� �׷��� �κ� �����ϱ�
		s.drawLine(1000, 0, 1000, 700);
		s.drawLine(0, 500, 1500, 500);
		// �� ĭ�� ���� ��ǥ��� �׸���, ���簢���� �ݺ��ؼ� �׸��� ������ ��ǥ����� ��Ÿ����
		for (int x = 0; x < 40; x++)
			for (int y = 0; y < 40; y++) {
				s.drawRect(50 + x * 10, 50 + y * 10, 10, 10);
				s.drawRect(550 + x * 10, 50 + y * 10, 10, 10);
				s.drawRect(1050 + x * 10, 50 + y * 10, 10, 10);
			}
	}
}