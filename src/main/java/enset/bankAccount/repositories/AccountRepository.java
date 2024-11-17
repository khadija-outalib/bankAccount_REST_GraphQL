package enset.bankAccount.repositories;

import enset.bankAccount.entitis.Account;
import enset.bankAccount.enums.TypeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends JpaRepository<Account, String> {

    @RestResource(path = "bytype")
    List<Account> findByType(@Param("t") TypeAccount type);
}