package com.silvercode.schoolmanagerapp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter
@AllArgsConstructor
@Entity
public class IdCard {

    @Id
    @SequenceGenerator(name = "card_id", sequenceName = "card_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_id")
    private Long cardId;
    private String cardNumber;

    @OneToOne(mappedBy = "idCard")
    private Student student;

    public IdCard() {
        this.cardNumber = UUID.randomUUID().toString();
    }

    public Long getCardId() {
        return cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Student getStudent() {
        return null;
    }
}
