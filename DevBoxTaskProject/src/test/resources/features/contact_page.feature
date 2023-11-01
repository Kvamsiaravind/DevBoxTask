Feature: Automating contact page to check the functionality

  Background:
  Given : Open the base URL "http://csadms.com/GDCWeb/contact"

  Scenario: Verifying the given base url
    When : Click on the Contacts page
    Then : Validating the page title and status code 200

  Scenario: Verifying the navigation to Home page
    When : Click on the Home section
    Then : Validating the home page title and status code 200

  Scenario: Verifying the navigation to About page
    When : Click on the About section
    Then : Validating the About page And title status code 200

  Scenario: Testing the form functionality by giving valid data
    When fill the contact form with valid data
        | Name          | kuruva vamsi            |
        | Email         | kvamsiaravind@gmail.com |
        | MobileNumber  | 9390309164              |
        | YourSubject   | DummySubject            |
        |Message        | Message Body            |

    And Click on submit message button
    Then see a success message

  Scenario: Testing the form functionality by giving invalid data
    When : fill the contact form with invalid data
      | Name  |@@Vamsi  |
      | Email  | kvamsi.gmail.com  |
      | Mobile | jsjssla |
      | YourSubject   | me  |
      | Message       | messageBody |
      | Captcha       | tW320       |
    And Click on submit message button
    Then validating the please enter invalid data in different fields

  Scenario: Testing the Subscribe button functionality by giving valid email
    When : fill the email field by giving "kvamsiaravind@gmail.com"
    Then : Validating the successfully subscribed message

  Scenario: Testing the Subscribe button functionality by giving invalid email
    When : fill the email field by giving "kvamsi.gmail.com"
    Then : Validating the please enter the invalid email text