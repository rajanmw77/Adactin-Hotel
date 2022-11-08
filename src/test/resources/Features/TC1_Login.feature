@Login
Feature: Verifying Adactin Hotel Login Details
	
  Scenario Outline: Verifying Adactin Hotel Login Valid
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login success message "Hello rajanmw77!"

    Examples: 
      | userName  | password |
      | rajanmw77 | Rajan@17 |

  Scenario Outline: Verifying Adactin Hotel Login Valid Using Enter
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>" with Enter Key
    Then User should verify after Login success message "Hello rajanmw77!"
    

    Examples: 
      | userName  | password |
      | rajanmw77 | Rajan@17 |

  Scenario Outline: Verifying Adactin Hotel Login Invalid Credential
    Given User is on the Adactin Page
    When User should perform Login "<userName>","<password>"
    Then User should verify after login with Invalid Credential error message "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName | password |
      | rajanmw  | Rajan@17 |