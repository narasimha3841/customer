Below are the steps to compile and run the application:

compile
--------
1. Go to project directory and run below command : 
	
	mvn clean install

2. Run project:
	cd target/

Run application
---------------
3. and execute below command 
 
 java -jar customer-service.jar
 
The application will start running at <http://localhost:7070>.

Test APIs using Swagger or Postman
-----------------------------------
Swagger URL: http://localhost:7070/swagger-ui.html


## Add a new Customer <br/>

### Request
Method: POST
URL: http://localhost:7070/customers

Body:
 
```
{
 

  "firstName": "Edwin",
  "lastName": "Krupier",
  "age": 23,
  "address": {
    "city": "Den haag",
    "country": "Netherlands",
    "postalcode": "2531TJ",
    "province": "zuid holland",
    "street": "van rynostraat"
  }
```


### Response
```
{
    "customerId": 1,
    "firstName": "Edwin",
    "lastName": "Krupier",
    "age": 39,
    "address": {
        "addressId": 1,
        "street": "van rynostraat",
        "postalcode": "2531TJ",
        "city": "Den haag",
        "province": "zuid holland",
        "country": "Netherlands"
    }
}
```

## Retrive Customers By ID <br/>

### Request
Method: GET
URL: http://localhost:7070/customers/1


### Response
```
{
    "customerId": 1,
    "firstName": "Edwin",
    "lastName": "Krupier",
    "age": 39,
    "address": {
        "addressId": 1,
        "street": "van rynostraat",
        "postalcode": "2531TJ",
        "city": "Den haag",
        "province": "zuid holland",
        "country": "Netherlands"
    }
}
```

## Retrive ALL Customers <br/>

### Request
Method: GET
URL: http://localhost:7070/customers


### Response
	
Response body

```
[
    {
        "customerId": 1,
        "firstName": "Edwin",
        "lastName": "Krupier",
        "age": 39,
        "address": {
            "addressId": 1,
            "street": "van rynostraat",
            "postalcode": "2531TJ",
            "city": "Den haag",
            "province": "zuid holland",
            "country": "Netherlands"
        }
    },
    {
        "customerId": 2,
        "firstName": "Erik",
        "lastName": "Van",
        "age": 49,
        "address": {
            "addressId": 2,
            "street": "van rynostraat",
            "postalcode": "2531TJ",
            "city": "Den haag",
            "province": "zuid holland",
            "country": "Netherlands"
        }
    }
]
```

## Update Customer Address <br/>

### Request
Method: PUT
URL: http://localhost:7070/customers/{customerId}/address

Example:  http://localhost:7070/customers/2/address

Body: 

```
{
  "city": "Riswijk",
  "country": "Netherlands",
  "postalcode": "2841",
  "province": "south holland",
  "street": "van ruysbroekstraat"
}


### Response

{
    "message": "Address has been updated successfully"
}
```

## Search Customer By First Name or Last Name <br/>

### Request
Method: GET
URL: http://localhost:7070/customers/search?fname={firstName}&lname={lastName}

Example:  http://localhost:7070/customers/search?fname=Erik&lname=Van

Response:

```
[
    {
        "customerId": 1,
        "firstName": "Erik",
        "lastName": "Van",
        "age": 49,
        "address": {
            "addressId": 1,
            "street": "van rynostraat",
            "postalcode": "2531TJ",
            "city": "Den haag",
            "province": "zuid holland",
            "country": "Netherlands"
        }
    }
]
```


## H2 Database console url 
    http://localhost:7070/h2-console/
    driver class: org.h2.Driver
    url: jdbc:h2:mem:customer
    username: root
    password: root
