package com.example.database;

import com.example.entity.Programmer;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextDatabase {
    private static Map<Integer, Programmer> programmers = new HashMap<Integer, Programmer>();

    public static FileInputStream textData;
    static File file;
    static {
        try {
            file = new File("src/main/java/com/example/database/database.txt");
            textData = new FileInputStream(file.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void putData(Programmer ProgrammerObject) throws IOException {
        programmers.put(ProgrammerObject.getId(), ProgrammerObject);
        storeData();
    }

    public static void deleteDataById(int id) throws IOException {
        programmers.remove(id);
        storeData();
    }

    public static void retrieveData(){
        Scanner scanner = new Scanner(textData);
        String [] splitLine;

        while(scanner.hasNextLine()){
            splitLine = scanner.nextLine().split("\\s+");
            programmers.put(Integer.parseInt(splitLine[0]),
                            new Programmer(splitLine[2],
                            Integer.parseInt(splitLine[1])));
        }
        scanner.close();

    }

    public static void storeData() throws IOException {
        try (FileWriter fr = new FileWriter(file, false)) {
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            for(Map.Entry<Integer, Programmer> entry: programmers.entrySet()){
                pr.println(entry.getValue().getId() + " " + entry.getValue().getId() + " " + entry.getValue().getName());
            }
            pr.close();
            br.close();
        }

    }

    public static Map<Integer, Programmer> getProgrammers(){
        return programmers;
    }
}
