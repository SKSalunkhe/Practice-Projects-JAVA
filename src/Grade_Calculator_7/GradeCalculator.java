package Grade_Calculator_7;

import java.util.Scanner;

public class GradeCalculator {
    static int total(int[] marks){
        int sum = 0;
        for(int m : marks){
            sum += m;
        }
        return sum;
    }

    static double average(int[] marks){
        return (double) total(marks) / marks.length;
    }

    static int highest(int[] marks){
        int max = marks[0];
        for(int m : marks){
            if(m > max){
                max = m;
            }
        }
        return max;
    }

    static int lowest(int[] marks){
        int min = marks[0];
        for (int m : marks){
            if (m < min ){
                min = m;
            }
        }
        return min;
    }

    static String grade(double average){
        if(average >= 90 ) return "A";
        else if (average >= 75) return "B";
        else if (average >= 60) return "C";
        else if (average >= 40) return "D";
        else return "Fail";
    }

    static int outOf(int[] marks){
        int ttl = marks.length * 100;
        return ttl;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many subjects");
        int subNo = sc.nextInt();

        if (subNo <= 1){
            System.out.println("The no of subjects should be more than 1");
            return;
        }

        int[] marks = new int[subNo];

        for(int i=0; i<subNo ; i++){
            int mark;
            do {
                System.out.println("Enter the marks for subject " + (i+1) + " (1-100).");
                mark = sc.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.println("Marks shd be between 0 & 100");
                    return;
                }
            }while (mark < 0 || mark > 100);
            marks[i] = mark;
        }

        System.out.println("/---- Result ----/");
        System.out.println("Out of: " + outOf(marks));
        System.out.println("Total : " + total(marks));
        System.out.println("Average : " + average(marks));
        System.out.println("Highest : " + highest(marks));
        System.out.println("Lowest : " + lowest(marks));
        System.out.println("Grade : " + grade(average(marks)));

        sc.close();
    }
}
