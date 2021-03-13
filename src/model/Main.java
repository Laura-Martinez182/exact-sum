package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static BufferedWriter objWriter;
	static BufferedReader objReader;
	static int N;
	static int money;
	static int[] eachPrice;
	static int minimalDifference = Integer.MAX_VALUE;
	static int book1;
	static int book2;
	static ArrayList<String[]> generalData = new ArrayList<String[]>(); 

	public static void main(String[] args) throws IOException {
		
		

		objReader = new BufferedReader(new InputStreamReader(System.in));
		objWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = objReader.readLine();
		int pass = 0;

		while(line!=null) {

			minimalDifference = Integer.MAX_VALUE;
			book1 = -1;
			book2 = -1;
			String[] data = new String[3];
			
			data[0] = line;
			
			line = objReader.readLine();
			data[1] = line;
			

			line = objReader.readLine();
			data[2] = line;

			line = objReader.readLine();
			line = objReader.readLine();
			pass++;
			
			generalData.add(data);
		}
		
		objReader.close();
		
		
		for(int i = 0; i < pass; i++) {
			
			N = Integer.parseInt(generalData.get(i)[0]);
			
			String[] prices = generalData.get(i)[1].split(" ");
			eachPrice = new int[N];
			for (int b=0; b < prices.length;b++) {
				eachPrice[b] = Integer.parseInt(prices[b]);

			}
			
			money = Integer.parseInt(generalData.get(i)[2]);
			
			addSorted(eachPrice);
			difference(eachPrice, money);
			objWriter.write("Peter should buy books whose prices are " +book1+ " and " +book2+".".trim());
			objWriter.write("\n\n");
			
			
		}
		
		objWriter.flush();
		objWriter.close();
		 
	}




	public static void addSorted(int[] eachPrice) {
		Arrays.sort(eachPrice);
	}

	public static int binarySearch(int[] eachPrice, int money) {
		int pos = -1;
		int i = 0;
		int j = eachPrice.length-1;


		while(i<=j && pos<0) {
			int middle = (i+j)/2;
			if(eachPrice[middle]== money) {
				pos = middle;
			}else if(eachPrice[middle] > money) {
				j = middle-1;
			}else {//if (eachPrice[middle] < money)
				i = middle+1;
			}
		}

		return pos;
	}


	public static void difference(int[] eachPrice, int money)  throws IOException {
		int searchValue = 0;
		int count = 0;
		for(int i = 0; i<eachPrice.length; i++) {
			searchValue = money-eachPrice[i];	
			int pos = binarySearch(eachPrice, searchValue);
			if (pos >= 0) {
				int localDifference = Math.abs(eachPrice[i] - eachPrice[pos]);
					
				if((localDifference < minimalDifference || count==0) && i!=pos) {
					book1 = eachPrice[i];
					book2 = eachPrice[pos];
					minimalDifference = localDifference;
				}

				count++;
			}

		}

	}
}


