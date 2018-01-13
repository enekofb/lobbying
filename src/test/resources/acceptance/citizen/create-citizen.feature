Feature: Create a citizen
  I want to create a citizen into the system
  So they are core a core domain entity

  Scenario: Can create a citizen
    Given I want to create a citizen with email "tom@gmail.com"  and name "tom"
    When I create the citizen
    Then citizen has been created

