package net.oxsource.spring.database.repository.app;

import net.oxsource.spring.database.model.app.AppArtifact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppArtifactRepos extends JpaRepository<AppArtifact, String> {
}
