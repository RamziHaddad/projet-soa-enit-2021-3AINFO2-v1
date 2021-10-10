package enit.bank.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Accounts_transaction")
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
@ToString
public class AccountTransaction {
    @Id
    private Integer Tid;
    private Date date;
    @ManyToOne
    @JoinColumn(name="bank_account", nullable=false)
    private Account account;
}
