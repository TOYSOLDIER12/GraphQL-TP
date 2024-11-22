package ma.xproce.spring_initial.Dao.Repo;

import ma.xproce.spring_initial.Dao.Entity.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreatorRepository extends JpaRepository<Creator, Long> {
    public Optional<Creator> findByEmail(String name);
}
