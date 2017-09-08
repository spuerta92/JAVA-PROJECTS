/* Sebastian Puerta Hincapie / 23200457
 * CSc 22100 F (37716): Software Design Laboratory [Spring 2017]
 * Hesham A Auda 
 * Exercise #2
 * March 29, 2017 
 * */

package ex2;
import javax.swing.JFrame;
import java.io.*;
import java.util.*;

public class HistogramLetters {
	// Final
	public final static int CAPACITY = 26;
	
	// Private
	private static Scanner input;
	private static double probability[] = new double[CAPACITY];
	private static double angles[] = new double[CAPACITY];
	
	// Public
	public double[] get_angles(){
		return(angles);
	}
	
	public double[] get_probability(){
		return(probability);
	}
	// Open file
	public static void openFile(){
		try{
			File file = new File("xWords.txt");
			input = new Scanner(file);
		}
		catch(Exception e){
			System.out.println("- Could not open file...");
		}
	}
	// Read file
	public static void readFile(){
		int frequency[] = new int[CAPACITY];
		while(input.hasNext()){
			String w = "";
			String s = input.nextLine();
			s = s.toLowerCase();
			w += s.replaceAll("[^a-zA-Z]"," ");
			int i = 0;
			for(char c = 'a'; c <= 'z'; c++){
				int count = 0;
				for(int j = 0; j < s.length(); j++){
					if(c == w.charAt(j)) count++;
				}
				frequency[i] += count;
				i++;
			}
		}
		// frequency of each letter
		System.out.println("LETTER FREQUENCY");
		for(int i = 0; i < CAPACITY; ++i){
			System.out.print((char)('a'+ i) + ": ");
			System.out.println(frequency[i]);
		}
		// total frequency of all letters
		double freq_sum = 0;
		for(int i : frequency){
			freq_sum += i;
		}
		System.out.println("\nCHAR SUM: \n" + freq_sum);
		// probabilities
		for(int i = 0; i < CAPACITY; ++i){
			probability[i] = frequency[i]/freq_sum;
		}
		System.out.println("\nLETTER PROBABILITY");
		for(int i = 0; i < CAPACITY; ++i){
			System.out.print((char)('a'+ i) + ": ");
			System.out.println(probability[i]);
		}
		// central angles
		for(int i = 0; i < CAPACITY; ++i){
			angles[i] = Math.ceil(probability[i]*360); 		// 2*PI = 360
		}
		System.out.println("\nLETTER CENTRAL ANGLE");
		for(int i = 0; i < CAPACITY; ++i){
			System.out.print((char)('a'+ i) + ": ");
			System.out.println(angles[i]);
		}
	}
	// Close file
	public static void closeFile(){ input.close();}
	
	// Main
	public static void main(String args[]){
		openFile();
		readFile();
		closeFile();
		
		JFrame frame = new JFrame("HISTOGRAM LETTERS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		drawPieChart pie_chart = new drawPieChart();
		frame.add(pie_chart);
		frame.setSize(1200,600);
		frame.setVisible(true);
	}
}
