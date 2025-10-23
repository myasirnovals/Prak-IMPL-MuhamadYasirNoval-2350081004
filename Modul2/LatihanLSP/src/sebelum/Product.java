package sebelum;

import java.util.Date;

abstract class Product {

    abstract String getName();
    abstract Date getExpiredDate();

    abstract String setName(String name);
    abstract Date setExpiredDate(Date date);

    public void getProductInfo() {
        // some magic code
    }
}
