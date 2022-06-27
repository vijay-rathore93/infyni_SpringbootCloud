package org.application.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Table(name="orderInfo")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", initialValue = 1000, sequenceName = "order_seq_name")
    private Integer id;
    @NotNull
    @NotEmpty
    private String productName;
    @NotNull
    private Integer qty;
    private String orderId;

}
