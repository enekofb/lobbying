package org.lobbying.common;

import org.lobbying.PolicyApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by eneko on 13/01/18.
 */
@SpringBootTest(classes = {PolicyApplication.class },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CommonPolicyStepDefs {
}
