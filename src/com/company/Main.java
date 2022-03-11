package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\aleks\\Desktop\\File.txt");
        System.out.println(file.length());
        System.out.println(file.lastModified());

        File folder = new File("C:\\Users\\aleks\\Desktop\\Folder");
        File[] files = folder.listFiles();

        for (File file1 : files) {
            System.out.println(file1.getAbsoluteFile());
        }

        StringBuilder builder = new StringBuilder();

        try {
            FileInputStream is = new FileInputStream("C:\\Users\\aleks\\Desktop\\File.txt");
            for (;;){
                int code = is.read();
                if (code < 0){
                    break;
                }
                char ch = (char) code;
                builder.append(ch);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());

        StringBuilder builder1 = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader (new FileReader("C:\\Users\\aleks\\Desktop\\File.txt"));
            for (;;){
                String line = bufferedReader.readLine();
                if (bufferedReader == null){
                    break;
                }
                builder.append(line + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());

        StringBuilder builder2 = new StringBuilder();

        try {

            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\aleks\\Desktop\\File.txt"));
            lines.forEach(line -> builder2.append(line + "\n"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());
    }
}
