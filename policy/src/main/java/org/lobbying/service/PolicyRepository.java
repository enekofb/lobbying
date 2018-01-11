package org.lobbying.service;

import org.lobbying.domain.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

interface PolicyRepository extends MongoRepository<Policy, String> {
}
