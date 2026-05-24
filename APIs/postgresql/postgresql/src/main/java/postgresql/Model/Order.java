package postgresql.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "/orders")
@DynamicInsert
public class Order{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private LocalDateTime date = LocalDateTime.now();
    
    public int getId() {return id;}
    public LocalDateTime getDate() {return date;}

    public void setId(int id) {this.id = id;}
    public void setDate() {this.date = LocalDateTime.now();}

    @Override
    public String toString(){
        return id + " :: " + date;
    }
}