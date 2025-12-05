package sesudah;

import java.io.*;
import java.util.Vector;

public class ListOfNumbers2 {
    private Vector<Integer> victor;
    private static final int size = 10;

    public ListOfNumbers2() {
        victor = new Vector<Integer>(size);
        for (int i = 0; i < size; i++) {
            victor.addElement(Integer.valueOf(i));
        }

        this.readList("infile.txt");
        this.writeList();
    }

    public void readList(String fileName) {
        String line = null;
        RandomAccessFile raf = null;

        try {
            raf = new RandomAccessFile(fileName, "r");
            while ((line = raf.readLine()) != null) {
                Integer i = Integer.valueOf(Integer.parseInt(line));
                System.out.println(i);
                victor.addElement(i);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File " + fileName + " tidak ditemukan.");
        } catch (IOException e) {
            System.err.println("Error: Gagal membaca file. " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Format angka dalam file salah.");
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    System.err.println("Error saat menutup file input.");
                }
            }
        }
    }

    public void writeList() {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter("outfile.txt"));

            for (int i = 0; i < victor.size(); i++) {
                try {
                    out.println("Value at: " + i + " = " + victor.elementAt(i));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error: Index array melebihi batas pada index " + i);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: Gagal menulis ke outfile.txt");
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    public static void main(String[] args) {
        new ListOfNumbers2();
    }
}