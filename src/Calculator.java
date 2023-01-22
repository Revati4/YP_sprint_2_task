import java.util.ArrayList;

public class Calculator {
    ArrayList<Product> products = new ArrayList<>();

    public void printAllProducts(){
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println(product.name);
        }
    }

}
