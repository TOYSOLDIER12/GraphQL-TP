package ma.xproce.spring_initial.Services;

import ma.xproce.spring_initial.Dao.Entity.Video;

import java.util.List;
import java.util.Optional;

public interface VideoManager {
    public List<Video> getAllVideo();
    public Video getVideoById(long id);
    public void addVideo(Video video);
}
