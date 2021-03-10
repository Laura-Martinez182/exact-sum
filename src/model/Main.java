package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static BufferedWriter objWriter;
	static BufferedReader objReader;
	

    public static void main(String[] args) throws IOException {
    	
    	objReader = new BufferedReader(new InputStreamReader(System.in));
		objWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(objReader.readLine());
		int M = Integer.parseInt(objReader.readLine());
		 
		
		for (int i = 0; i<=N; i++) {
			String[] prices = objReader.readLine().split(" ");
			int[] eachPrice = new int[prices.length];
		}
		
			
		objWriter.close();
        objReader.close();
		
		
	}


   }

