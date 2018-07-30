package app.Messenger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TradeOrder {
    private String buy;
    private String id;
    private String price;
    private String size;
    private String stock;
    private String whenAsDate;


    public TradeOrder(String buy, int id, double price, int size, String stock){
       this.buy = buy;
       this.id = Integer.toString(id);
       this.price = Double.toString(price);
       this.size = Integer.toString(size);
       this.stock = stock;

       DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
       TimeZone tz = TimeZone.getTimeZone("Etc");
       df.setTimeZone(tz);
       this.whenAsDate = df.format(new Date());

    }
    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getWhenAsDate() {
        return whenAsDate;
    }

    public void setWhenAsDate(String whenAsDate) {
        this.whenAsDate = whenAsDate;
    }
}
