// Sebastian Puerta Hincapie
// Shapes Implementation

package e3;
import java.awt.Graphics;
import java.awt.Color;

public class Shapes extends Object{
	// FIELDS
	private int x;
	private int y;
	private Color color;
	// CONSTRUCTORS
	public Shapes(int x, int y, Color color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
	// METHODS
	// getters-accessor
	public final int getX(){ return x;}
	public final int getY(){ return y;}
	public final Color getColor(){ return color;}
	// setters
	public void setX(int x){ this.x = x;}
	public void setY(int y){ this.y = y;}
	public void setColor(Color color, Graphics g){ 
		this.color = color;
		g.setColor(color);
	}
	// utilities
	public void moveTo(int x, int y){ this.x += x; this.y += y;};
	public String toString(){ return "Generic Message";}
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(x,y,1200,1000);
	}
}
