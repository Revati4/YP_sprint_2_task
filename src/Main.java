import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int guests;
        while (true) {
            System.out.print("Введите количество человек, на которых нужно разделить сумму чека: ");
            guests = scn.nextInt();
            if (guests > 1) {
                System.out.println("Сумма чека будет разделена на "+ guests + " человек");
                // наверное, надо отсюда еще  класс Calculate запускать, если так можно
                break;
            } else if (guests < 1) {
                System.out.println("Количество человек введено не верно.");
            } else if (guests == 1) {
                System.out.println("Один человек оплатит чек в полной сумме.");
            }
        }

    }
}