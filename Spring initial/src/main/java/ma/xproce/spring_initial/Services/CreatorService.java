package ma.xproce.spring_initial.Services;

import ma.xproce.spring_initial.Dao.Entity.Creator;
import ma.xproce.spring_initial.Dao.Repo.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreatorService implements CreatorManager {

    @Autowired
    CreatorRepository creatorRepository;
    @Override
    public Creator getCreatorByEmail(String email) {
        if(creatorRepository.findByEmail(email).isPresent())
            return creatorRepository.findByEmail(email).get();
        return null;
    }

    @Override
    public Creator getCreator(long id) {
        if(creatorRepository.findById(id).isPresent())
            return creatorRepository.findById(id).get();
        return null;
    }

    @Override
    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }

    @Override
    public Creator saveCreator(Creator creator) {
        if(creatorRepository.findByEmail(creator.getEmail()).isPresent()) {
            System.out.println("already exists");
            return null;
        }
        return creatorRepository.save(creator);
    }
}

