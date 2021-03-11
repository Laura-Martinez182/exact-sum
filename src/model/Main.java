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
	static int minimalDifference = Integer.MAX_VALUE;
	static int book1;
	static int book2;

	public static void main(String[] args) throws IOException {

		objReader = new BufferedReader(new InputStreamReader(System.in));
		objWriter = new BufferedWriter(new OutputStreamWriter(System.out));


		//ciclo 
		 minimalDifference = Integer.MAX_VALUE;
		 book1 = -1;
		 book2 = -1;
		
		int N = Integer.parseInt(objReader.readLine());


		String[] prices = objReader.readLine().split(" ");
		int[] eachPrice = new int[N];

		for (int b=0; b < prices.length;b++) {
			eachPrice[b] = Integer.parseInt(prices[b]);

		}

		int money = Integer.parseInt(objReader.readLine());

		addSorted(eachPrice);
		minimalDifference(eachPrice, money);
		System.out.println(book1+" "+book2);

	}
	//objWriter.close();
	//objReader.close();




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


	public static void minimalDifference(int[] eachPrice, int money) {
		int searchValue = 0;
		int count = 0;
		for(int i = 0; i<eachPrice.length; i++) {
			searchValue = money-eachPrice[i];	
			int pos = binarySearch(eachPrice, searchValue);
			if (pos >= 0) {
				int localDifference = Math.abs(eachPrice[i] - eachPrice[pos]);
				System.out.println(Arrays.toString(eachPrice));
				System.out.println(minimalDifference);
				System.out.println(localDifference);
				System.out.println(eachPrice[i]);
				System.out.println(eachPrice[pos]);
				
				if(localDifference < minimalDifference || count==0) {
					book1 = eachPrice[i];
					book2 = eachPrice[pos];
					minimalDifference = localDifference;
				}

				count++;
			}

		}


	}
}







