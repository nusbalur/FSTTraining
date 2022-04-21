#1 Open http://elearningm1.upskills.in/index.php
#2. Click signUp
#3. You need to fill up the registration Form for all mandatory fields
#4. Submit the details
#5. Verify Message
#6. Click on Next
#7. Once on HomePage , click your Username
#8. Choose profile from Dropdown
#9. Click on Messages
#10. Click on Compose message
#11. Enter the details shown on the page
#12. Click on Send message

Feature: E-learning website
Scenario: To register in E-learning website

Given Launch E-learning website
When SignUp button is displayed
Then Click SignUp button
Then Fill the registration form for all mandatory fields
Then Click Register button
Then Verify "Your personal settings have been registered."
Then Click Next
Then on HomePage , click Username
Then Choose profile from Dropdown and scroll down
Then Click on Messages icon
Then Click on Compose message
Then Enter the details shown on the page
Then Click on Send message