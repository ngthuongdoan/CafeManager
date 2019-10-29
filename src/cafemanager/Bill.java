/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanager;

import java.util.Date;

/**
 *
 * @author BlackVernon
 */
class Bill {

    private String idBill;
    private int idEmployee;
    private int idTable;
    private int idCustomer;
    private Date createDate;
    private float total;
//    Danh sách món????????
//    private ArrayList<Item> ls;

    public Bill() {
        this.idBill = new String();
        this.idEmployee = 0;
        this.idTable = 0;
        this.idCustomer = 0;
        this.createDate = new Date();
        this.total = 0;
//        this.ls= new ArrayList<>();
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String result="ID Hoa Don: "+ this.idBill+"\nTotal: "+this.total;
        return result; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

