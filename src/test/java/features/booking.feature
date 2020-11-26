Feature: Booking new filter options "Spa and wellness centre" and "Star rating"

  Scenario Outline: As a user I want to search Hotels in Booking with Spa and wellness centre - Sauna
    Given I am navigated to Booking
    When I provide <Destination> Hotel Booking Information
    Then I should be able to view list of Hotel Search result
    When I filter the result list by Sauna
    Then I should be able to see "Limerick Strand Hotel" in the list
    And I shouldn't see "George Limerick Hotel" in the list

    Examples:
      | Destination |
      | dataset1 |

  Scenario Outline: As a user I want to search Hotels in Booking with 5 Star
    Given I am navigated to Booking
    When I provide <Destination> Hotel Booking Information
    Then I should be able to view list of Hotel Search result
    When I select 5 star filter
    Then I must see the "The Savoy Hotel" in the list
    And I shouldn't see "George Limerick Hotel" in the list

    Examples:
      | Destination |
      | dataset1 |

  Scenario Outline: As a user I want to search Hotels in Booking with 5 Star and Sauna
    Given I am navigated to Booking
    When I provide <Destination> Hotel Booking Information
    Then I should be able to view list of Hotel Search result
    When I select both filters 5 star and Sauna
    Then I shouldn't see any of them "Limerick Strand Hotel" neither "The Savoy Hotel" in the list
    And I shouldn't see "George Limerick Hotel" in the list

    Examples:
      | Destination |
      | dataset1 |