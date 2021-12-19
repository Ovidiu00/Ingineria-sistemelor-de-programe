package isp.lab2;

import java.util.Random;

public class Exercise5 {

    /**
     * This method should generate an array that have 20 random nubers between -1000 and 1000
     *
     * @return the random numbers
     */
    public static int[] generateRandomNumbers() {

        int[] randomNumbers = new int[20];

        Random rnd = new Random();

        for(int i = 0  ; i < 20 ; i++){
            int randomValueToDetermineSign = rnd.nextInt(2); //generates either 0 or 1
            int randomValue = rnd.nextInt(1001) ;// generates a random number in [0,1000]

            int signedRandomValue = 0;
            switch (randomValueToDetermineSign){
                case 0:
                    signedRandomValue = randomValue;
                    break;

                case 1:
                    signedRandomValue = - randomValue;
                    break;

            }


            randomNumbers[i] = signedRandomValue;
        }

        return   randomNumbers;
    }

    /**
     * This method should sort the given random numbers
     *
     * @param randomNumbers numbers generated random
     * @return sorted int array
     */
    public static int[] getSortedNumbers(int[] randomNumbers) {

        for(int i = 0 ; i < randomNumbers.length -1; i++)
            for(int j = 0 ; j < randomNumbers.length - i -1 ; j++){
                if(randomNumbers[j] > randomNumbers[j+1])
                {
                    int aux = randomNumbers[j];
                    randomNumbers[j] = randomNumbers[j+1];
                    randomNumbers[j+1] = aux;
                }
            }

        return randomNumbers;

    }

    public static void main(String[] args) {
        // display the random generated numbers
        int[] randomNumbers = generateRandomNumbers();
        System.out.println("The random generated numbers are:");
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i] + ", ");
        }
        int[] sortedNumbers = getSortedNumbers(randomNumbers);
        // display the sorted numbers
        System.out.println("The sorted numbers are:");
        for (int i = 0; i < sortedNumbers.length; i++) {
            System.out.print(sortedNumbers[i] + ", ");
        }
    }
}
