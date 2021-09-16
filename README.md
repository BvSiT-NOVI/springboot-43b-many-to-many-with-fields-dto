This project is based on https://github.com/PeterAnema/springboot-43-many-to-many-with-fields 

In this branch:

- created  a StudentDtoController which uses the base mapping /dto/students. Identical to StudentController except now `createStudent()` uses a StudentDto instead of directly a Student object. This allows validation in the StudentDto before an update of the database is executed. The entity class Student should only be concerned with the database model.
- StudentDtoControllerTest performs an assertion test to test if passing an empty name in StudentDto is correctly intercepted. Not perfect since the test does not show the returned error message to the client which calls the POST endpoint.


Compare with previous branch:
https://github.com/BvSiT-NOVI/springboot-43b-many-to-many-with-fields-dto/compare/rest-tests..validate-student

