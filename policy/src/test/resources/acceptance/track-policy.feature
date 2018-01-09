Feature: Track a policy
  As a citizen interested in a given policy
  In order to engage with the policy
  I want to track the policy

  Scenario: Can track a policy
    Given I am a citizen "eneko"
    And I am interested in a policy about "aeropuerto de san javier"
    When I track the policy
    Then the policy has been tracked

