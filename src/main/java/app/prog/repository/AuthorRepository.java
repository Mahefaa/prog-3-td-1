package app.prog.repository;

import app.prog.model.AuthorEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
  Optional<AuthorEntity> findByName(String name);
}
