# Welcome to Drone Dispatch Java App

This Application does not have any UI but can be accessed using POSTMAN

The Application uses H2 database and can package can be imported into any IDE with support for Spring Boot and Run.

## End Points
There are several end points to this but the essential ones are
1. GET All Drones "localhost:8080/drones/" this end point returns the drones and all their payload (medicine)
<img src="https://github.com/BarkaBoss/Drone-Delivery/blob/main/image_ui/get_all_drones.png" width="400" alt="Photo of Getting All Drones"/>

2. GET Drone By ID "localhost:8080/drones/2" 
This end point returns a single drone and it;s payload (medicine)
<img src="https://github.com/BarkaBoss/Drone-Delivery/blob/main/image_ui/get_a_drone.png" width="400" alt="Photo of Getting A Single Drone"/>

3. GET Ready For Dispatch Drone "localhost:8080/drones/ready" 
This end point returns the Drones in IDLE state with battery over 25% (This should be the drones ready to fly)
<img src="https://github.com/BarkaBoss/Drone-Delivery/blob/main/image_ui/get_all_dispatch_drones.png" width="400" alt="Photo of Getting All Drones Ready for Dispatch"/>

4. POST Medicine to drone "localhost:8080/drones/2/medicine/3"
This end point adds a medicine to a drone as long as the new medicine does not exceed the maximum weight
<img src="ihttps://github.com/BarkaBoss/Drone-Delivery/blob/main/image_ui/add_meds_to_drone.png" width="400" alt="Photo of Getting All Drones Ready for Dispatch"/>

5. POST Create Drone "localhost:8080/drones/"
Adds new Drone to the Database
<img src="https://github.com/BarkaBoss/Drone-Delivery/blob/main/image_ui/add_drones.png" width="400" alt="Photo of Getting All Drones Ready for Dispatch"/>

6. POST Create Medicine "localhost:8080/medicine/"
Add new Medicine to DB
<img src="https://github.com/BarkaBoss/Drone-Delivery/blob/main/image_ui/add_drones.png" width="400" alt="Add Medicine to DB"/>

POSTMAN file => *DispatchREST_API.postman_collection.json*

# Summary
This was fun!