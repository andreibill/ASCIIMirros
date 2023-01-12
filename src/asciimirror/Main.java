package asciimirror;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> readFile(String filePatch, Scanner fileRead){
        List<String> animal = new ArrayList<>();
        int longestLine = 0;

        while (fileRead.hasNext()){
            String fileContent = fileRead.nextLine();
            animal.add(fileContent);
            if(fileContent.length() > longestLine){
                longestLine = fileContent.length();
            }
        }
        for (String line : animal) {
            String whiteSpaces = "";
            for(int i = 0; i < longestLine - line.length(); i++){
                whiteSpaces.concat(" ");
            }
            line.concat(whiteSpaces);
        }
        return animal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        String filePatch = scanner.nextLine();
        List<String> animal = new ArrayList<>();
        int longestLine = 0;
        try{
            File file = new File(filePatch);
            Scanner fileRead = new Scanner(file);
            while (fileRead.hasNext()){
                String fileContent = fileRead.nextLine();
                animal.add(fileContent);
                if(fileContent.length() > longestLine){
                    longestLine = fileContent.length();
                }
            }
            for (String line : animal) {
                int size = longestLine - line.length();
                for(int i = 0; i < size; i++){
                    line += ' ';
                }
                StringBuilder lineReversed = new StringBuilder();
                char c;
                for(int i = 0; i < line.length(); i++){
                    c = line.charAt(i);
                    switch (c){
                        case '<': c = '>';break; case '>':
                            c = '<';break; case '[':
                            c = ']';break; case ']':
                            c = '[';break; case '{':
                            c = '}';break; case '}':
                            c = '{';break; case '(':
                            c = ')';break; case ')':
                            c = '(';break; case '/':
                            c = '\\';break; case '\\': c = '/';break;
                    }
                    lineReversed.insert(0, c);
                }
                System.out.println(line + " | " + lineReversed);
            }
        }catch (Exception e){
            System.out.println("File not found");
        }
    }
}