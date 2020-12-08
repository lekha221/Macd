@CompleteTest
Feature: Perform all functions of the Application


@SuccessfulLogin
#Successful Login with correct credentials
Scenario: Successful Login into McDelivery
Given I will be on SignUp Page
When I enter mobile "8179225291" and enter password "msrihari123"
And I click on Login
Then I will be logged into my account

@UnsuccessfulLogin
#Unsuccessful Login with incorrect credentials
Scenario Outline:- Unsuccessful Login into McDelivery
Given I will be on SignUp Page
When I enter mobileno "<mobileno>" and enter password "<password>"
And I click on Login
Then Error message "Invalid username or password" should be displayed
Examples: -
| mobileno | password |
| 8179225291 | 12365478951vdvd |
| 8179225291 | csvdv562v6f2v6|

@Location1
#Successful Location Set
Scenario Outline: Successful Location Set
Given I will be navigated to location page
When I enter a location with service as servinglocation "<servinglocation>"
And I enter the address
Then The location is set and visible on the top of the page
Examples: -
| servinglocation |
| Kukatpally |
| Madhapur |
| Kondapur |

@Location2
#UnSuccessful location search for non servable locations
Scenario Outline:- Unsuccessful Location Set with valid location but no service
Given I will be navigated to location page
When I enter a location without service as "<nonservinglocation>"
Then Error Message says "We don't serve this location as of now" is displayed
Examples: -
| nonservinglocation |
| Markapur |
| Giddalur |
| Ongole |

@Location3
#Unsuccessful Location search with invalid location
Scenario Outline:- Unsuccessful Location Set with invalid location
Given I will be navigated to location page
When I entered invalid location as "<invalidlocation>"
Then Error Message shown as "No results found, please enter nearby landmark & drop the pin on map"
Examples: -
| invalidlocation |
| fbfbfbdfbxbfdds |
| Gkjnjknljdncasjn |
| dfeiofonfvovvf |

@Item1
#Successful item search
Scenario Outline:- Search Valid item
Given I have selected the delivery location
When I search for validitem "<validitem>" in the search box
Then I get the relevant items below 
Examples: -
| validitem |
| pizza |
| chicken |
| burger |

@Item2
#Unsuccessful item search
Scenario Outline:- Search invalid item
Given I have selected the delivery location
When I search for invaliditem "<invaliditem>" in the search box
Then Error message "No results found. Check your spelling or try something different" is shown
Examples: -
| invaliditem |
| kmkmkmiik |
| dkjcbdh |
| vidubcnkn |

@AddCustom
#Adding a customization
Scenario: Add a customization
Given I have clicked on Add button of a product
When I have selected coke and clicked on Add to cart button
Then The custmoization should be added and product is added to cart

@RemoveCustom
#Removing a customization
Scenario: Remove a customization
Given I have added a customization
When I click on remove button of respective customization and click on Add to cart button
Then The customization should be deleted and product is added to cart


















