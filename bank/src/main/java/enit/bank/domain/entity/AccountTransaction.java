package enit.bank.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
@ToString
public class AccountTransaction {
    @Id
    private Integer TDbId;
    private Long TransactionAccountCode;
    private Date TransactionDate;
    private Long TransactionAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountCode")
    private BankAccount account;
}
