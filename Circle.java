// Sebastian Puerta Hincapie
// Circle Implementation

package e3;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class Circle extends Shapes{
	private int radius;
	private int area;
	private int perimeter;

	public Circle(int x, int y, Color color, int radius){
		super(x, y, color);	
		this.radius = radius;
		
		area = (int)(Math.PI * (radius^2));
		perimeter = (int)(2 * Math.PI * radius);
	}
	public final int getArea(){ return area;}
	public final int getPerimeter(){ return perimeter;}
	public final int getRadius(){ return radius;}
	public void setRadius(int radius){ this.radius = radius;}
	@Override
	public String toString(){
		return String.format("Radius: %d - Perimeter: %d - Area: %d",radius,perimeter,area);
	}
	@Override
	public void draw(Graphics g){
		g.setColor(getColor());
		g.fillOval(getX(),getY(),radius,radius);
		g.drawLine(600,getY(),850,getY());
		g.setFont(new Font("TimesRoman", Font.BOLD, 14));
		g.drawString(String.format("Area: %d, Perimeter: %d, Radius: %d",getArea(),getPerimeter(),getRadius()),850,getY()+8);
	}
}
