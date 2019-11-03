package cafemanager;

import java.util.ArrayList;
import java.util.Date;

public class Bill {

    private String idBill;
    private String idTable;
    private Date date;
    private Customer cus;
    private ArrayList<Item> items = new ArrayList<Item>();
    private float total;

    public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
    }

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

    public void setMon(String ten, int soluong) {
        Item temp = new Item();
        temp.setItemName(ten);
        temp.setQuantity(soluong);
        this.items.add(temp);
    }

    public ArrayList getMon() {
        return this.items;
    }

    @Override
    public String toString() {
        String result = new String();
        result += "Mã HD: " + this.getIdBill();
        result += "\nBàn: " + this.getIdTable();
        result += "\n\n-----------------------------------\n";
        for (int i = 0; i < this.items.size(); i++) {
            result += this.items.get(i).getQuantity() + "\t"
                    + this.items.get(i).getItemName() + "\n";
        }
        return result;
    }

}
