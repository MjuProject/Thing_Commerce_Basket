package com.thing.basket.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Basket")
public class Basket {

    @Id
    @Column(name = "basket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;
    @Column(name = "client_index")
    private Integer clientIndex;
    @Column(name = "item_id")
    private Integer itemId;

}
