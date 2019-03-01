package packingpaper;
import java.util.Arrays; 
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Rafal Kurasz
 */
public class PackingPaper {


   
    public static int requiredPackingPaper(int a, int b, int c){
    // Method to calculate required area of paper for 1 box     
        int[] wallArea = {a*b, a*c, b*c};
        Arrays.sort(wallArea);
        int sum = 0;
        for (int i = 0; i<3; i++){
            if (i == 0) { sum = sum + wallArea[i]*3; }
            else { sum = sum + wallArea[i]*2; }
        }      
        return sum; 
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {        
    int totalPaper = 0;   
    int i=0; 
    String[] inputString={};

    Scanner in = new Scanner(new File("c:\\test_input.txt")).useDelimiter("x");
    //import data file from drive c:/
    
    StringBuilder sb = new StringBuilder();
    //build input string
    
    while(in.hasNextLine()){
        sb.append(in.nextLine() +"x");
        //add x at end of the line
        inputString=sb.toString().split("x");
        //build string with splited dimensions of boxes 
    }    
    in.close();
 
        int[] inputArray=new int[inputString.length];
        //array with splited data strings
        for(i = 0; i<inputString.length;i++){
            //conert string array to int array
        inputArray[i]=(Integer.valueOf(inputString[i]));
        }

        int[][] inputMatrix=new int[inputArray.length/3][3];   
       
      int l=0;
      i = 0;
        while(i<inputArray.length){
            //build data int matrix with dimensions of boxes
            for (int k =0; k<3; k++){
                if (i<inputArray.length){
                    inputMatrix[l][k]=inputArray[i];
                    i++;
                }
                }
            l++;
            }
               
    for (i=0; i<inputMatrix.length;i++){
        //calculate paper area for all boxes
        totalPaper=totalPaper+requiredPackingPaper(inputMatrix[i][0],inputMatrix[i][1],inputMatrix[i][2]);
    }        

    System.out.println(totalPaper);
    }
    
}
