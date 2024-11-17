package enset.bankAccount.dto;

import enset.bankAccount.enums.TypeAccount;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class AccountRequestDTO {

    private Double balance;
    private String currency;
    private TypeAccount type;
}
