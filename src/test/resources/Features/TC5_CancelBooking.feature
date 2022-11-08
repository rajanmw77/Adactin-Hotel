@CancelHotel
Feature: Verifying Adactin Hotel Cancel Booking Details

  Scenario Outline: Verifying Adactin Hotel Cancel Booking
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
    And User should cancel order id
    Then User should verify after cancel order id success message "The booking has been cancelled."

    Examples: 
      | userName  | password | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | noOfAdults | noOfChild | firstName  | lastName       | address  |
      | rajanmw77 | Rajan@17 | Sydney   | Hotel Creek | Standard |         2 | 20/11/2022 | 25/11/2022 |          1 |         1 | Raja Rajan | Sathiyamoorthy | Dindugul |

  Scenario Outline: Verifying Adactin Hotel Cancel Booking By Existing OrderID
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login success message "Hello rajanmw77!"
    And User should cancel the existing order id "<orderID>"
    Then User should verify after cancel id success message "The booking has been cancelled."

    Examples: 
      | userName  | password | orderID    |
      | rajanmw77 | Rajan@17 | SHNF12993A |
