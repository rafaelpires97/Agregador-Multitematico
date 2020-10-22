package pt.ulusofona.java.model;

import pt.ulusofona.java.utils.SearchParser;

import java.io.*;
import java.util.ArrayList;

public class readFile {

    public static void read() throws IOException {
        BufferedReader reader;
        try {
            boolean existsQuery = false;
            reader = new BufferedReader(new FileReader(
                    "src" + File.separator + "main" + File.separator + "java" + File.separator + "pt" + File.separator + "ulusofona" + File.separator + "java" + File.separator + "recurso" + File.separator + "search_input.txt"));
            String line = reader.readLine();
            int count =0;
            ArrayList<String> novo = new ArrayList<>();
            while (line != null) {
                if (line.equals("true")) {
                    if(existsQuery){
                        novo =SearchParser.start(line);
                        break;
                    }
                    existsQuery = true;
                }   // read next line
                line = reader.readLine();
                count++;
            }
            if (existsQuery) {
                write(novo);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void write(ArrayList<String> n) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("src" + File.separator + "main" + File.separator + "java" + File.separator + "pt" + File.separator + "ulusofona" + File.separator + "java" + File.separator + "recurso" + File.separator + "search_input.txt", true));
            writer.write("false\n");
            for (String s : n) {
                writer.write(s + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}






