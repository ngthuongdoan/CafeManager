package cafemanager;

class Item {

    private String idItem;
    private String expressItem;
    private String itemName;
    private String danhMuc;
    private int quantity;
    private String price;

    public Item(String idItem, String itemName,String expressItem , String danhMuc, String price) {
        this.idItem = idItem;
        this.expressItem = expressItem;
        this.itemName = itemName;
        this.danhMuc = danhMuc;
        this.price = price;
    }

    
    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getExpressItem() {
        return expressItem;
    }

    public void setExpressItem(String expressItem) {
        this.expressItem = expressItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
