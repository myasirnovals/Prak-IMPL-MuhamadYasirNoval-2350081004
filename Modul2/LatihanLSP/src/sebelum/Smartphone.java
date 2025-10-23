package sebelum;

import java.util.Date;

public class Smartphone extends Product {
    @Override
    String getName() {
        return "";
    }

    @Override
    Date getExpiredDate() {
        return null;
    }

    @Override
    String setName(String name) {
        return "Samsung S10+ Limited Edition";
    }

    @Override
    Date setExpiredDate(Date date) {
        return new Date();
    }
}
