package DynamicProgramming;
import java.util.*;


public class EditDistanceStrings 
{
   public static int EditDistance(String s1, String s2){
	   //create an array with dimensions of first and second strings.
	   int numRows = s1.length()+1;
	   int numColumns = s2.length()+1;
	   int[][] a = new int[s1.length()+1][s2.length()+1];
	   //loop through and compare Strings.  
       for (int i = 0; i < numRows; i++){
            for (int  j = 0; j < numColumns; j++){
            	if (i == 0){
                    a[i][j] = j;
                } 
                else if (j == 0)
                {
                    a[i][j]= i;
                }
                else if (s1.charAt(i-1) == s2.charAt(j-1)){
                    a[i][j] = a[i-1][j-1]; 
                }
 
                else{
                    a[i][j] = getMin (a[i-1][j]+1,a[i][j-1]+1,a[i-1][j-1]+1);
                }
            }
        }
         
        return a[numRows-1][numColumns-1];
    }

   //find minimum
   private static int getMin(int x, int y)
   {
       return (x < y) ? x : y;
   }
   //find minimum (three parameters) 
   private static int getMin(int x, int y, int z)
   {
       return getMin(getMin(x,y),z);
   }
     
    public static void main(String[] args) 
    {
    	//read Strings from user
    	Scanner keyboard = new Scanner(System.in);
        String s1 = keyboard.next();
        String s2 = keyboard.next();
        
        //return edit distance
        System.out.println(EditDistance(s1, s2));
    }
}
        