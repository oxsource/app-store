package net.oxsource.spring.database.repository.user;

import net.oxsource.spring.database.model.user.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAdminRepos extends JpaRepository<UserAdmin, String> {

    List<UserAdmin> findAllByAccountEqualsAndIdentifyEquals(String account, String identify);
}
