package org.lobbying.citizen.repository;

import org.lobbying.citizen.domain.Citizen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by eneko on 13/01/18.
 */
public interface CitizenRepository extends CrudRepository<Citizen, String> {
}
