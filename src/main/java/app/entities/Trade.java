package app.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="trades")
public class Trade implements Serializable {
    public Trade() {
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="trade_type") private String tradeType;
    @Column(name="price") private Float price;
    @Column(name="size") private int size;
    @Column(name="stock") private String stock;
    @Column(name="date_executed") private String dateExecuted;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTradeType() {
        return tradeType;
    }
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getStock() {
        return stock;
    }
    public void setStock(String stock) {
        this.stock = stock;
    }
    public String getDateExecuted() {
        return dateExecuted;
    }
    public void setDateExecuted(String dateExecuted) {
        this.dateExecuted = dateExecuted;
    }
    @JoinColumn (name="strategy_id", referencedColumnName="id", nullable = false)
    @ManyToOne
    private Strategy strategy;
    public Strategy getStrategy() {
        return strategy;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}