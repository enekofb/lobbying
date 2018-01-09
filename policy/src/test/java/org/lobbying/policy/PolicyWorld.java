package org.lobbying.policy;

/**
 * Created by eneko on 09/01/18.
 */
public class PolicyWorld {

    private static final PolicyWorld INSTANCE = new PolicyWorld();
    private String citizenId;
    private String policyId;

    public static PolicyWorld getInstance(){
        return INSTANCE;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public TrackPolicyCommandResult trackPolicy(String citizenId, String policyId) {
        TrackPolicyCommand trackPolicyCommand = TrackPolicyCommand.builder().citizenId(citizenId).policyId(policyId).build();
        return trackPolicyCommand.execute();
    }
}
