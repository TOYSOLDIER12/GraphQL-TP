package ma.xproce.spring_initial.Services;

import ma.xproce.spring_initial.Dao.Entity.Creator;

import java.util.List;

public interface CreatorManager {
    public Creator getCreatorByEmail(String email);

    Creator getCreator(long id);

    public List<Creator> getAllCreators();
    public Creator saveCreator(Creator creator);
}
