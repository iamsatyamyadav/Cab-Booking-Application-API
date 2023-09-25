# <div align="center"> Cab-Booking-Application-API (CabWalla) </div>
 This application is a REST API for an Online Cab Booking Management System.Using this web service a customer can book a trip, an admin can assign a driver to a particular trip, and a driver can complete the trip. All these CRUD operations require validation on each step.

# <div align="center"> 💻 Tech Stack </div>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) 
![SpringBoot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) 
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) 
![Spring-security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white) 

### Modules
- Login Module
-	Admin Module
-	Customer Module
-	Driver Module
-	Trip Booking Module

### Functionalities
- Common Functionalities :- Login, Logout and registration to the system.
* Admin Functionalities :-
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete driver or customer from main database
    * Admin can access the details of different customers, drivers and trip bookings
    * Admin can assign a driver to a particular trip.
* Customer Functionalities :-
    * Registering themselves with application, and logging in to get the valid session token
    * Book a trip.
    * Access his trip history, profile updation, update trip details.
    * Rate a driver.    
* Driver Functionalities :-
    * Driver can login, update his profile.
    * Driver can update their cab details
    * Check trips assigned to him.
    * Can generate a bill.

##   ER_Diagram                                            
![Book Cab ER Diagram](https://user-images.githubusercontent.com/105484277/208635652-24755177-0a30-4601-9eb4-e934d45f2b8d.png)

### Installation & Run
- Before running the API server, you have to update the database configuration inside the application.properties file
- Update the port number, username and password as per your local database configuration
````
    server.port=8087

    spring.datasource.url=jdbc:mysql://localhost:3306/cabwayDB;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
    
````
## API Module Endpoints

### Admin Module

* POST /admins :- Register admin

* `PUT /admins :- Update admin details.

* PUT /admins/tripbooking/bill/{cid} :- Generate a bill for a trip.

* PUT /admin/updateTripBooking/{userId} :- Update trip status to completed or cancelled.

* GET /admins/viewCabByType/{carType} :- View cabs of particular type.

* GET /admins/tripbookings/datewise/{date} :- View all trips for a particular day.

* GET /admins/tripbookings/datewise/{cid}/{sdate}/{edate} :- Check all trips for a particular date range.

* GET /admins/driver/{driverId} :- Check a driver with driver id.

* GET /admins/customers :- Check all customers in the database.

* GET /admins/customers/tripbookings :- Check all trips.

* GET /admins/customer/{cid} :- Check a particular customer

* GET /admins/customer/tripbookings/{cid} :- Check all trips of a particular customer.

* GET /admins/countCabsOfType/{carType} :- Count cabs of a particular type.

* GET /admins/bestdrivers :- Check drivers with rating over 4.5.

* DELETE /admins/{aid} :- Delete an admin.

* DELETE /admins/deletetripBooking/{tbid}/{uid} :- Delete trip if status is completed or cancelled.

* DELETE /admins/deleteDriver/{driverId} :- Delete a driver from the system.


### Customer Module

* POST /customer :- Register a customer.

* PUT /updateCustomer :- Update customer details.

* POST /customers/tripBook/{cid} :- Book a trip.

* PUT /customer/updateTripBooking/{userId} :- Update trip booking details.

* PUT /customer/ratedriver :- Rate a driver.

* GET /validateCustomer :- Validate himself.

* GET /customers/{customerId} :- Get his details

* GET /customer/tripbookings/{cid} :- Get trips history.

* DELETE /deleteCustomer/{customerId} :- Delete his account.


### Driver Module

* POST /driver :- Register a driver.

* PUT /updateDriver :- Update his details.

* PUT /drivers/updateCab :- Update cab details.

* PUT /driver/updateTripBooking/{userId} :- Mark trip as completed or cancelled.

* PUT /driver/tripbooking/bill/{customerid} :- Generate bill.

* GET /driver/{driverId} :- Get his details.

* DELETE /deleteDriver/{driverId} :- Delete his account.

### Login Module

* `POST /login :- Login to the system, get uuid.

* DELETE /logout :- Logout of the system.

  ## API Root Endpoint

`https://localhost:8081/`

`http://localhost:8081/swagger-ui/index.html#/`




# Features & Controller
## Driver-Controller
![image](https://user-images.githubusercontent.com/103804433/221413489-1fd2861c-a5cb-4637-9a33-f4a390395e95.png)

## Customer-Controller

![image](https://user-images.githubusercontent.com/103804433/221413514-514deac0-959d-48f7-8153-7394b3bbe4dc.png)


## Admin-Controller
![image](https://user-images.githubusercontent.com/103804433/221413530-a8e99dc6-0e96-454b-931f-ee09b9ee4f89.png)

## Login-Logout-Controller
![image](https://user-images.githubusercontent.com/103804433/221413540-46a40d1f-428e-46f8-abac-483dc1f3790a.png)


#### For any feedback, report, suggestions, you can contact with anyone of the team members.
### THANK YOU
