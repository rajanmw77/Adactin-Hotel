@SearchHotel
Feature: Verifying Adactin Hotel Search Hotels Details

  Scenario Outline: Verifying Adactin Hotel Search Hotels
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login success message "Hello rajanmw77!"
    And User should search holtels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName  | password | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | noOfAdults | noOfChild |
      | rajanmw77 | Rajan@17 | Sydney   | Hotel Creek | Standard |     2		 | 20/11/2022 | 25/11/2022 |     1		  |    1 			|

  Scenario Outline: Verifying Adactin Hotel Search Hotels With Mandatory Fields
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login success message "Hello rajanmw77!"
    And User should enter only mandatory fields "<location>","<noOfRooms>","<checkIn>","<checkOut>" and "<noOfAdults>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName  | password | location | noOfRooms | checkIn    | checkOut   | noOfAdults |
      | rajanmw77 | Rajan@17 | Sydney   |     2			| 20/11/2022 | 25/11/2022 |     1			 |

  Scenario Outline: Verifying Adactin Hotel Search Hotels With Invalid Date
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login success message "Hello rajanmw77!"
    And User should search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after enter Invalid date error message "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
    | userName  | password | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | noOfAdults | noOfChild |
    | rajanmw77 | Rajan@17 | Sydney   | Hotel Creek | Standard |     2		 | 20/11/2023 | 25/11/2022 |     1		  |    1 			|

  Scenario Outline: Verifying Adactin Hotel Search Hotels Without Enter Any Field
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login success message "Hello rajanmw77!"
    And User should search hotel without enter any field
    Then User should verify after Enter without enter any fields error message "Please Select a Location"

    Examples: 
      | userName  | password |
      | rajanmw77 | Rajan@17 |
