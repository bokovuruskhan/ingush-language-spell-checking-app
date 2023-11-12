package open.bokovuruskhan.ingushlanguagespellcheckingapp.database.repository;

import open.bokovuruskhan.ingushlanguagespellcheckingapp.database.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
}
