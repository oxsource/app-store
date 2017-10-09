package net.oxsource.spring.database.repository.app;

import net.oxsource.spring.database.model.app.AppPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppPictureRepos extends JpaRepository<AppPicture, String> {
}
