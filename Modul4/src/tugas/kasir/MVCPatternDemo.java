package tugas.kasir;

import tugas.kasir.Barang;
import tugas.kasir.KasirView;
import tugas.kasir.KasirController;

public class MVCPatternDemo {
    public static void main(String[] args) {
        Barang barang = new Barang("GeForce GTX 1060Ti", 3000, 10);

        KasirView view = new KasirView();

        KasirController controller = new KasirController(barang, view);

        controller.executeTransaction();
    }
}