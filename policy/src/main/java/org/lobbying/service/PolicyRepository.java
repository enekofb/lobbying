package org.lobbying.service;

import org.lobbying.domain.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "policies", path = "policies")
interface PolicyRepository extends MongoRepository<Policy, Long> {

    List<Policy> findById(@Param("id") Long id);


}
