package sebelum;

import java.util.Date;

public class Vegetable extends Product {
    @Override
    String getName() {
        return "Broccoli";
    }
    @Override
    Date getExpiredDate() {
        return new Date();
    }

    @Override
    String setName(String name) {
        return "";
    }

    @Override
    Date setExpiredDate(Date date) {
        return null;
    }
}
