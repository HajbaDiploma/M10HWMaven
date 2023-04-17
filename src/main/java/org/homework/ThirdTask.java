package org.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

public class ThirdTask {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("words.txt");

        InputStream fis = new FileInputStream(file);

        Scanner scanner = new Scanner(fis);
        StringJoiner sb = new StringJoiner(" ");

        while(scanner.hasNextLine()){
            sb.add(scanner.nextLine());
        }

        String allWords = sb.toString();

        String[] words = allWords.split("\\s+");

        HashMap<String, Integer> myWordsCount = new HashMap<String, Integer>();
        for (String s : words){
            if (myWordsCount.containsKey(s)) myWordsCount.replace(s, myWordsCount.get(s) + 1);
            else myWordsCount.put(s, 1);
        }
        System.out.println(myWordsCount);

    }


}
