import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    String clientName;
    String countType;
    float balance = 0;

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        int iterator = 0;

        do {
            System.out.println("***********************************");
            System.out.println("Welcome to ATM");
            System.out.println("***********************************");
            System.out.println("Do you Want to Start the operation?");
            System.out.println("1-Yes");
            System.out.println("0-Exit");

            iterator = scanner.nextInt();

            if (iterator == 1){
                this.menu();
            } else {
                System.out.println("Bye :)");
            }

        } while(iterator != 0);
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int iterator = 0;

        do{
            System.out.println(" ");
            System.out.println("-------------------------------------");
            System.out.println("Please, select an operation:");
            System.out.println("1-Insert client data");
            System.out.println("2-Recive transfer");
            System.out.println("3-Do transfer");
            System.out.println("4-Send a PIX");
            System.out.println("5-Recive a PIX");
            System.out.println("6-Show Client");
            System.out.println("0-Exit");
            System.out.println("-------------------------------------");

            iterator = scanner.nextInt();

            switch (iterator){
                case 0:
                    System.out.println("Bye :)");
                    break;

                case 1:
                    this.insertClient();
                    break;

                case 2:
                    this.transfers(true);
                    break;

                case 3:
                    this.transfers(false);
                    break;

                case 4:
                    this.transfers(false);
                    break;

                case 5:
                    this.transfers(true);
                    break;

                case 6:
                    this.showClient();
                    break;

                default:
                    System.out.println("Wrong option, try again!!");
                    break;
            }

        } while(iterator != 0);
    }

    public void insertClient(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, type the client's name: ");

        clientName = scanner.next();

        System.out.println("Type client's balance: ");

        balance = scanner.nextFloat();

        System.out.println("Type, client's account Type: ");

        countType = scanner.next();
    }

    public void showClient(){
        System.out.println("Client name: " + clientName);
        System.out.println("Accout type: " + countType);
        System.out.println(String.format("Client balance %.2f", balance));
    }

    public void transfers(boolean positiveTransfer){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, type the value: ");

        if (positiveTransfer){
            balance += scanner.nextFloat();
        } else {
            balance -= scanner.nextFloat();
        }
    }
}