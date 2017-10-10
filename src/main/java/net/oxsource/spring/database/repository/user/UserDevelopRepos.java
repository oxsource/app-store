package net.oxsource.spring.database.repository.user;

import net.oxsource.spring.database.model.user.UserDevelop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDevelopRepos extends JpaRepository<UserDevelop, String> {

    UserDevelop findFirstByUserKeyEquals(String key);

    UserDevelop findFirstByPhoneEquals(String phone);

    UserDevelop findFirstByEmailEquals(String email);

    List<UserDevelop> findAllByUserNameEqualsAndIdentifyEquals(String name, String identify);

    @Override
    UserDevelop saveAndFlush(UserDevelop s);
}