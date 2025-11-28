package sebelum;

import java.io.*;
import java.util.Vector;

public class ListOfNumbers2 {
    private Vector victor;
    private static final int size = 10;
    public ListOfNumbers2() {
        victor = new Vector(size);
        for (int i = 0; i < size; i++)
            victor.addElement(new Integer(i));
        this.readList("infile.txt");
        this.writeList();
    }
    public void readList(String fileName) {
        String line = null;
        RandomAccessFile raf = new RandomAccessFile(fileName, "r");
        while ((line = raf.readLine()) != null) {
            Integer i = new Integer(Integer.parseInt(line));
            System.out.println(i);
            victor.addElement(i);
        }
    }
    //tambahkan exception jika file tidak ditemukan
    //tambahkan exception untuk output error
    public void writeList() {
        PrintWriter out = null;
        out = new PrintWriter(new FileWriter("outfile.txt"));
        for (int i = 0; i < victor.size(); i++)
            out.println("Value at: " + i + " = " +

                    victor.elementAt(i));
    //Tambahkan Exception jika array melebihi batas
    //Tambahkan Exception untuk output error
    //Tambahkan Exception untuk exception akhir menampilkan Closing Print
        Writer jika out tidak null dan Printwriter not open jika out null
    }

    public static void main(String[] args) {
        new ListOfNumbers2();
    }
}
