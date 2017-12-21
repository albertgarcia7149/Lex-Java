//-----------------------------------------------------------------------------
//Albert Garcia
//awgarcia
//pa1
//--------

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Lex {

	public static void main(String[] args) throws IOException {
		if(args.length!=2) {
			//Send Usage Message
			System.out.println("ERROR:This program requires 2 txt doc arguments");
		}else {
			//Setup
			Scanner in =null;
			PrintWriter out=null;
			String line=null;
			int lineNumber=0;
			//check if right arg size
			if(args.length!=2) {
				System.err.println("Usage: FileIO infile outfile");
				System.exit(1);
			}
			//make array with size (number of lines in file)
			Scanner lineCounter= new Scanner(new File(args[0]));
			int count=0;
			while(lineCounter.hasNextLine()) {
				count++;
				lineCounter.nextLine();
			}
			lineCounter.close();
			String[] input = new String[count];
			// make read and write
			in=new Scanner(new File(args[0]));
			out= new PrintWriter(new FileWriter(args[1]));
			//Puts data into array
			while(in.hasNextLine()) {
				line=in.nextLine()+" "; //Gets the line
				input[lineNumber]=line;
				lineNumber++;
			}
			List l1 =new List();
			//send list input
			
			for(int i=0;i<input.length;i++) {
				
				if(l1.length()==0) {
					l1.append(i);
				}else {
					l1.moveFront();
					while(l1.index()!=-1 && input[i].compareTo(input[l1.get()])>0) {
							
						l1.moveNext();
					}
					if(l1.index()==-1){
						l1.append(i);
					}else{
						l1.insertBefore(i);
					}
					
				}	
			}
			//receive output
			l1.moveFront();
			while(l1.index()!=-1) {
				out.println(input[l1.get()]);
				l1.moveNext();
			}
			//close files
			in.close();
			out.close();
		}

	}

}
