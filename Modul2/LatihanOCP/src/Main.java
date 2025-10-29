import sesudah.*;

public class Main {
    public static void main(String[] args) {
        MahasiswaCinema mhsCinema = new MahasiswaCinema(100.0);
        Double adminFee = mhsCinema.calculateAdminFee();
        System.out.println(adminFee);
    }
}