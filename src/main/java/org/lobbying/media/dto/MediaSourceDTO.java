package org.lobbying.media.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MediaSourceDTO {
    private String name;
    private String url;
    private String id;
}
