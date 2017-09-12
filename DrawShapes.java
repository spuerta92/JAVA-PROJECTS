// Sebastian Puerta Hincapie
// Draw Shapes Implementation

package e3;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class DrawShapes extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		this.setBackground(Color.GRAY);
		
		// shape
		Shapes shapes = new Shapes(0,0,Color.WHITE);
		System.out.println(shapes);
		shapes.draw(g);
		System.out.print("\n");
		
		// build lines
		g.setColor(Color.RED);
		g.drawLine(0,400,1200,400);		// horizontal
		g.drawLine(600,0,600,1000);		// vertical
		g.drawLine(0, 0, 1200, 800);	// diagonal positive
		g.drawLine(0, 800, 1200, 0);	// diagonal negative
		g.setColor(Color.ORANGE);
		g.fillOval(595,395,10,10);
		
		// triangle
		Triangle triangle1 = new Triangle(150,100,Color.BLUE,100,100,72);
		Triangle triangle2 = new Triangle(300,200,Color.YELLOW,100,100,100*Math.sqrt(2));
		Triangle triangle3 = new Triangle(450,300,Color.RED,100,50,50);
		Triangle triangle4 = new Triangle(600,400,Color.MAGENTA,100,72);
		Triangle triangle5 = new Triangle(750,500,Color.ORANGE,100,90);
		Triangle triangle6 = new Triangle(900,600,Color.GREEN,100,60);
		Triangle triangle7 = new Triangle(1050,700,Color.CYAN,100);
		
//		triangle7.draw(g);
//		triangle6.draw(g);
//		triangle5.draw(g);
//		triangle4.draw(g);
//		triangle3.draw(g);
//		triangle2.draw(g);
//		triangle1.draw(g);
		
		System.out.println("Triangle: ");
		System.out.println(triangle1);
		System.out.println(triangle2);
		System.out.println(triangle3);
		System.out.println(triangle4);
		System.out.println(triangle5);
		System.out.println(triangle6);
		System.out.println(triangle7);
		System.out.print("\n");
		
		// circle
		Circle circle0 = new Circle(400,200,Color.BLUE,400);
		Circle circle1 = new Circle(450,250,Color.RED,300);
		Circle circle2 = new Circle(500,300,Color.GREEN,200);
		Circle circle3 = new Circle(550,350,Color.CYAN,100);
		Circle circle4 = new Circle(575,375,Color.ORANGE,50);
		
		circle0.draw(g);
		circle1.draw(g);
		circle2.draw(g);
		circle3.draw(g);
		circle4.draw(g);
		
		System.out.println("Circle: ");
		System.out.println(circle4);
		System.out.println(circle3);
		System.out.println(circle2);
		System.out.println(circle1);
		System.out.println(circle0);
		
		System.out.print("\n");
		System.out.println("- End of program\n");
	}
}
