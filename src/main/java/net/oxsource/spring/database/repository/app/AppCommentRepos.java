package net.oxsource.spring.database.repository.app;

import net.oxsource.spring.database.model.app.AppComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppCommentRepos extends JpaRepository<AppComment, String> {
}