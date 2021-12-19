package isp.lab3.exercise5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class VendingMachine {



    private List<Product> Products;
    private double accumulatedMoney;

    public  VendingMachine(){
        Products = new ArrayList<Product>();

        Products.add( new Product(1,"Paine",3));
        Products.add( new Product(2,"Suc",8.3));
        Products.add( new Product(3,"Ciocolata",2));
        Products.add( new Product(4,"Apa",1.4));
    }

    public void displayProducts ()
    {
        for(Product product : Products){
            System.out.println(product.toString());
        }
    }
    public void insertCoin(int value)
    {
        accumulatedMoney += value;
    }
    public String selectProductById(int ID) {


        for (Product product : Products) {
            if (product.ProductID == ID) {
                return product.Name;
            }
        }

       return "No products matching the  given ID were found!";
    }
    public double  displayCredit(){
        System.out.println(accumulatedMoney);

        return accumulatedMoney;
    }

    public void userMenu(){

        int userInput = 0;

        System.out.println("1.Display all products \n ");
        System.out.println("2.Insert coin  \n ");
        System.out.println("3.Select product by ID \n ");
        System.out.println("4.Display credit \n ");
        System.out.println("5.Exit \n ");

        Scanner scanner = new Scanner(System.in);


        while (userInput != 5){

            userInput = scanner.nextInt();

        switch (userInput)
        {
            case 1:
                displayProducts();
                break;
            case 2:
                System.out.println("Value to insert : \n");
                int value = scanner.nextInt();
                insertCoin(value);

                break;

            case 3:
                System.out.println("Insert product's ID : \n");
                int ID = scanner.nextInt();
                String result = selectProductById(ID);

                System.out.println(result);

                break;
            case 4:
                displayCredit();

                break;

            case 5:
                break;
        }
        }

    }




}
