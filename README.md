Room Occupancy Manager

It is a spring boot application providing a possibility of rooms occupancy calculation according to the description.

POST endpoint: HOST/occupancy/calculate

an input JSON example (POST body):
{
    "freePremiumRooms": 3,
    "freeEconomyRooms": 4,
    "guestsRoomPrices" : [23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209]
}

an output JSON example: 

{
    "usedPremiumRooms": 3,
    "usedEconomyRooms": 4,
    "premiumRoomsPrice": 738,
    "economyRoomsPrice": 189.99
}

Test: OccupancyServiceTest

--------------------
COMMENTS:

TO BE DONE:
- more tests (especially some edge cases e.g. with null, empty, 0) with different input
- an extraction of the first "if" condition to a separate method (in calculateOccupancy() ) or work on removal the condition - so implementing a smarter logic without any if
- splitting calculateOccupancy() into more methods. I thought about it a bit but did not find any better and obvious solution.
- removal of com.fasterxml.jackson.core dependency - it is not needed.

