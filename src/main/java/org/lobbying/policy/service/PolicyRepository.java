package org.lobbying.policy.service;

import org.lobbying.policy.domain.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

interface PolicyRepository extends MongoRepository<Policy, String> {

}
