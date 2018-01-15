Feature: Update policy
  I want to update a policy
  based on an evidence gathered
  So citizens can receive the update
  In order to interact with politicians in that context

  Background:
    Given a policy with name "policy1" and description "policy1 description"
    Given a policy with name "policy1" and description "policy1 description"


  Scenario: Can update a policy
    Given the system has gathered an update for the previous policy
    When I update the policy
    Then policy has been updated

