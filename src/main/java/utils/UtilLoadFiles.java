package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilLoadFiles {


    public static List<String[]> listFromFile = new ArrayList<>();
    private static UtilLoadFiles instance;


    private UtilLoadFiles() {
    }

    public static UtilLoadFiles getInstance() {
        if (instance == null) {
            synchronized (UtilLoadFiles.class) {
                if (instance == null) {
                    instance = new UtilLoadFiles();
                }
            }
        }
        return instance;
    }

    public static List<String[]> loadFile(String file) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()) {
                String[] loadLines = bufferedReader.readLine().trim().split(";");
                listFromFile.add(loadLines);
//                Arrays.stream(loadLines).forEach(System.out::print);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie można odnaleźć ścieżki do pliku");
        }


//        Stream<String> stream = Files.lines(Paths.get(file));
//        String[] t = stream.map(x->x.split(";"));

      /*  for (int i = 0; i < listFromFile.size(); i++) {
            String[] someArray = listFromFile.get(i);
            for (int j = 0; j < someArray.length; j++) {
                System.out.println(someArray[j]);
            }
        }*/


        return listFromFile;
    }


}
