Feature: Create a policy
  I want to create a policy into the system
  So citizens can interact with it

  Scenario: Can create a policy
    Given I want to create a policy with name "policy1" and description "policy1 description"
    When I create policy
    Then policy has been created

