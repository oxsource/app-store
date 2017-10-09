package net.oxsource.spring.database.repository.user;

import net.oxsource.spring.database.model.user.UserDevelop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDevelopRepos extends JpaRepository<UserDevelop, String> {
}
