package ma.xproce.spring_initial.Dao.Repo;

import ma.xproce.spring_initial.Dao.Entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
