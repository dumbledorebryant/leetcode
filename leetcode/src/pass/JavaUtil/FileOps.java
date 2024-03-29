package pass.JavaUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class FileOps {
    public void read(String filename){
        try {
            Reader reader = new FileReader(filename);
            int data;
            while ((data = reader.read()) != -1) {
                char ch = (char) data;
                // 处理字符
                System.out.print(ch);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String filename){
        try (Writer writer = new FileWriter("example.txt")) {
        String text = "Hello, World!";
        writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readline(String s){
        try {
            // open file to read
            Scanner scanner = new Scanner(new File("examplefile.txt"));

            // read until end of file (EOF)
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            // close the scanner
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
