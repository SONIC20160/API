package postgresql.Model;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "/order_products")
@DynamicInsert
public class OrderProduct{
    
    @Id
    @Column(name = "order_id")
    private int orderID;
    @Column(name = "product_id")
    private int productID;
    @Column(name = "quantity")
    private int quantity;
    
    public int getOrderID() {return orderID;}
    public int getProductID() {return productID;}
    public int getQuantity() {return quantity;}

    public void setOrderID(int orderID) {this.orderID = orderID;}
    public void setProductID(int productID) {this.productID = productID;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    @Override
    public String toString(){
        return orderID + " :: " + productID + " :: " + quantity;
    }
}

/*
crear order (id, fecha)
crear orderProducts (order.getID, product.getID)
for product in products[]
*/