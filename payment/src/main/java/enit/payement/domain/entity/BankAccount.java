package enit.payement.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BankAccount {
    @Id
    private Long AccountId;
    private String AccountOwnerName;
    private String AccountPassword;
    private Long AccountCode;
    private Date AccountInitialDate;
    private Double AccountInitialBalance;

}
