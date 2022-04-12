package com.silvercode.schoolmanagerapp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class IdCard {

    @Id
    private Long cardId;
    private String cardNumber;

    @OneToOne(mappedBy = "idCard")
    private Student student;

    public IdCard() {
        this.cardNumber = UUID.randomUUID().toString();
    }
}
