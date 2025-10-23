package sesudah;

import java.util.Date;

public class Vegetable extends FoodProduct {
    @Override
    String getName() {
        return "Broccoli";
    }

    @Override
    String setName(String name) {
        return "";
    }

    @Override
    Date getExpiredDate() {
        return new Date();
    }

    @Override
    java.util.Date setExpiredDate() {
        return null;
    }
}
