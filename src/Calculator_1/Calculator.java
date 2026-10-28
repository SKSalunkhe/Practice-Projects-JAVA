import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    static double add(double a,double b){
        return a + b;
    }
    static double sub(double a, double b){
        return a - b;
    }
    static double multi(double a,double b){
        return a * b;
    }
    static double div(double a,double b){
        if (b == 0){
            throw new ArithmeticException("Cannot deivide by 0");
        }
        return a/b;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Hello to our Calculator....");
            System.out.println("1. Add");
            System.out.println("2. Sub");
            System.out.println("3. Multi");
            System.out.println("4. Div");
            System.out.println("Choose : ");

            try{
                choice = sc.nextInt();

                if (choice == 5){
                    System.out.println("GoodBye....");
                    break;
                }
                if(choice < 1 || choice > 5){
                    System.out.println("Please choose the valid no..");
                    break;
                }

                System.out.println("Enter 1st Number : ");
                double a = sc.nextDouble();
                System.out.println("Enter 2nd Number : ");
                double b = sc.nextDouble();

                double result = 0;

                switch (choice){
                    case 1 : result = add(a, b); break;
                    case 2 : result = sub(a, b); break;
                    case 3 : result = multi(a, b); break;
                    case 4 : result = div(a, b); break;
                }
                System.out.println("Result = " + result);
                break;
            }
            catch (ArithmeticException e){
                System.out.println("Error : " + e.getMessage());
                choice = 0;
                break;
            }
            catch (InputMismatchException  e){
                System.out.println("Only numbers...");
                sc.nextLine();
                choice = 0;
                break;
            }
        }while (choice != 5);

        sc.close();
    }
}
