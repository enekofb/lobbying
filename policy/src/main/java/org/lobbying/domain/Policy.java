package org.lobbying.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
/**
 * Created by eneko on 10/01/18.
 */
@Data
public class Policy {

    @Id
    private String id;
    private String name;
    private String description;

}
