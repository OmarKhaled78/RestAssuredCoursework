This is the practical application of what i've learned in my Rest Assured API Testing course
MyFirstTestCase Class contains a get request on a mock API endpoint that i've created along with some different types of assertions 
infoTest class contains 2 get requests on the course provider's test api along with some additional operations such as setting headers and query parameters etc
LoginTest class contains a post request to test the login endpoint in the course provider's test api 
getCoursesTest class contains a get request to mainly practice authentication in rest assured, it is dependent on the token returned previously from the LoginTest class
NOTE: LoginTest and getCoursesTest classes do not work properly because the login credentials provided by the course provider are not valid anymore
