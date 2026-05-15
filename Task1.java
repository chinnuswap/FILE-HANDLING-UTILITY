import java.io.*;
import java.util.Scanner;
public class Task1 {
    public static void writeFile(String fileName, String content) {
        try{
           FileWriter writer=new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("File written successfully.");
        }catch(IOException e){
            System.out.println("Error writing file:" + e.getMessage());
        }
    }
    public static void readFile(String fileName)
    {
        try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
            String line;
            System.out.println("\nFile content:");
            while((line=reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public static void appendFile(String fileName, String content){
        try(FileWriter writer=new FileWriter(fileName, true)){
            writer.write("\n" + content);
            System.out.println("content appended successfully.");
        }catch (IOException e){
            System.out.println("Error appending file: " + e.getMessage());
        }
    }
    public static void modifyFile(String fileName, String oldWord, String newWord){
        try {
            File file=new File(fileName);
            BufferedReader reader=new BufferedReader(new FileReader(file));
            StringBuilder content=new StringBuilder();
            String line;
            while ((line=reader.readLine())!= null){
            content.append(line.replace(oldWord,newWord)).append("\n");
            }
            reader.close();
            FileWriter writer=new FileWriter(file);
            writer.write(content.toString());
            writer.close();
            System.out.println("File modified successfully.");
        } catch (IOException e){
            System.out.println("Error modifying file:" + e.getMessage());
        }
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String fileName="sample.txt";
            while (true) {
                System.out.println("\n===== File Handling Utility =====");
                System.out.println("1. Write File");
                System.out.println("2. Read File");
                System.out.println("3. Append File");
                System.out.println("4. Modify File");
                System.out.println("5. Exit");
                System.out.println("Enter choice: ");
                int choice=sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Enter content: ");
                        String writeData=sc.nextLine();
                        writeFile(fileName,writeData);
                        break;
                    case 2:
                        readFile(fileName);
                        break;
                    case 3:
                        System.out.println("Enter content to append: ");
                        String appendData=sc.nextLine();
                        appendFile(fileName,appendData);
                        break;
                    case 4:
                        System.out.println("Enter word to replace: ");
                        String oldWord=sc.nextLine();
                        System.out.println("Enter new word: ");
                        String newWord=sc.nextLine();
                        modifyFile(fileName,oldWord,newWord);
                        break;
                    case 5:
System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                 } 
            }
        }
}
