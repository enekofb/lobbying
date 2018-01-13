package org.lobbying.citizen.repository;

import org.lobbying.citizen.domain.Citizen;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by eneko on 13/01/18.
 */
public interface CitizenRepository extends MongoRepository<Citizen, String> {
}
