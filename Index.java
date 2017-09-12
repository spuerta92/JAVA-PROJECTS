// Sebastian Puerta Hincapie
// Execution File

package e3;

import javax.swing.JFrame;

public class Index{
	public static void main(String args []){
		JFrame frame = new JFrame("is_a Shape");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawShapes draw = new DrawShapes();
		frame.add(draw);
		frame.setSize(1200,1000);
		frame.setVisible(true);
	}
}
