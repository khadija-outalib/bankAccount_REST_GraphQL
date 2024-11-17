package enset.bankAccount.mappers;

import enset.bankAccount.dto.AccountResponnseDTO;
import enset.bankAccount.entitis.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountResponnseDTO fromAccount(Account account) {
        AccountResponnseDTO responnseDTO = new AccountResponnseDTO();
        BeanUtils.copyProperties(account, responnseDTO);
        return responnseDTO;
    }
}
