package org.lobbying.policy.service;

import org.lobbying.policy.domain.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;

interface PolicyRepository extends MongoRepository<Policy, String> {
}
