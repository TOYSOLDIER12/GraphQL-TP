package ma.xproce.spring_initial.mappers;

import ma.xproce.spring_initial.Dao.Entity.Creator;
import ma.xproce.spring_initial.dtos.CreatorRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CreatorMapper {
    ModelMapper creatorMapper = new ModelMapper();
    public CreatorRequest CreatorToCreatorRequest(Creator creator) {
        return creatorMapper.map(creator, CreatorRequest.class);
    }
    public Creator CreatorRequestToCreator(CreatorRequest creatorRequest) {
        return creatorMapper.map(creatorRequest, Creator.class);
    }

}
