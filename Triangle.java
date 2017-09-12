// Sebastian Puerta Hincapie
// Triangle Implementation

package e3;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class Triangle extends Shapes {
	final int CAPACITY = 3;
	// FIELDS
	private double area;	
	private double perimeter;
	private double A,B,C;	// angles
	private double a,b,c;	// sides
	private double arrSides[] = new double[CAPACITY];
	private double arrAngles[] = new double[CAPACITY];

	public Triangle(int x, int y, Color color, double a, double b, double c){
		super(x,y,color);
		// sides
		this.a = a;
		this.b = b;
		this.c = c;
		
		// angles
		A = Math.acos((Math.pow(a,2)-Math.pow(b,2)-Math.pow(c,2)) / (-2*b*c)) * (180/Math.PI);
		B = Math.acos((Math.pow(b,2)-Math.pow(a,2)-Math.pow(c,2)) / (-2*a*c)) * (180/Math.PI);
		C = Math.acos((Math.pow(c,2)-Math.pow(a,2)-Math.pow(b,2)) / (-2*a*b)) * (180/Math.PI);
		

		// area
		double s = 0.5 * (a + b + c);
        area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        
		// perimeter
		perimeter = a + b + c;
		
	}
	// Isosceles Triangle
	public Triangle(int x, int y, Color color, int side, int angle){
		super(x,y,color);
		// given 
		a = side;
		b = side;
		A = angle;
		B = angle;
		C = 180 - (A+B);
		c = Math.pow(a,2) + Math.pow(b,2) - 2*a*b*Math.cos(Math.toRadians(C));
		c = Math.sqrt(c);
		
		// area
		double s = 0.5 * (a + b + c);
		area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        
		// perimeter
		perimeter = a + b + c;

	}
	// Equilateral Triangle
	public Triangle(int x, int y, Color color, int side){
		super(x,y,color);
		// given
		a = side;
		b = side;
		c = side;
		
		// obtained
		A = 60; B = 60; C = 60;
		
		// area
		double s = 0.5 * (a + b + c);
		area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        
		// perimeter
		perimeter = a + b + c;
		
	}
	// checks if it's a proper triangle
	public boolean isTriangle(){
//		if((A+B+C) == 180 && (A != 0 && B != 0 && C != 0)) return true;
		if(c < a+b && a < b+c && b < a+c) return true;
		return false;
	}
	public void setSides(int a, int b, int c){
		this.a = a; this.b = b; this.c = c;
	}
	public final double getArea(){ return area;}
	public final double getPerimeter(){ return perimeter;}
	public final double getAngleA(){ return A;}
	public final double getAnglelB(){ return B;}
	public final double getAngleC(){ return C;}
	public double[] getSides(){ 
		arrSides[0] = a;
		arrSides[1] = b;
		arrSides[2] = c;
		return arrSides;
	}
	public double[] getAngles(){
		arrAngles[0] = A;
		arrAngles[1] = B;
		arrAngles[2] = C;
		return arrAngles;
	}
	@Override
	public String toString(){
		if(!isTriangle()){
			return String.format("(Not a triangle) Sides: %.1f,%.1f,%.1f - Angles: %.1f,%.1f,%.1f - Perimeter: %.1f - Area: %.1f",a,b,c,A,B,C,perimeter,area);
		}
		return String.format("Sides: %.1f,%.1f,%.1f - Angles: %.1f,%.1f,%.1f - Perimeter: %.1f - Area: %.1f",a,b,c,A,B,C,perimeter,area);
	}
	@Override
	public void draw(Graphics g){
//		g.drawLine(getX(),getY(),getX()+(int)a,getY()+(int)a);
//		g.drawLine(getX(),getY(),getX()-(int)b,getY()+(int)b);
//		g.drawLine(getX()-(int)b,getY()+(int)b,getX()+(int)a,getY()+(int)a);
		g.setColor(getColor());
	    int xpoints[] = {getX(),(int)(getX() + a), (int)(getX() - b)};
	    int ypoints[] = {getY(),(int)(getY() + a), (int)(getY() + b)};
	    int npoints = 3;
	    g.fillPolygon(xpoints, ypoints, npoints);
	    g.setFont(new Font("TimesRoman", Font.BOLD, 12));
	    g.setColor(Color.BLACK);
	    // angles
	    g.drawString(String.format("%.1f",A),getX()-10,getY()+20);
	    g.drawString(String.format("%.1f",B),getX()+(int)a-20,getY()+(int)a);
	    g.drawString(String.format("%.1f",C),getX()-(int)b,getY()+(int)b);
	    // sides
	    g.drawString(String.format("%.1f",c),getX()+(int)a / 2,getY()+(int)a / 2);
	    g.drawString(String.format("%.1f",b),getX()-(int)b / 2 - 20,getY()+(int)b / 2);
	    g.drawString(String.format("%.1f",a),getX(),getY()+(int)a+10);
	    // angle, perimeter
	    g.drawString(String.format("Area: %.1f", getArea()),getX(),getY()-30);
	    g.drawString(String.format("Perimeter: %.1f", getPerimeter()),getX(),getY()-15);
	    if(!isTriangle()){
	    	g.drawString("NOT A TRIANGLE",getX(),getY()-45);
	    }
	    
	}
}
