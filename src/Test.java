import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame{
	
	JButton button1 = new JButton("1Í≈");
	JButton button2 = new JButton("2Í≈");;
	JButton button3 = new JButton("3Í≈");;
	JPanel panel4 = new JPanel();
	
	JButton button4_1 = new JButton("4Í≈");;
	JButton button4_2 = new JButton("5Í≈");;
	JButton button4_3 = new JButton("6Í≈");;
	JButton button4_4 = new JButton("7Í≈");;
	
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
