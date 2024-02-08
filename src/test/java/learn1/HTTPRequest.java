package learn1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static 	org.hamcrest.Matchers.*;

import java.util.HashMap;

/*Given : content type,set cookies, add auth, add param,set header etc
 * When: post,get,put,delete
 * Then : Validate the status code
 */

public class HTTPRequest {
	
	int id;

	@Test(priority=1)
	public void getUsers	()
	{
		
		/*given section not reuired . for when and then we not required for given ..(first section . not required for 2nd section onward. required*/
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)//to check the status code
		.body	("page",equalTo(2))//Validate the page number
		.log().all(); //validate the entire body
		
		}
	
/*create user*/
     @Test(priority=2,dependsOnMethods= {"getUsers"})
      public void createUser()
      {
    	 
    	 //create hashmap to store data should be in key and value format
    	  HashMap hash=new HashMap();
    	  hash.put("name", "santana");
    	  hash.put("job", "Automation Test Engg");
    	  
	          id=given()//what ever the id we got we will store it here
	                .contentType("application/json")
	                .body(hash)
	         .when()
	                .post("https://reqres.in/api/users")
	                .jsonPath().getInt("id");//to print id 
	             
//	          .then()
//	               .statusCode(201)
//	               .log().all();
      }
     
     //updating user
     @Test(priority=3,dependsOnMethods= {"createUser"})
     public void updateUser() {
    	 
    	  HashMap hash=new HashMap();
    	  hash.put("name", "santana panda");
    	  hash.put("job", "senior Automation Test Engg");
    	 given()
    	  .contentType("application/json")
    	  .body(hash)
    	  
    	 .when()
    	            .put("https://reqres.in/api/users/+id")
    	            
    	 .then()
    	 .statusCode(200)
          .log().all();
     }
     
     //delete user
     @Test(priority=4,dependsOnMethods= {"updateUser"})
     public void deleteUser()
     {
    	 given()
    	 .when()
    	 .delete("https://reqres.in/api/users/+id")
    	 .then()
    	 .statusCode(204)
    	 .log().all();
    	   
     }
     

}
