package learn2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static 	org.hamcrest.Matchers.*;

import java.io.*;
import java.util.*;

public class WayToCreatePostRequest {
	
	
	
	private ValidatableResponse id;

	/*o using 	HashMap*/
	//@Test(priority=1)
	                   public void testPostUsingHashMap()
	                    {
		                    HashMap hash=new HashMap();
		                    		hash.put("userId", "santana");
		                            hash.put("jobTitleName", "Senior automation tester");
		                            hash.put("firstName", "santana");
		                            hash.put("lastName", "panda");
		                            hash.put("preferredFullName", "santana Panda");
		                            hash.put("employeeCode", "E1");
		                            hash.put("region", "IN");
		                            hash.put("phoneNumber", "9082933528");
		                            hash.put("emailAddress", "santana.panda300992@gmail.com");
		                    id=given()
		                            .contentType("application/json")
		                             .body(hash)
		                             
		                    .when()
		                             .post("http://localhost:3000/Employees")
		                             
		                      .then()
		                              .statusCode(201)
		                              .body("userId",equalTo("santana"))
		                              .body("jobTitleName",equalTo("Senior automation tester"))
		                             // .header("contentType","application/json;charset=\"UTF-8\"")
		                              .log().all();
		 
		
	                    }
	
	//@Test(priority=2,dependsOnMethods= {"testPostUsingHashMap"})
	               public void deleteUser()
	                     {
		
		                        given()
		                        .when()
		                              .delete("http://localhost:3000/Employees/+id")
		                         .then()
		                              .statusCode(404)
		                              .log().all();
		                         
		                         
	                     }
	
	/*************************************************************************************************/
	/*o	*******************Org,json library*******need to import dependency *************************************************/
	
	//@Test
	                     public void testPostusingOrgLibrary()
	                     
	                   
	                          {
		                         JSONObject  jsondata =new JSONObject();
		                         jsondata.put("userId", "Sudhanshu");
		                         jsondata.put("jobTitleName", "Senior automation tester");
		                         jsondata.put("firstName", "Sudhanshu");
		                         jsondata.put("lastName", "padhi");
		                         jsondata.put("preferredFullName", "sudhanshu Padhi");
		                         jsondata.put("employeeCode", "E1");
		                         jsondata.put("region", "IN");
		                         jsondata.put("phoneNumber", "9082933528");
		                         jsondata.put("emailAddress", "sudhanshu.padhi300992@gmail.com");
		                         
								id=given()
		                            		  .contentType("application/json")
		                            		  .body(jsondata.toString())
                   
		                      .when()
		                      				.post("http://localhost:3000/Employees")
                   
                            .then()
                            				.statusCode(201)
                            				.body("userId",equalTo("Sudhanshu"))
                            				.body("jobTitleName",equalTo("Senior automation tester"))
                            				// .header("contentType","application/json;charset=\"UTF-8\"")
                            				.log().all();
		   
	                           }
	     //@Test(priority=2,dependsOnMethods= {"testPostusingOrgLibrary"})
            public void deleteorglibraryPostRequestData()
                 {

                           given()
                          .when()
                               .delete("http://localhost:3000/Employees/+id")
                         .then()
                             .statusCode(404)
                             .log().all();
                 }
                  
	       /*************************************************************************************************/
	   	/*o	*******************POJO Class*******here we are using the concept Encapsulation *************************************************/ 
            
       // @Test(priority=1)
            public void testPostUsingPOJOClass()
            
            
            {
            	Pojo_PostRequest  pojopostrequest=new Pojo_PostRequest ();
            	pojopostrequest.setUserId("Urvija");
            	pojopostrequest.setJobTitleName("Senior automation tester");
            	pojopostrequest.setFirstName("Urvija");
            	pojopostrequest.setLastName("Padhi");
            	pojopostrequest.setPreferredFullName("Urvija Padhi");
            	pojopostrequest.setEmployeeCode("M2");
             	pojopostrequest.setRegion("IN");
            	pojopostrequest.setPhoneNumber("9082935528");
            	pojopostrequest.setEmailAddress("Urvija@gmail.com");
            	
            	id=given()
            	        .contentType("application/json")
            	        .body(pojopostrequest)
            	  
            	  .when()
    					.post("http://localhost:3000/Employees")

                 .then()
  						.statusCode(201)
  					    .body("userId",equalTo("Urvija"))
  					   //.body("jobTitleName",equalTo("Senior automation tester"))
  					    // .header("contentType","application/json;charset=\"UTF-8\"")
  					    .log().all();
            	
            	
    }
       //@Test(priority=2,dependsOnMethods= {"testPostUsingPOJOClass"})
            public void deletePOJOPostRequestData()
                 {

                           given()
                          .when()
                               .delete("http://localhost:3000/Employees/+id")
                         .then()
                             .statusCode(404)
                             .log().all();
                 }
     
 	       /**
 	     * @throws FileNotFoundException ***********************************************************************************************/
    	   	/*o	*******************o	Using external json file**********************************************/
            
            @Test(priority=1)
            public void testPostUsingExternalFile() throws FileNotFoundException
            
            
            {
            	File file=new File("C:\\Assessment\\RestAssureAPI\\Testdata.json");
            	FileReader fileread=new FileReader(file);
            	JSONTokener jsontoken=new JSONTokener(fileread);
            	JSONObject jsonobject=new JSONObject(jsontoken);
            	
            	id=given()
            	        .contentType("application/json")
            	        .body(jsonobject.toString())
            	  
            	  .when()
    					.post("http://localhost:3000/Employees")

                 .then()
  						.statusCode(201)
  					  //  .body("userId",equalTo("skp"))
  					  // .body("jobTitleName",equalTo("Senior automation tester"))
  					    // .header("contentType","application/json;charset=\"UTF-8\"")
  					    .log().all();
            	
            	
    }
       @Test(priority=2,dependsOnMethods= {"testPostUsingExternalFile"})
            public void deleteExternalFilePostRequestData()
                 {

                           given()
                          .when()
                               .delete("http://localhost:3000/Employees/+id")
                         .then()
                             .statusCode(404)
                             .log().all();
                 }
     

}


