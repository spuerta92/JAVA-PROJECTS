package ex1;

import javax.swing.JFrame;	// provides basic window features
import java.awt.Color;

public class VennDiagram {
	public static void main(String [] args){
		JFrame frame = new JFrame("Venn Diagram");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DiagramPanel diagramPanel = new DiagramPanel();
		diagramPanel.setBackground(Color.BLUE);
		frame.add(diagramPanel);
		frame.setSize(800,600);
		frame.setVisible(true);
		
	}
}
