package Temprature_Converter_2;

import java.util.Scanner;

public class TempretureConverter {
    static double celsiToFah(double c){
        return (c * 9/5) + 32;
    }
    static double fahToCelsi(double f){
        return  (f -32) * 5/9;
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Tempreture Converter...");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("Choose :");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("Enter the Temp in Celsi");
            double c = sc.nextDouble();
            System.out.println(c + "°C = " + celsiToFah(c) + "°F");
        }else if (choice == 2){
            System.out.println("ENter the Temp in Fah");
            double f = sc.nextDouble();
            System.out.println(f + "°F = " + fahToCelsi(f) + "°C");
        }else {
            System.out.println("Select correct Choice...");
        }
        sc.close();
    }
}
/*
here we've to make temp converter methods (i.e. instance methods) static, bcz the main method is static &
the static main method can't call the instance methods until they are static.
*/


