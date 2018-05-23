/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NIIT-ICT
 */
public class ReadFile {

    /**
     * @param args the command line arguments
     */
    public ReadFile() {
    }

    // nen dung vs file nhi phan
    public void fileInputStream() throws IOException { // gan static
        int chars;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("EmptyFile.txt");

            while ((chars = fileInputStream.read()) != -1) {
                System.out.print((char) chars);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
                System.out.println("*********");
                System.out.println("END READING! _ fileInputStream");
            }
        }
    }

    // nen dung vs txt
    public void fileReader() throws FileNotFoundException, IOException {
        File file = new File("EmptyFile.txt");
        if (file.exists()) {
        } else {
            file.createNewFile();
        }
        String line;

        FileReader fr = null;
        fr = new FileReader(file);
//        
//        char [] chrs = new char [50]; 
//        fr.read(chrs);  // doc tung characters
//        
//        for (char c : chrs){
//            System.out.print(c);
//        }

        BufferedReader br = null; // doc ca cum buffer
        br = new BufferedReader(fr);

        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("*********");
            System.out.println("END READING _ fileReader!");
        }
    }

    public void writeFile() throws IOException {
        File file = new File("EmptyFile.txt");
        if (file.exists()) {
        } else {
            file.createNewFile();
        }

        String line;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter(new File("ReRead.txt"));
        BufferedWriter bw = new BufferedWriter(fw);

        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.write("\n");
        }

        bw.close();
        br.close();
        fr.close();
        fw.close();

        System.out.println("*********");
        System.out.println("END READING _ writeFile!");
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        // khong dung public static void fileReader() thi phai khoi tao Object
//        fileInputStream();  => khi khai bao static void fileInputStream()
        ReadFile readFile;
        readFile = new ReadFile();
//        readFile.fileInputStream();
//        readFile.fileReader();

        readFile.writeFile();
    }

}
