// Sebastian Puerta Hincapie
// Venn Diagram

package ex1;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;


public class DiagramPanel extends JPanel {
	// Rectangle - DEFINED DIMENSIONS
	public void rectangle(Graphics g, int x, int y, int w, int h){
		g.setColor(Color.RED);
		g.fillRect(x, y, w, h);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
		g.setColor(Color.BLACK);
		g.drawString("Venn Diagram: A and B", h,90);
	}
	
	// CASE 1 (A and B = Empty Set) - DEFINED DIMENSIONS
	public void caseOne(Graphics g, int x, int y, int w, int h){
		g.drawString("CASE 1:", 100, 90);
		
		// Circle A
		g.setColor(Color.BLUE);
		g.fillOval(x,y,h,h);
		
		// Circle B
		g.setColor(Color.YELLOW);
		g.fillOval(x + h - 1,y,h,h);
		
		// Format Lines
		g.setColor(Color.BLACK);
		g.drawLine(100, 225, 600, 225);
		g.drawLine(350, 100, 350, 350);
		g.drawLine(225, 100, 225, 350);
		g.drawLine(475, 100, 475, 350);
		
		// Center
		g.setColor(Color.CYAN);
		g.fillOval(220,220,10,10);
		
		g.setColor(Color.ORANGE);
		g.fillOval(470,220,10,10);
	}
	// CASE 2 (A = B) - DEFINED DIMENSIONS
	public void caseTwo(Graphics g, int x, int y, int w, int h){
		g.drawString("CASE 2: ",100, 90);
		
		// Circle A = B
		g.setColor(Color.GREEN);
		g.fillOval(x, y, h, h);
		
		// Format Lines
		g.setColor(Color.BLACK);
		g.drawLine(100, 225, 600, 225);
		g.drawLine(350, 100, 350, 350);
		g.drawLine(225, 100, 225, 350);
		g.drawLine(475, 100, 475, 350);
		
		// Center
		g.setColor(Color.PINK);
		g.fillOval(345,220,10,10);
	}
	
