package net.oxsource.spring.database.repository.app;

import net.oxsource.spring.database.model.app.AppProduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppProductionRepos extends JpaRepository<AppProduction, String> {
}
