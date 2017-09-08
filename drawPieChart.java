// Sebastian Puerta Hincapie
// Pie Chart

package ex2;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;

public class drawPieChart extends JPanel {
	public final int CAPACITY = 26;
	public void fillPieChart1(Graphics h, double arr1[],double arr2[]){
		int angle1 = 0; int angle2 = 0; int temp = 0;
		int r,g,b,x,y;
		String probability,letter;
		DecimalFormat df = new DecimalFormat("0.0000");
		for(int i = 0; i < CAPACITY; ++i){
			// Filling Pie Chart
			r = (int)(Math.random()*256);
			g = (int)(Math.random()*256);
			b = (int)(Math.random()*256);
			Color color = new Color(r,g,b);
			angle1 = (int)arr1[i];
			h.setColor(color);
			h.fillArc(150, 100, 400, 400, angle2, angle1);
			angle2 += (int)arr1[i];
			
			// Formatting probability / letters
			probability = String.valueOf(df.format(arr2[i]));
			letter = String.valueOf((char)('a'+i));

			// 2nd legend
			temp += 17;
			h.setFont(new Font("TimesRoman", Font.BOLD, 15));
			h.setColor(Color.BLACK);
			h.drawString(probability,25,temp);
			h.drawString(letter, 10, temp);
			
			// Location of letters
			x = (int)(350 + 225*Math.sin(angle2-angle1));
			y = (int)(300 + 225*Math.cos(angle2-angle1));
			h.setFont(new Font("TimesRoman", Font.ITALIC, 15));
			h.drawString(probability,x,y);
			h.drawString(letter,x-15,y);
		}
	}
	public void fillPieChart2(Graphics h, double arr1[], double arr2[]){
		int angle1 = 0; int angle2 = 0; int n = 4; int temp = 0; int j = 0;
		int r,g,b,x,y;
		String probability;
		String letter = "";
		DecimalFormat df = new DecimalFormat("0.0000");
		char n_arr[] = {'a','e','i'};
		for(int i = 0; i < n; ++i){
			// Filling Pie Chart
			r = (int)(Math.random()*256);
			g = (int)(Math.random()*256);
			b = (int)(Math.random()*256);
			Color color = new Color(r,g,b);
			angle1 = (int)arr1[i];	// angle from starting location
			h.setColor(color);
			h.fillArc(700, 100, 400, 400, angle2, angle1);
			angle2 += (int)arr1[i];	 // starting angle
			
			// Formatting probability / letters
			probability = String.valueOf(df.format(arr2[i]));
			if(j < n-1) letter = String.valueOf(n_arr[j]); ++j;
			
			// 2nd legend
			temp += 17;
			h.setFont(new Font("TimesRoman", Font.BOLD, 15));
			h.setColor(Color.BLACK);
			h.drawString(probability,1125,temp); 
			if(i < n-1) h.drawString(letter, 1110, temp);
			else h.drawString("All other letters", 1015, temp);
			
			// Location of the letters
//			x = (int)(900 + 225*Math.sin(180-angle1));
//			y = (int)(300 + 225*Math.cos(180-angle1));
			x = (int)(900 + 225*Math.sin(angle2 + angle1 - .5));
			y = (int)(300 + 225*Math.cos(angle2 + angle1 - .5));
			h.setFont(new Font("TimesRoman", Font.ITALIC, 15));
			h.drawString(probability,x,y);
			if(i < n-1) h.drawString(letter,x-10,y);
			else h.drawString("All other letters",x-110,y);
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		this.setBackground(Color.WHITE);
		
		double chart_angles[] = new double[CAPACITY];
		double chart_probability[] = new double[CAPACITY];
		double chart_nangles[] = new double[4];
		double chart_nprobability[] = new double[4];
		
		HistogramLetters hl = new HistogramLetters();
		chart_angles = hl.get_angles();
		chart_probability = hl.get_probability();
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
		g.setColor(Color.BLUE);
		g.drawString("Frequency of Letter",500,40);
		
		// PIE CHART 1
		g.setColor(Color.BLACK);
		g.drawOval(150, 100, 400, 400);
		// Build Lines + Center
		g.setColor(Color.ORANGE);
		g.drawLine(350, 100, 350, 500);		// vertical line
		g.drawLine(150, 300, 550, 300);		// horizontal line
		g.fillOval(345,295,10,10);			// Center of Oval
		
		fillPieChart1(g,chart_angles,chart_probability);
		
		// PIE CHART 2
		g.setColor(Color.BLACK);
		g.drawOval(700,100,400,400);
		// Build Lines + Center
		g.setColor(Color.ORANGE);
		g.drawLine(900, 100, 900, 500);
		g.drawLine(700, 300, 1100, 300);
		g.fillOval(895,295,10,10);
		
		int n = 0; int m = 0; double prob_sum = 0;
		for(char c = 'a'; c < 'z'; ++c){
			if('a' == c){
				chart_nangles[m] = chart_angles[n];
				chart_nprobability[m] = chart_probability[n];
				prob_sum += chart_nprobability[m];
				++m;
			}
			if('e' == c){
				chart_nangles[m] = chart_angles[n];
				chart_nprobability[m] = chart_probability[n];
				prob_sum += chart_nprobability[m];
				++m;
			}
			if('i' == c){
				chart_nangles[m] = chart_angles[n];
				chart_nprobability[m] = chart_probability[n];
				prob_sum += chart_nprobability[m];
				++m;
			}
			chart_nprobability[m] = 1 - prob_sum;
			chart_nangles[m] = (1-prob_sum) * 360;
			++n;
		}
		fillPieChart2(g,chart_nangles,chart_nprobability);
	}
}
