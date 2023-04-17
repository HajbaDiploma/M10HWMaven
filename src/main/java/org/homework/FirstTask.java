package org.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FirstTask {

    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");

        System.out.println("file.exists() = " + file.exists());

        InputStream fis = new FileInputStream(file);

        Scanner s = new Scanner(fis);
        ArrayList<String> numbers = new ArrayList<>();
        Pattern pattern1 = Pattern.compile("^[0-9]{3}[\\-][0-9]{3}[\\-][0-9]{4}$", Pattern.CASE_INSENSITIVE);
        Pattern pattern2 = Pattern.compile("^[(][0-9]{3}[)][\\s]?[0-9]{3}[\\-][0-9]{4}$", Pattern.CASE_INSENSITIVE);

        while(s.hasNextLine()) {
            String s1 = s.nextLine();
            if (pattern1.matcher(s1).find() || pattern2.matcher(s1).find()) {
                numbers.add(s1);
            }
        }

        for(String number : numbers){
            System.out.println(number);
        }

        fis.close();
    }
}
