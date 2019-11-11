package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.apimastery.entities.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

}
