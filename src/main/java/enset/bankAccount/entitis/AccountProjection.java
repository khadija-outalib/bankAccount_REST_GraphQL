package enset.bankAccount.entitis;

import enset.bankAccount.enums.TypeAccount;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.PathVariable;

@Projection(types = Account.class,name = "p1")
public interface AccountProjection {
    public String getId();
    public TypeAccount getType();
}