	// CASE 3 (A intersects B) - DEFINED DIMENSIONS
	public void caseThree(Graphics g, int x, int y, int w, int h){
		g.drawString("CASE 3: ", 100, 90);
		
		// Circle A
		g.setColor(Color.BLUE);
		g.fillOval(x + 25,y,h,h);
		
		// Circle B
		g.setColor(Color.YELLOW);
		g.fillOval(x + h - 25,y,h,h);
		
		// Format Lines
		g.setColor(Color.BLACK);
		g.drawLine(100, 225, 600, 225); // mid rectangle Height
		g.drawLine(350, 100, 350, 350); // mid rectangle Width
		g.drawLine(250, 100, 250, 350);	// mid Circle A
		g.drawLine(450, 100, 450, 350); // mid Circle B
		g.drawLine(325,100,325,350);
		g.drawLine(375,100,375,350);
		g.drawLine(100,150,600,150);
		g.drawLine(100,300,600,300);
		
		// Centers
		g.setColor(Color.PINK);
		g.fillOval(345,220,10,10); // center
		g.fillOval(320,220,10,10); // left
		g.fillOval(370,220,10,10); // right
		g.fillOval(345,145,10,10); // up
		g.fillOval(345,295,10,10); // down
		
		// Intersection area
		g.setColor(Color.GREEN);
		g.fillArc(325, 150, 50, 150, 0, 360);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		this.setBackground(Color.WHITE);
		
		// creating the rectangle
		int rec_x = 100;
		int rec_y = 100;
		int rec_w = 500;
		int rec_h = 250;
		
//		rectangle(g,rec_x,rec_y,rec_w,rec_h);
		
		// CASE 1 (A and B = Empty Set)
//		caseOne(g,rec_x,rec_y,rec_w,rec_h);
		
		// CASE 2 (A = B)
//		caseTwo(g,225,rec_y,rec_w,rec_h);

		// CASE 3 (A intersects B)
//		caseThree(g,rec_x,rec_y,rec_h,rec_h);
		
		// CASE 4 (Random)
		Random rand = new Random();
		rec_x = rand.nextInt(100) + 100;
		rec_y = rand.nextInt(100) + 100;
		rec_h = rand.nextInt(250) + 100;
		rec_w = rand.nextInt(500);
		
		boolean intersect = false;
		int x1 = rec_x;		// Keeps oval A proportional to panel
		int x2;
		
		while(true){
			x2 = rec_x + rand.nextInt(500);
			
			// To assure that ovals A&B maintain their positions
			if(x2 < x1) continue;
			
			// To make oval B proportional to the panel
			if(x2 + rec_h > rec_x + rec_w) {
				rec_w = x2 + rec_h - rec_x;
			}
			else if(rec_x + rec_w > x2 + rec_h){
				rec_w = x2 + rec_h - rec_x;
			}

//			if A = B
			if(x1 == x2){
				g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
				g.setColor(Color.MAGENTA);
				g.drawString("A == B",rec_x + 50, rec_y-50);
				break;
			}
//			 else if A intersect B != empty set
			else if(x2 < (x1 + rec_h)){
				g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
				g.setColor(Color.MAGENTA);
				g.drawString("A Intersect B != Empty Set",rec_x + 50, rec_y-50);
				intersect = true;
				break;
			}
//			// else if A intersect B = empty set
			else if(x2 > (x1 + rec_h)){
				g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
				g.setColor(Color.MAGENTA);
				g.drawString("A Intersect B = Empty Set",rec_x + 50, rec_y-50);
				break;
			}
		}
		// Rectangle Panel
		g.setColor(Color.RED);
		g.fillRect(rec_x, rec_y, rec_w, rec_h);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
		g.setColor(Color.BLACK);
		g.drawString("Venn Diagram: A and B", rec_x,rec_y-10);
		g.drawString("Case 4: Random", rec_x, rec_y-30);
		
		// Circle One
		g.setColor(Color.BLUE);
		g.fillOval(x1,rec_y,rec_h,rec_h);
		
		// Circle Two
		g.setColor(Color.YELLOW);
		g.fillOval(x2,rec_y,rec_h,rec_h);
		
		// if A = B
		if(x1 == x2){
			g.setColor(Color.GREEN);
			g.fillOval(x1,rec_y,rec_h,rec_h);
		}
		
		// if intersecting
		if(intersect){
			// Intersecting Lines/Points
			g.setColor(Color.PINK);
			g.fillOval(x2 - 5,(rec_y + rec_h /2) - 5,10,10);
			g.fillOval(x1 + rec_h - 5,(rec_y + rec_h /2) - 5,10,10);
			g.setColor(Color.BLACK);
			g.drawLine(x2,rec_y,x2,rec_y + rec_h);
			g.drawLine(x1 + rec_h,rec_y,x1 + rec_h,rec_y + rec_h);
			g.drawLine((rec_x + rec_w/2),rec_y,(rec_x + rec_w/2),rec_y + rec_h);
			
			// Using Pythagorean Thereom to obtain the height
			 // height up to intersecting point
			double b = Math.sqrt(Math.pow(rec_h,2)/Math.pow((rec_x+rec_w/2)-(x1+rec_h/2),2));
			int m = (int)b; 
			int p = (rec_y + rec_h/2) - m; // total height of shaded region
			
			// Intersecting Area
			g.setColor(Color.GREEN);
			g.fillArc(x2,rec_y + m,(x1 + rec_h)-x2,p,0,360);
		}
		
		// Format Lines
		g.setColor(Color.BLACK);
		g.drawLine(rec_x, (rec_y + rec_h/2), rec_x + rec_w, (rec_y + rec_h/2)); // mid rectangle Height
		g.drawLine((rec_x + rec_w/2), rec_y, (rec_x + rec_w/2), rec_y + rec_h); // mid rectangle Width
		g.drawLine((x1 + rec_h/2), rec_y, (x1 + rec_h/2), rec_y + rec_h);	// mid oval A
		g.drawLine((x2 + rec_h/2), rec_y, (x2 + rec_h/2), rec_y + rec_h); // mid oval B
		
		// Centers
		g.setColor(Color.PINK);
		g.fillOval((rec_x + rec_w /2) - 5 ,(rec_y + rec_h /2) - 5,10,10); // mid point rectangle
		g.fillOval((x1 + rec_h/2) - 5,(rec_y + rec_h/2) - 5,10,10);	// mid point oval A
		g.fillOval((x2 + rec_h/2) - 5,(rec_y + rec_h/2) - 5,10,10); // mid point oval B
		
	}
}
