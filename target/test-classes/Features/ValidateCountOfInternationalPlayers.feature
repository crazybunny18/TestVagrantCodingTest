Feature: feature to validate count of International Players in Team RCB

  Scenario: Check the count of International Players in Team RCB
    Given Team RCB Player List
    When The name and location of RCB as follows
    And get the count of international players for RCB
    Then validate for the count of international players is four
    
  Scenario: Check the count of Wicket Keepers in Team RCB
    Given Team RCB Player List
    When The role of RCB as follows
    And get the count of Weeket Keepers for RCB
    Then validate for the count of Wicket Keepers is not less than one
