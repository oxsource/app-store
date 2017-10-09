package net.oxsource.spring.database.repository.user;

import net.oxsource.spring.database.model.user.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdminRepos extends JpaRepository<UserAdmin, String> {

    UserAdmin queryFirstByAccountEquals(String account);
}
