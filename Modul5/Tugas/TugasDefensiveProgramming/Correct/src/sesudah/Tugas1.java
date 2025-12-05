package sesudah;

public class Tugas1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println(3 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Terjadi kesalahan: Tidak bisa membagi bilangan bulat dengan nol.");
        }
    }
}