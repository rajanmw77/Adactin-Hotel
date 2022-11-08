@SelectHotel
Feature: Verifying Adactin Hotel Select Hotel

  Scenario Outline: Verifying Adactin Hotel By Select Hotel Name
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login success message "Hello rajanmw77!"
    And User should search holtels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should select the hotel name
    Then User should verify after selecting hotel success message "Book A Hotel"

    Examples: 
      | userName  | password | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | noOfAdults | noOfChild |
      | rajanmw77 | Rajan@17 | Sydney   | Hotel Creek | Standard |     2		 | 20/11/2022 | 25/11/2022 |     1      |     1     |

  Scenario Outline: Verifying Adactin Hotel Without Select Hotel 
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login success message "Hello rajanmw77!"
    And User should search holtels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should click continue without selecting the hotel
    Then User should verify after without selecting hotel error message "Please Select a Hotel"

    Examples: 
      | userName  | password | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | noOfAdults | noOfChild |
      | rajanmw77 | Rajan@17 | Sydney   | Hotel Creek | Standard |     2 		 | 20/11/2022 | 25/11/2022 |     1      |     1     |
