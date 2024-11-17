package enset.bankAccount.repositories;

import enset.bankAccount.entitis.Account;
import enset.bankAccount.entitis.Customer;
import enset.bankAccount.enums.TypeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}