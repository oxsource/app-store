package net.oxsource.spring.database.repository.app;

import net.oxsource.spring.database.model.app.AppGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppGroupRepos extends JpaRepository<AppGroup, String> {
}
