Feature: Autocomplete results from Google
  Scenario: Autocomplete results from Google
    Given User navigates to Google
    When  User searches for "hello world"
    Then Following search results should be displayed
    | searchResults |
    | programming   |
    | learn to code |
