package enset.bankAccount.entitis;

import enset.bankAccount.enums.TypeAccount;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    private String id;
    private Date createAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @ManyToOne
    private Customer customer;


}
