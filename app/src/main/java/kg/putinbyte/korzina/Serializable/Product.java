package kg.putinbyte.korzina.Serializable;

import java.io.Serializable;

/**
 * Created by Oma on 04.05.2017.
 */

public class Product implements Serializable {
    String name,image,price;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
