package ToDo_3;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private boolean isDone;

    public Task(String title, String description){
        this.title = title;
        this.description = description;
        this.isDone = false;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public boolean isDone(){
        return isDone;
    }
    public void markDone(){
        isDone = true;
    }
}

public class ToDoApp {
    static ArrayList<Task> tasks = new ArrayList<>();

    static void addTask(String title, String description){
        tasks.add(new Task(title, description));
        System.out.println("Task Added...");
    }

    static void markComplete(int num){
        if(num < 1 || num > tasks.size()){
            System.out.println("Invalid task Number...");
            return;
        }
        tasks.get (num - 1).markDone();
        System.out.println("Task is marked as Completed");
    }

    static void showTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks are scheduled.");
            return;
        }
        for(int i = 0 ; i < tasks.size() ; i++){
            Task t = tasks.get(i);
            String status = t.isDone() ? "[✓]" : "[x]";
            System.out.println((i + 1) + ". " + status + " " + t.getTitle() );
            System.out.println("    " + t.getDescription());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Welcome to the ToDo App");
            System.out.println("1. Enter new Task.");
            System.out.println("2. Mark task complete ");
            System.out.println("3. View tasks.");
            System.out.println("4. Exit");
            System.out.println("Choose : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 :
                    System.out.println("Enter the task Title.");
                    String title = sc.nextLine();
                    System.out.println("Enter Description.");
                    String description = sc.nextLine();
                    addTask(title, description);
                    break;
                case 2 : showTasks();
                    System.out.println("Enter task number.");
                    markComplete(sc.nextInt());
                    break;
                case 3 : showTasks();
                    break;
                case 4 :
                    System.out.println("GoodByee...");
                    break;
                default :
                    System.out.println("Select correct choice");
            }
            System.out.println("Thank Youuu...");
            System.out.println();
            System.out.println();
            /*break*/;
        }while (choice != 4);

        sc.close();
    }
}
