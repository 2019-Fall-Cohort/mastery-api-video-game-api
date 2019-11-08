package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.apimastery.objects.System;

@Repository
public interface SystemRepository extends CrudRepository<System, Long> {

}
