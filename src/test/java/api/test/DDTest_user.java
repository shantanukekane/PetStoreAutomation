package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest_user {
	
	@Test(priority = 1,dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void testPostUser(String userid,String userName,String fname,String lname,String useremail,String pwd,String ph)// it should be same as excel order
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userid));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
	    Response response =	UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}

	
	@Test(priority = 2, dataProvider = "userNames",dataProviderClass = DataProviders.class)
	public void testGetUserByName(String userName)
	{
		
		Response response = UserEndPoints.ReadUser(userName);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	
	@Test(priority = 3, dataProvider = "userNames",dataProviderClass = DataProviders.class)
	public void  testDeleteUserByName(String userName)
	{

		Response response = UserEndPoints.deleteUser(userName);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
}
