Feature: Track a policy
  As a citizen interested in a given policy
  In order to engage with the policy
  I want to track the policy

  Background:
    Given a policy with id "1234" and name "policy" exists
    And a citizen with id "4567" and name "citizen" exists

  Scenario: Can track a policy
    Given a citizen with id "4567"
    And interested in a policy with id "1234"
    When I track the policy
    Then the policy has been tracked

