package isp.lab2;


import java.util.ArrayList;
import java.util.List;

public class Exercise6 {

static int[] generatedVector;


    /**
     * This method should generate the required vector non-recursively
     *
     * @param n the length of teh generated vector
     * @return the generated vector
     */
    public static int[] generateVector(int n) {
       generatedVector = new int[n];

       generatedVector[0] = 1;
       generatedVector[1] = 2;

        for (int i = 2; i < n; i++) {
            generatedVector[i] = generatedVector[i-1] * generatedVector[i-2];
        }

        return generatedVector;


    }


    /**
     * This method should generate the required vector recursively
     *
     * @param n the length of teh generated vector
     * @return the generated vector
     */

    public static int f(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 2;
        else
            return (f(n - 1) * f(n - 2));
    }

    public static int[] generateRandomVectorRecursively(int n) {
       generatedVector = new int[n];

        int i = 0;
        for (int c = 1; c <= n; c++) {

           generatedVector[i] = f(i);
            i++;
        }
        return generatedVector;
    }

    public static void main(String[] args) {

        int[] generatedVectorNotRec = Exercise6.generateVector(8);
        int[] generatedVectorRec = Exercise6.generateRandomVectorRecursively(8);

        System.out.println("Generated vector not recursive \n ");
        for(int i = 0 ; i < generatedVectorNotRec.length ; i++){
            System.out.println(generatedVectorNotRec[i] + " ");
        }
        System.out.println("Generated vector  recursive \n ");
        for(int i = 0 ; i < generatedVectorRec.length ; i++){
            System.out.println(generatedVectorRec[i] + " ");
        }

    }
}
