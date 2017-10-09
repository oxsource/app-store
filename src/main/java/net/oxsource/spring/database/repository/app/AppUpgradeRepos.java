package net.oxsource.spring.database.repository.app;

import net.oxsource.spring.database.model.app.AppUpgrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUpgradeRepos extends JpaRepository<AppUpgrade, String> {
}
