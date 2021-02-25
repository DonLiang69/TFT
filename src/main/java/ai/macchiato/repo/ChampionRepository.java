package ai.macchiato.repo;

import ai.macchiato.model.Champion;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChampionRepository extends CrudRepository<Champion, Long>{

}
