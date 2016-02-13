import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;


public class Permutation {
	
	//intially pass the level as 0 then will populat the result using this level
	
	public static void permutUtil(char str[],int count[],char [] result,int level)
	{
		//System.out.println("inside");
		if(result.length==level)
		{
		//	System.out.println("d");
			printResult(result);
			System.out.println();
			return;
		}
		
		//if result is not  fill yet we need to check from the left
		
		for(int i=0;i<str.length;i++)
		{
			
			if(count[i]==0)continue;
			
			//other wise place this charater in to the result array
			result[level]=str[i];
			count[i]--;//decrement this count
			permutUtil(str, count, result, level+1); //so that i can search for the next level
			count[i]++;
			
			
		}//end of the for loop
		
		
		
		
		
	}//end of the permututil function

	private static void printResult(char[] result) {
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]);
		
	}

	public static void main(String args[]) throws IOException {

		// here is the code of the string permutation

		String inputString = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputString = br.readLine();
		//System.out.println(inputString);

		// create the tree map to store the
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		// populate the map
		for (int i = 0; i < inputString.length(); i++) {
			if (map.containsKey(inputString.charAt(i))) {
				map.put(inputString.charAt(i), map.get(inputString.charAt(i) )+1);

			} else {

				map.put(inputString.charAt(i), 1);
			}

		}
		// populate the str array and the count array now
		int index = 0;
		char str[] = new char[map.size()+1];
		int count[] = new int[map.size()+1];
		for (Entry<Character, Integer> e : map.entrySet()) {
			str[index] = e.getKey();
			count[index] = e.getValue();
			index++;
		}
//here i will call the util function which will  process all the permutation
		int level=0;
		char result[]=new char[inputString.length()];
permutUtil(str,count,result,level);
		
		

		
		
		
	}

}
