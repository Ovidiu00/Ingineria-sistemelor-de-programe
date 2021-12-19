package isp.lab2;
import java.util.Scanner;  

public class Exercise1 {

    /**
     * This method should generate an random number between 2 and 10 then
     * should ask user to enter that amount of numbers from keyboard and
     * store the numbers in an int array which should be returned
     *
     * @return the array of numbers read from keyboard
     */
    private static int[] getUserNumbers() {
        
        Scanner sc=new Scanner(System.in);  
        int numarDeNumere = (int)((Math.random() * (10 - 2)) + 2);
        
        String message = String.format("Trebuie sa citesti %s numere!", numarDeNumere);
        System.out.println(message);
                
        int[] numereCititeDeUser = new int[numarDeNumere] ;
        
        for(int i = 0; i < numarDeNumere; i++) {          
            numereCititeDeUser[i] = sc.nextInt();  
        }  
        
       for (int i = 0; i < numarDeNumere; i++){  
            System.out.println(numereCititeDeUser[i]);  
            }  
        
       return numereCititeDeUser;
    }

    /**
     * This method should compute the arithmetical mean of the given numbers
     *
     * @param userNumbers the numbers used to calculate the arithmetical mean
     * @return the arithmetical mean of the given numbers
     */
    protected static double computeTheArithmeticalMean(int[] userNumbers) {
        double mean;
        int sum = 0;
        
        for(int i = 0 ; i < userNumbers.length ; i++){
            sum += userNumbers[i];
        }
        
        
        mean = (double)sum/userNumbers.length;
        
        return mean;
            
    }

    public static void main(String[] args) {
        int[] userNumbers = getUserNumbers();
        System.out.println("Mean number is: " + computeTheArithmeticalMean(userNumbers));
    }


}
