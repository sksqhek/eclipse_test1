import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame{
	
	JButton button1 = new JButton("1��");
	JButton button2 = new JButton("2��");;
	JButton button3 = new JButton("3��");;
	JPanel panel4 = new JPanel();
	
	JButton button4_1 = new JButton("4��");;
	JButton button4_2 = new JButton("5��");;
	JButton button4_3 = new JButton("6��");;
	JButton button4_4 = new JButton("7��");;
	
	public Test() {
		this.setLayout(new GridLayout(2, 2));
		
		panel4.setLayout(new GridLayout(2,2));
		panel4.add(button4_1);
		panel4.add(button4_2);
		panel4.add(button4_3);
		panel4.add(button4_4);
		
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(panel4);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setVisible(true);
		}
	
	static public void main(String args[])
	{		
		new Test();
	}
}
