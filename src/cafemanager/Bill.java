package cafemanager;

import java.util.ArrayList;
import java.util.Date;

public class Bill {

    private String idBill;
    private Date date;
    private Customer cus;
//    private ArrayList<Item> items = new ArrayList<Item>();
    private float total;
    
    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public Item getItems() {
//        return items;
//    }

//    public void setItems(Item items) {
//        this.items.
//    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }
    
    
}
