package ma.xproce.spring_initial;

import ma.xproce.spring_initial.Dao.Entity.Creator;
import ma.xproce.spring_initial.Dao.Entity.Video;
import ma.xproce.spring_initial.Dao.Repo.CreatorRepository;
import ma.xproce.spring_initial.Dao.Repo.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
public class DatabaseInitializer {

    @Bean
    @Transactional
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            // Add creators
            List<Creator> creators = List.of(
                    Creator.builder().name("Creator1").build(),
                    Creator.builder().name("Creator2").build(),
                    Creator.builder().name("Creator3").build()
            );
            creators.forEach(creatorRepository::save);

            // Add videos
            List<Video> videos = List.of(
                    Video.builder().title("Video1").creator(creators.get(0)).build(),
                    Video.builder().title("Video2").creator(creators.get(1)).build(),
                    Video.builder().title("Video3").creator(creators.get(2)).build()
            );
            videos.forEach(videoRepository::save);
        };
    }
}
