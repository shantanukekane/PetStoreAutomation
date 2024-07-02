package api.test;



import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setUsername(faker.name().username());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	
		//logs
		logger = LogManager.getLogger(this.getClass());
		
		
	}
	
	
	
	@Test(priority = 1)
	public void testPostUser()
	{
		
		
		logger.info("************* Creating Post User **********");
		
		Response resp = UserEndPoints.createUser(userPayload);
		resp.then().log().all();
	
	    Assert.assertEquals(resp.getStatusCode(),200);
		
	    logger.info("************ User is created ***********");
	}
	

	@Test(priority = 2)
	public void testGetUserByName()
	{
		logger.info("*************Reading User info **********");

		Response response = UserEndPoints.ReadUser(this.userPayload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
		
		logger.info("******** User info is Displayed ********");
	
	}
	
	@Test(priority = 3)
	public void testUpdateUserByName()
	{
		
		logger.info("********* Update User Info ********");
		
		// update the new data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndPoints.UpdateUser(userPayload, this.userPayload.getUsername());
		response.then().log().body();
	    
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("****** User is updated *******");
		
		// check after updating the data 
		
		logger.info("******* Reading updated User *******");
		
        Response responseAfterupdate = UserEndPoints.ReadUser(this.userPayload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(responseAfterupdate.statusCode(),200);
		
		logger.info("******** Display updated user ***********");
	}
	
	@Test(priority = 4)
	public void testDeleteUserByName()
	{
		logger.info("*********** Deleting User info ************");
		
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*********** User Deleted ************");;
		
	}
	
	
	
	
}
