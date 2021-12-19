package isp.lab3.exercise5;

public class Product {

        public int ProductID;
        public String Name;
        public double Price;

        public Product(int ProductID,String Name, double Price)
        {
            this.ProductID = ProductID;
            this.Name = Name;
            this.Price = Price;
        }

    @Override
    public String toString() {
        return String.format("ProductID : %d named %s costing %f",ProductID,Name,Price);
    }
}
