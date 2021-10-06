package repo;

import com.example.test.Coder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoderRepo extends JpaRepository<Coder, Integer> {
}
