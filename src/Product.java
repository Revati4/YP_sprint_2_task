import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String nameProduct;
        double priceProduct;
        String name;
        double amount = 0;
        while (true) {
            System.out.print("Введите название товара или слово Завершить для окончания подсчета : ");
            nameProduct = scn.next();
            for (nameProduct.equalsIgnoreCase("завершить"); ; ) {
                break;
            }
            //            name = name + nameProduct;
            System.out.print("Введите цену товара: ");
            priceProduct = scn.nextDouble();
            while (priceProduct < 0) {
                System.out.println("Цена товара не может быть отрицательной.");
                System.out.print("Введите цену товара: ");
                priceProduct = scn.nextDouble();
            }
            amount = amount + priceProduct;
            System.out.println(nameProduct + "  " + priceProduct + " " + amount);

        }
    }
}

