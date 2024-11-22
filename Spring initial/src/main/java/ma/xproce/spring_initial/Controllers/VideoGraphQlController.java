package ma.xproce.spring_initial.Controllers;

import ma.xproce.spring_initial.Dao.Entity.Creator;
import ma.xproce.spring_initial.Dao.Entity.Video;
import ma.xproce.spring_initial.Dao.Repo.CreatorRepository;
import ma.xproce.spring_initial.Dao.Repo.VideoRepository;
import ma.xproce.spring_initial.Services.CreatorManager;
import ma.xproce.spring_initial.Services.CreatorService;
import ma.xproce.spring_initial.dtos.*;
import ma.xproce.spring_initial.mappers.CreatorMapper;
import ma.xproce.spring_initial.mappers.VideoMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private final CreatorMapper creatorMapper;
    private final VideoMapper videoMapper;
    private CreatorManager creatorManager;
    private VideoRepository videoRepository;
    VideoGraphQlController(CreatorService creatorService, VideoRepository videoRepository, CreatorMapper creatorMapper){
        this.creatorManager = creatorService;
        this.videoRepository = videoRepository;
        this.creatorMapper = creatorMapper;
        this.videoMapper = new VideoMapper();
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorManager.getCreator(id);

    }
    @MutationMapping
    public Creator saveCreator(@Argument("CreatorRequest") CreatorRequest creatorRequest){
        if (creatorRequest == null) {
            throw new IllegalArgumentException("CreatorRequest cannot be null");
        }
        Creator creator = creatorMapper.CreatorRequestToCreator(creatorRequest);
        return creatorManager.saveCreator(creator);
    }
    @MutationMapping
    public Video saveVideo(@Argument("VideoRequest") VideoRequest videoRequest){
        if (videoRequest == null) {
            throw new IllegalArgumentException("VideoRequest is null");
        }

        CreatorRequest creatorRequest = videoRequest.getCreator();
        Creator creator = creatorManager.getCreatorByEmail(creatorRequest.getEmail());
        if (creator == null){
            throw new IllegalArgumentException("Creator is null");
        }
        Video video = videoMapper.VideoRequestToVideo(videoRequest);
        video.setCreator(creator);
        return videoRepository.save(video);
    }
}

/*
* mutation MyMutation {
  saveVideo(
    VideoRequest: {creator: {name: "c1", email: "c1@gmail.com"}, description: "wow1", title: "video1", url: "haha1"}
  ) {
    title
  }
}
*
* */
