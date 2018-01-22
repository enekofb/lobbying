Feature: Add media source
  I want to add a media source into the system
  So the system could poll it
  In order to get evidences for policies

  Scenario: Can add a media source
    Given I want to add a media source with name "source1" and url "https://source1.com"
    When I add the media source
    Then the media source has been added

