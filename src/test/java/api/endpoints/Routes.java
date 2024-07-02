package api.endpoints;

/*
swagger URL ----> https://petstore.swagger.io

create user(post) : https://petstore.swagger.io/v2/user
read user(Get) : https://petstore.swagger.io/v2/user/{username}
Update user (PUT) : https://petstore.swagger.io/v2/user/{username}
Delete user (DELETE) : https://petstore.swagger.io/v2/user/{username}

*/

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2/";
     
	// User Model
	
	public static String postuser_url = base_url+"user";
	public static String getuser_url = base_url+"user/{username}";
	public static String updateuser_url = base_url+"user/{username}";
	public static String deleteuser_url = base_url+"user/{username}";
	
	// Pet Model
	
	public static String postpet_url = base_url+"pet";
	public static String getpet_url = base_url+"pet/{id}";
	public static String updatepet_user = base_url+"pet/{id}";
	public static String deletepet_user = base_url+"pet/{id}";

	// Store Model
	
	public static String poststore_url = base_url+"store/order";
	public static String getstore_url = base_url+"store/order/{orderId}";
	public static String getinstore_url = base_url+"store/inventory";
	public static String deletestore_url = base_url+"store/order/{orderID}";
	
	
	
	
	
}
