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
    int suma = 0;   

    int i=0; 
    String[] Test={};

    Scanner in = new Scanner(new File("c:\\test_input.txt")).useDelimiter("x");
    //import data file from drive c:/
    
    StringBuilder sb = new StringBuilder();
   
    while(in.hasNextLine()){
        sb.append(in.nextLine() +"x");
        //change new line to x
        Test=sb.toString().split("x");
    }    
    in.close();
 
        int[] Test3=new int[Test.length];         
        for(i = 0; i<Test.length;i++){
        Test3[i]=(Integer.valueOf(Test[i]));
        }

        int[][] Test2=new int[Test3.length/3][3];        
      int l=0;
      i = 0;
        while(i<Test3.length){
            for (int k =0; k<3; k++){
                if (i<Test3.length){
                    Test2[l][k]=Test3[i];
                    i++;
                }
                }
            l++;
            }
               
    for (i=0; i<Test2.length;i++){
        suma=suma+requiredPackingPaper(Test2[i][0],Test2[i][1],Test2[i][2]);
    }        

    System.out.println(suma);
    }
    
}
