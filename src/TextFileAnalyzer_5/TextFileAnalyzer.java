package TextFileAnalyzer_5;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class TextFileAnalyzer {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file path :");
        String path = sc.nextLine();

        System.out.println("Enter word to Search : ");
        String target = sc.nextLine().trim().toLowerCase();

        int lines = 0;
        int words = 0;
        int chars = 0;
        int matches = 0;

        try{
            Scanner fileReader = new Scanner(new File(path));

            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                lines++;
                chars += line.length();

                String[] wordlist = line.split(" ");
                for (String w : wordlist){
                    if(!w.isEmpty()){
                        words++;
                        if(w.toLowerCase().equals(target)){
                            matches++;
                        }
                    }
                }
            }

            fileReader.close();

            System.out.println("Lines : " + lines);
            System.out.println("Words : " + words);
            System.out.println("MAtches : " + matches);
            System.out.println("\"" + target + "\" found " + matches + " time(s)." );
        } catch (FileNotFoundException e) {
            System.out.println("File not Found..." + path);
        }
        sc.close();
    }
}
