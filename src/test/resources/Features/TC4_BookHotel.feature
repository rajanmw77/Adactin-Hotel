@BookHotel
Feature: Verifying Adactin Hotel Booking Conformation

  Scenario Outline: Verifying Adactin Hotel By Booking Hotel
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login success message "Hello rajanmw77!"
    And User should search holtels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should select the hotel name
    Then User should verify after selecting hotel success message "Book A Hotel"
    And User should book a hotel "<firstName>","<lastName>" and "<address>"
      | ccNo             | ccType | expMonth | expYear | CVV |
      | 6818144641684110 | AMEX   | April    |    2022 | 123 |
      | 6516841684468460 | MAST   | May      |    2022 | 124 |
      | 5678965325795660 | VISA   | December |    2022 | 508 |
      | 8945194341945460 | MAST   | July     |    2022 | 126 |
      | 3418481687616540 | AMEX   | November |    2022 | 127 |
    Then User should verify after book a hotel success message "Booking Confirmation"

    Examples: 
      | userName  | password | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | noOfAdults | noOfChild | firstName  | lastName       | address  |
      | rajanmw77 | Rajan@17 | Sydney   | Hotel Creek | Standard |         2 | 20/11/2022 | 25/11/2022 |          1 |         1 | Raja Rajan | Sathiyamoorthy | Dindugul |

  Scenario Outline: Verifying Adactin Hotel By Booking Hotel Without Entering Any Fields
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login success message "Hello rajanmw77!"
    And User should search holtels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should select the hotel name
    Then User should verify after selecting hotel success message "Book A Hotel"
    And User should book a hotel without entering any fields
    Then User should verify after book now button error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName  | password | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | noOfAdults | noOfChild |
      | rajanmw77 | Rajan@17 | Sydney   | Hotel Creek | Standard |         2 | 20/11/2022 | 25/11/2022 |          1 |         1 |
