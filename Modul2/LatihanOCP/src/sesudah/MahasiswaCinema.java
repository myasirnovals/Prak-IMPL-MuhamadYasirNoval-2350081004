package sesudah;

public class MahasiswaCinema extends Cinema {
    public MahasiswaCinema(Double price) {
        this.price = price;
    }
    @Override
    public Double calculateAdminFee() {
        return price * 5 / 100;
    }
}
