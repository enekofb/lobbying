Feature: Track a policy
  As a citizen interested in a given policy
  In order to engage with the policy
  I want to track the policy

  Background:
    Given a policy with name "policy1" and description "policy1 description"
    And a citizen with name "citizen1" and email "citizen1@gmai.com"

  Scenario: Can track a policy
    Given the citizen is interested on the policy
    When citizen tracks the policy
    Then the policy has been tracked

