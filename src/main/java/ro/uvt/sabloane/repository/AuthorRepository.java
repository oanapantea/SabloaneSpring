package ro.uvt.sabloane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.sabloane.model.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
