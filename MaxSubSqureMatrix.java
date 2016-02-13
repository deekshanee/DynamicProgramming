/* @uthor :neeraj gupta
 * Dont Copy pls
 * Is for learning purpose
 */
package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSubSqureMatrix {

	public static void getInput(int matrix[][], int dimensionRow,int dimensionCol) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < dimensionRow; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 0; j <dimensionCol; j++) {
				matrix[i][j] = Integer.parseInt(input[j]);

			}

		}

	}

	public static int  min(int a,int b,int c)
	{
		if(a<=b && a<=c)return a;
		else if(b<=a && b<=c)return b;
		else 
			if(c<=a && c<=b)return c;
		return 0;
			
			
				
		
		
	}
	public static int  computeSol(int matrix[][],int dimensionRow,int dimensionCol)
	{
		//create the dummy matrix 
		int dummyMat[][]=new int [dimensionRow+1][dimensionCol+1];
		for(int i=0;i<=dimensionRow;i++)
			dummyMat[i][0]=0;
		for(int i=0;i<=dimensionCol;i++)
			dummyMat[0][i]=0;
		
		for(int i=1;i<=dimensionRow;i++)
		{
			for(int j=1;j<=dimensionCol;j++)
			{
				//choose the minimum from (i)(j-1)(i-1)(j) and (i-1)(j-1) to ensure the square
				if(matrix[i-1][j-1]==1)
				dummyMat[i][j]=min(dummyMat[i][j-1],dummyMat[i-1][j-1],dummyMat[i-1][j])+1;
				else dummyMat[i][j]=0;
				
			}
			
		}
		//find the maximum value in the result matrix
		int max=0;
		for(int i=0;i<=dimensionRow;i++)
		{
			for(int j=0;j<=dimensionCol;j++)
			if(max<dummyMat[dimensionRow][dimensionCol])max=dummyMat[dimensionRow][dimensionCol];
		}
		
		return max;
	}

	public static void main(String args[]) throws NumberFormatException, IOException {

		int dimensionRow = 0,dimensionCol=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dimensionRow = Integer.parseInt(br.readLine());
		dimensionCol = Integer.parseInt(br.readLine());
		// create the matrix of the dimension
		int matrix[][] = new int[dimensionRow][dimensionCol]; // eg 3x3
		// get the input

		getInput(matrix, dimensionRow,dimensionCol);
		// calculate the size of the square matrix with maximum one
		int result=0;
		result=computeSol(matrix, dimensionRow,dimensionCol);
		if(result==0)
			System.out.println("No such Matrix");
		else
		System.out.println(result);
		
	
	}

}
