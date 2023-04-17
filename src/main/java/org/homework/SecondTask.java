package org.homework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;
import java.nio.charset.StandardCharsets;

import java.util.Scanner;

public class SecondTask {

    public static void main(String[] args) throws IOException {
        File file = new File("file2.txt");

        InputStream fis = new FileInputStream(file);

        Scanner sc = new Scanner(fis);

        String columns = sc.nextLine();

        String[] columnsArr = columns.split(" ");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonArray = new JsonArray();

        while(sc.hasNextLine()) {
            String values = sc.nextLine();
            String[] valuesArr = values.split(" ");

            JsonObject jsonObject = new JsonObject();

            for (int i = 0; i < columnsArr.length; i++) {
                jsonObject.addProperty(columnsArr[i], valuesArr[i]);
            }
            jsonArray.add(jsonObject);
//            Person person = new Person(valuesArr[0], Integer.valueOf(valuesArr[1]));
//            personsList.add(person);
        }


        String json = gson.toJson(jsonArray);


        File jsonFile = new File("jsonres.json");

        FileOutputStream fos = new FileOutputStream(jsonFile);
        fos.write(json.getBytes(StandardCharsets.UTF_8));

        fos.flush();
        fos.close();
    }
}
