Feature: Sign up an account in Facebook
  Background: Load Facebook Page
    Given the Facebook home page
    When the user click on Create new account button
    Then The signup form is displayed

    Scenario Outline: Create a new Facebook account with mobile number
      Given the user fills the following fields
        | firstName   | lastName   | mobileNumber   | password   |
        | <firstName> | <lastName> | <mobileNumber> | <password> |
      And the user picks a birthday date
      And the user select a gender <gender>
      When the user click on Sign Up button
      Then the system creates a new account
      And the system redirects to feed page.
      Examples:
        | firstName | lastName | mobileNumber | password    | gender |
        | Juan      | Lopez    | 3001234567   | password123 | Male   |
        | Andrea    | Lopez    | 3001234567   | password123 | Female |

    Scenario Outline: Create a new Facebook account with email
      Given the user fills the following fields
        | firstName   | lastName   | email   | confirmation email | password   |
        | <firstName> | <lastName> | <email> | <email>            | <password> |
      And the user picks a birthday date
      And the user select a gender <gender>
      When the user click on Sign Up button
      Then the system creates a new account
      And the system redirects to feed page.
      Examples:
        | firstName | lastName | email                  | password    | gender |
        | Juan      | Lopez    | juan.lopez@email.com   | password123 | Male   |
        | Andrea    | Lopez    | andrea.lopez@email.com | password123 | Female |

    Scenario Outline: Create a new Facebook account with custom gender
      Given the user fills the following fields
        | firstName   | lastName   | mobileNumber   | password   |
        | <firstName> | <lastName> | <mobileNumber> | <password> |
      And picks a birthday date
      And select "Custom" gender
      And select a pronoun from the list <pronoun>
      When the user click on Sign Up button
      Then the system creates a new account
      And the system redirects to feed page.
      Examples:
        | firstName | lastName | mobileNumber | password    | pronoun                           |
        | Clare     | Thomson  | 3001234567   | password123 | She:"Wish her a happy birthday!"  |
        | Jhon      | Thomson  | 3001234567   | password123 | He:"Wish her a happy birthday!"   |
        | Marie     | Thomson  | 3001234567   | password123 | They:"Wish her a happy birthday!" |

    Scenario: Create a new Facebook account without First Name
      Given the user fills the signup form fields
      And doesn't fill the first name
      When the user click on Sign Up button
      Then the system should shows the message "What's your name?"
      And highlight the field "First name"

    Scenario: Create a new Facebook account without Last Name
      Given the user fills the signup form fields
      And doesn't fill the last name
      When the user click on Sign Up button
      Then the system should shows the message "What's your name?"
      And highlight the field "Last name"

    Scenario: Create a new Facebook account without Mobile number or email
      Given the user fills the signup form fields
      And doesn't fill the mobile number or email
      When the user click on Sign Up button
      Then the system should shows the message "You'll use this when you log in and if you ever need to reset your password"
      And highlight the field "Mobile number or email"

    Scenario: Create a new Facebook account without Password
      Given the user fills the signup form fields
      And doesn't fill the password
      When the user click on Sign Up button
      Then the system should shows the message "Enter a combination of at least six numbers, letters and punctuation marks (like ! and &)"
      And highlight the field "Password"

    Scenario: Create a new Facebook account with a short password
      Given the user fills the signup form fields
      And use a short password
      When the user click on Sign Up button
      Then the system should shows the message "Your password must be at least 6 characters long. Please try another."

    Scenario: Create a new Facebook account with invalid format password
      Given the user fills the signup form fields
      And use a short password
      When the user click on Sign Up button
      Then the system should shows the message "Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess."

    Scenario: Create a new Facebook account with invalid mobile number
      Given the user fills the signup form fields
      And use an invalid mobile number
      When the user click on Sign Up button
      Then the system should shows the message "Please enter a valid mobile number or email address."

    Scenario: Create a new Facebook account with invalid email
      Given the user fills the signup form fields
      And use an invalid email
      When the user click on Sign Up button
      Then the system should shows the message "Please enter a valid mobile number or email address."

    Scenario: Create a new Facebook account with invalid confirmation email
      Given the user fills the signup form fields
      And write a different confirmation email
      When the user click on Sign Up button
      Then the system should shows the message "Your emails do not match. Please try again."

    Scenario: Create a new Facebook account without select a Gender
      Given the user fills the signup form fields
      And doesn't select a gender
      When the user click on Sign Up button
      Then the system should shows the message "Please choose a gender. You can change who can see this later."

    Scenario: Create a new Facebook account without select a pronoun
      Given the user fills the signup form fields
      And select "Custom" gender
      And doesn't select a pronoun
      When the user click on Sign Up button
      Then the system should shows the message "Please select your pronoun."

    Scenario: Create a new Facebook account with the current day.
      Given the user fills the signup form fields
      And select the current day in the birthday field
      When the user click on Sign Up button
      Then the system should shows the message "It looks like you entered the wrong info. Please be sure to use your real birthday."

    Scenario: Create a new Facebook account with a younger
      Given the user fills the signup form fields
      And select a birthday date of a younger
      When the user click on Sign Up button
      Then the system should refresh the page
      And doesn't create the account.

    Scenario: Create a new Facebook account with the maximum year allowed
      Given the user fills the signup form fields
      And select the maximum year available
      When the user click on Sign Up button
      Then the system creates a new account
      And the system redirects to feed page