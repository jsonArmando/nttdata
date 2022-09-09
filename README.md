#nttdata

1. It is required to create a REST microservice that allows me to consult the basic information of a client. Conditions of service:
   two.
   a) The handling of http codes in the response is essential (within the code it is necessary to show the handling of the following 400, 404, 500 and 200).

b) The only input data for the service is the type and number of the document, both are mandatory and for the type of document only types C (citizenship card) and P (Passport) are valid.

c) The data that the service must return are: (They must be “burned”)
 First name
 Second name
 First surname
 Second surname
 Telephone
 Address
 City of residence

3. The port through which the application should start is 8090.
4. It is essential to use Spring and Maven.
5. The JAR of the application and the source code are deliverable.

RELEVANT POINTS:
 The response data is circumvented, that is, information will only be returned for the client identified with Citizenship Card 23445322.

 They are added values ​​but not mandatory application log management, unit tests and code quality.

 You can use the development Ide that you feel most comfortable with.

 There will be a session of 15 to 30 minutes to support the technical test
localhost:8090/v1/information/data/?id=1234&idNumber=C

Respuesta:

[
{
"firstName": "Jose",
"middleName": "Armando",
"firstSurname": "Son",
"secondSurname": "Rojas",
"phone": 123456789,
"address": "Calle falsa 123",
"cityResidence": "Bogotá"
}
]