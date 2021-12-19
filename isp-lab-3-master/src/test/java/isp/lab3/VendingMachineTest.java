package isp.lab3;

import isp.lab3.exercise5.VendingMachine;
import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {

    @Test
    public void insertCoin_adding10_accumulatedMoneyIs10(){
        //Arrange
        VendingMachine vendingMachine = new VendingMachine();
        int expected = 10;

        //Act
        vendingMachine.insertCoin(10);

        //Assert

        double acutal = vendingMachine.displayCredit();

        Assert.assertEquals("Accumulated money so far should be 10 ",expected,acutal,0.001);

    }
    @Test
    public void selectProductById_givenValidId_returnsNameOfThatProduct(){
        //Arrange
        VendingMachine vendingMachine = new VendingMachine();
        int id = 1;
        String expected = "Paine";

        //Act
        String actual = vendingMachine.selectProductById(id);

        //Assert

        Assert.assertEquals("Name should be Paine",expected,actual);

    }
    @Test
    public void selectProductById_givenInvalidId_returnsErrorMessage(){
        //Arrange
        VendingMachine vendingMachine = new VendingMachine();
        int id = -1;
        String expected = "No products matching the  given ID were found!";

        //Act
        String actual = vendingMachine.selectProductById(id);

        //Assert

        Assert.assertEquals("The error message should be No products matching the  given ID were found! ",expected,actual);

    }

}
