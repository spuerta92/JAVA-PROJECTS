// Sebastian Puerta Hincapie

package ex2;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ReadFile {
	private Scanner input;
	// Open file
	public void openFile(){
		try{
//			File file = new File("xWords.txt");
			File file = new File("xWords.txt");
			input = new Scanner(file);
			System.out.println("File exists");
		}
		catch(Exception e){
			System.out.println("- Could not open file...");
		}
	}
	// Read file
	// 23801 (a)s 
	public void readFile(){
		String word;
		int char_counter = 0;
		int word_counter = 0;
		Pattern pattern = Pattern.compile("[a-z]");
		Matcher matcher;
//		while(input.hasNext()){
//			word = input.next();
//			matcher = pattern.matcher(word);
//			while(matcher.find()){ 
//				System.out.println(matcher.group());
//				++char_counter;
//			}
//			word_counter++;
//		}
//		System.out.println("Number of characters: " + char_counter);
//		System.out.println("Number of words: " + word_counter);
		
		// Letter Frequency Algorithm
		String a;
		int a_counter = 0;
		pattern = Pattern.compile("a");
		while(input.hasNext()){
			a = input.next();
			matcher = pattern.matcher(a);
			while(matcher.find()) a_counter++;
		}
		System.out.printf("Frequency of a: " + a_counter);
		
	}
	// Close file
	public void closeFile(){
		input.close();
	}
}
