package ma.xproce.spring_initial.mappers;


import ma.xproce.spring_initial.Dao.Entity.Video;

import ma.xproce.spring_initial.dtos.VideoRequest;
import org.modelmapper.ModelMapper;

public class VideoMapper {

    ModelMapper videoMapper = new ModelMapper();
    public VideoRequest VideoToVideoRequest(Video video) {
        return videoMapper.map(video, VideoRequest.class);
    }
    public Video VideoRequestToVideo(VideoRequest videoRequest) {
        return videoMapper.map(videoRequest, Video.class);
    }
}
