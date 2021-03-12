package by.swaggersample.petstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int petId;
    private int quantity;

    @Temporal(TemporalType.DATE)
    private Date shipDate;

    @Enumerated(EnumType.STRING)
    private Status status;
    private boolean complete;

    public Order(int petId, int quantity, Date shipDate, Status status, boolean complete) {
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }
}
