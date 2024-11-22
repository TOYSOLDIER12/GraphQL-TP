package ma.xproce.spring_initial.Services;

import ma.xproce.spring_initial.Dao.Entity.Video;
import ma.xproce.spring_initial.Dao.Repo.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class VideoService implements VideoManager {
    @Autowired
    VideoRepository videoRepository;

    @Override
    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }

    @Override
    public Video getVideoById(long id) {
        return videoRepository.findById(id).get();
    }

    @Override
    public void addVideo(Video video) {

    }
}
