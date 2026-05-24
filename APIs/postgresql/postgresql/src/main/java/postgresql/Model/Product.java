package postgresql.Model;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "/products")
@DynamicInsert
public class Product {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private float price;
    @Column(name = "stock")
    private int stock;

    public int getId() {return id;}
    public String getName() {return name;}
    public float getPrice() {return price;}
    public int getStock() {return stock;}

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setPrice(float price) {this.price = price;}
    public void setStock(int stock) {this.stock = stock;}

    @Override
    public String toString(){
        return id + " :: " + name + " :: " + price + " :: " + stock;
    }
}