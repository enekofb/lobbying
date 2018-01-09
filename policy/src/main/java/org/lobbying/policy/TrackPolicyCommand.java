package org.lobbying.policy;

import lombok.Builder;
import lombok.Data;

/**
 * Created by eneko on 09/01/18.
 */
@Data
@Builder
public class TrackPolicyCommand {

    private String policyId;
    private String citizenId;

    public TrackPolicyCommandResult execute(){
        return TrackPolicyCommandResult.builder().build();
    }

}
