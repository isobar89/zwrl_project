package sample;

import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

public class Main2 {

    public static void main(String args) throws IOException {
        //Zapisywanie do pliku
        String fileName = "test.txt";
        DataOutputStream outputStream = null;
        TreeSet<String> tablica = new TreeSet<>();
        int zmi = 0;
        int z = 0;

        String[] cmdarray = {"netstat", "-n"};
        Process process = Runtime.getRuntime().exec(cmdarray);
        Scanner sc = new Scanner(process.getInputStream());
        sc.useDelimiter("\\A");
        String zminna = sc.next();

        try (
                FileOutputStream fs = new FileOutputStream(fileName);
                ObjectOutputStream os = new ObjectOutputStream(fs);
        ) {
            os.writeObject(zminna);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Wczytywanie pliku
        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                if (z > 4) {
                    String zobaczymy = nextLine.substring(5, 30).trim();
                    tablica.add(zobaczymy.substring(0, zobaczymy.length() - 6));
                    zmi++; }
                z++; }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException d) {

        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File f = new File("test2.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter(f);
        for (String s: tablica) {
            fw.write(s+"\r\n");
        }
        fw.close();

    }
}