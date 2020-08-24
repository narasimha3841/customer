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
URL: http://localhost:7070/cusomters

Body:
 
```
{
 

  "firstName": "Edwin",
  "lastName": "Krupier",
  "age": 39,
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
  "timestamp": "2020-08-16T19:52:29.584+0000",
  "statusCode": 200,
  "statusMsg": "OK",
  "errorMsg": null,
  "payload": {
    "customerId": 1,
    "firstName": "Edwin",
    "lastName": "Krupier",
    "age": 23,
    "address": {
      "addressId": 1,
      "street": "van rynostraat",
      "postalcode": "2531TJ",
      "city": "Den haag",
      "province": "zuid holland",
      "country": "Netherlands"
    }
  }
}
```

## Retrive Customers By ID <br/>

### Request
Method: GET
URL: http://localhost:7070/cusomters/1


### Response
```
{
  "timestamp": "2020-08-16T19:56:20.439+0000",
  "statusCode": 200,
  "statusMsg": "OK",
  "errorMsg": null,
  "payload": {
    "customerId": 1,
    "firstName": "Edwin",
    "lastName": "Krupier",
    "age": 23,
    "address": {
      "addressId": 1,
      "street": "van rynostraat",
      "postalcode": "2531TJ",
      "city": "Den haag",
      "province": "zuid holland",
      "country": "Netherlands"
    }
  }
}
```

## Retrive ALL Customers <br/>

### Request
Method: GET
URL: http://localhost:7070/cusomters


### Response
	
Response body

```
{
  "timestamp": "2020-08-16T19:58:26.169+0000",
  "statusCode": 200,
  "statusMsg": "OK",
  "errorMsg": null,
  "payload": [
    {
      "customerId": 1,
      "firstName": "Edwin",
      "lastName": "Krupier",
      "age": 23,
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
      "firstName": "John",
      "lastName": "Addakula",
      "age": 23,
      "address": {
        "addressId": 2,
        "street": "van rynostraat",
        "postalcode": "2831TJ",
        "city": "Den haag",
        "province": "zuid holland",
        "country": "Netherlands"
      }
    }
  ]
}
```

## Update Customer Address <br/>

### Request
Method: PUT
URL: http://localhost:7070/cusomters/{customerId}/address

Example:  http://localhost:7070/cusomters/2/address

Body: 

```
{
  "city": "Riswijk",
  "country": "Netherlands",
  "postalcode": "2841",
  "province": "south holland",
  "street": "van raynstraat"
}


### Response
{
  "timestamp": "2020-08-16T20:01:22.101+0000",
  "statusCode": 200,
  "statusMsg": "OK",
  "errorMsg": null,
  "payload": {
    "message": "Address has been updated successfully"
  }
}
```

## Search Customer By First Name or Last Name <br/>

### Request
Method: GET
URL: http://localhost:7070/cusomters/id?name={serachstring}

Example:  http://localhost:7070/cusomters/id?name=Edwin

Response:

```
{
  "timestamp": "2020-08-16T20:04:33.160+0000",
  "statusCode": 200,
  "statusMsg": "OK",
  "errorMsg": null,
  "payload": [
    {
      "customerId": 1,
      "firstName": "Edwin",
      "lastName": "Krupier",
      "age": 23,
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
}
```


## H2 Database console url 
    http://localhost:7070/h2-console/
    driver class: org.h2.Driver
    url: jdbc:h2:mem:customer
    username: root
    password: root
