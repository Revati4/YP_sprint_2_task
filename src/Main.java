import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();
//        list.add("one");
//        list.add("two");
//        list.add("three");
//        list.add("four");
//        list.add("five");
//
//        for (int i = 0; i < list.size(); i++) {
//            String str = list.get(i);
//            System.out.println(str);
//        }
        Scanner scn = new Scanner(System.in);

        int guests;
        while (true) {
            System.out.print("Введите количество человек, на которых нужно разделить сумму чека: ");
            guests = scn.nextInt();
            if (guests > 1) {
                System.out.println("Сумма чека будет разделена на " + guests + " человек");
                break;
            } else if (guests < 1) {
                System.out.println("Количество человек введено не верно.");
            } else {
                System.out.println("Один человек оплатит чек в полной сумме.");
            }
        }
        Calculator calculator = new Calculator(); //создание объекта класса Calculator

        String nameProduct;

        double amount = 0;
        double priceProduct;
        while (true) {
            System.out.print("Введите название товара: ");
            nameProduct = scn.next();
            while (true) {
                System.out.print("Введите цену товара: ");
                if (scn.hasNextDouble()) {
                    priceProduct = scn.nextDouble();
                    if (priceProduct < 0) {
                        System.out.println("Цена товара не может быть отрицательной.");
                    }else{
                        break;
                    }
                } else {
                    System.out.println("Число не может содержать букв");
                    scn = new Scanner(System.in);
                }
            }
            Product product = new Product(nameProduct, priceProduct);  //создание объекта класса Product
            calculator.products.add(product);
            System.out.println("Товар успешно добавлен");
            amount = amount + priceProduct;
            System.out.println("Хотите добавить еще товар? (введите завершить для выхода): ");
            String answer = scn.next();
            if(answer.equalsIgnoreCase("завершить")){
                break;
            }
        }

        System.out.println("Добавленные товары: ");
        calculator.printAllProducts();
        double sumPerOnePerson = amount/guests; //сумма на одного человека

        //опредялем окончание
        String ending = getEnding((int)sumPerOnePerson);
        System.out.printf("Каждый человек должен заплатить: %.2f %s%n",sumPerOnePerson, ending);

    }

    /**
     * Метод определяет окончание для рублей
     * @param sum сумма
     * @return окончание
     */
    static String getEnding(int sum){
        double preLastDigit = sum % 100 / 10;
        String ending;
        if (preLastDigit == 1) {
            ending = "рублей";
        }
        preLastDigit = sum % 10;
        if (preLastDigit % 10 == 1) {
            ending = "рубль";
        } else if (preLastDigit == 2 || preLastDigit == 3 || preLastDigit == 4) {
            ending = "рубля";
        } else {
            ending = "рублей";
        }
        return ending;
    }
}
