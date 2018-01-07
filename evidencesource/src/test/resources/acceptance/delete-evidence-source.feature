Feature: Can update notes
  As a busy person
  I want to update an existing note
  So I can keep track of all events that happens in that context

  Background:
    Given I have a note with title "walk dog" text "I have to walk to Pingo at 6 am" and password "05021975"
    When I create the note

  Scenario: Can update empty note
    Given an existing note with title "walk dog"
    When I update the note with "today 1st of April Pingo has made five holes in about 200 meters walks"
    Then the note has been updated
    And I havent misses any detail of my pets life