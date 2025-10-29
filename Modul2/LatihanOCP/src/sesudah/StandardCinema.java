package sesudah;

public class StandardCinema extends Cinema {
    public StandardCinema(Double price) {
        this.price = price;
    }

    @Override
    public Double calculateAdminFee() {
        return price * 10 / 100;
    }
}
