Feature: Functionality on Login page

  Scenario: User successfully Login

    Given user is on Login page
    When user input valid email
    When user input valid password
    When user click submit login
    Then user verify success login result

  Scenario: User failed Login

    Given user is on Login page
    When user input invalid email
    When user input invalid password
    When user click submit login
    Then user verify failed login result