package org.lobbying.policy.service;

import org.lobbying.policy.domain.Policy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

interface PolicyRepository extends CrudRepository<Policy, String> {

}
