import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* @uthor:so_what */
//minimum nmber of coins required to make the sum of m rupee having n coins

public class MinimumCoinRequired {

	public static int min(int a, int b) {

		if (a > b)
			return b;
		else
			return a;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		// having the inut contains some coins

		

		int n = 0;
		
		
		int sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Number of Coins");
		n = Integer.parseInt(br.readLine());
		String[] coins = new String[n+1]; // store all the coins
		String input;
		input=br.readLine();
		coins=input.split(" ");
			
		System.out.println("Enter the sum");
		sum = Integer.parseInt(br.readLine());

		int[] finalResult = new int[sum + 1];
		for (int i = 0; i <=sum; i++)
			finalResult[i] = Integer.MAX_VALUE;
		// bottom up filling
		finalResult[0]=0;
		for (int i = 0; i < n; i++) {

			for (int j = 1; j <= sum; j++) {

				if (Integer.parseInt(coins[i]) <= j) // if the required sum is greater thn j
				{
					// now check the required coint

					finalResult[j] = min(finalResult[j], finalResult[j - Integer.parseInt(coins[i])] + 1);

				} // end of the if statement

			} // to ensure how mny coins needed to jth sum

		} // take the ith coins
		System.out.println(finalResult[sum]);

	}

}
