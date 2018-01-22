package org.lobbying.media.repository;

import org.lobbying.media.domain.MediaSource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MediaSourceRepository extends MongoRepository<MediaSource, String> {

}
