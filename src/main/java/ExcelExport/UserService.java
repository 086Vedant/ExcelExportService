package ExcelExport;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;



@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepo;

    @Transactional
    public List<User> getAllUsers() {
        return userRepo.listAll();
    }    
}
