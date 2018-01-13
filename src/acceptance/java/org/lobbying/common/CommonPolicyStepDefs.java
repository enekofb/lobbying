package org.lobbying.common;

import org.lobbying.PolicyApplication;
import org.lobbying.policy.domain.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by eneko on 13/01/18.
 */
@SpringBootTest(classes = {PolicyApplication.class },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CommonPolicyStepDefs {

    // POLICY URLS
    public static final String CREATE_POLICY_URL = "http://localhost:{port}/policies";
    public static final String UPDATE_POLICY_URL = "http://localhost:{port}/policies/{id}/updates";
    public static final String GET_POLICY_BY_ID_URL = "http://localhost:{port}/policies/{id}";

    // CITIZEN URLS
    public static final String CREATE_CITIZEN_URL = "http://localhost:{port}/citizens";
    public static final String GET_CITIZEN_BY_ID_URL = "http://localhost:{port}/citizens/{id}";

    @Autowired
    protected TestRestTemplate policyClient;

    @LocalServerPort
    protected int port;

    private static PolicyWorld policyWorld;

    public PolicyWorld getPolicyWorld() {
        if(policyWorld == null){
            policyWorld = PolicyWorld.builder()
                    .policyClient(policyClient)
                    .port(port)
                    .build();
        }
        return policyWorld;
    }
}
