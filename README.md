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
