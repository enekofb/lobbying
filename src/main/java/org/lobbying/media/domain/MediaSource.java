package org.lobbying.media.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Builder
@Data
public class MediaSource {
    private String name;
    private String url;
    @Id
    private String id;

}
