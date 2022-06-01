package RestAssuredAssignment;

import java.io.IOException;

import org.testng.annotations.Test;

public class RestAssured extends testBase{
	
	@Test(description="perform test to CREATE user")
	public void createUser()
	{
		//creating user with escape character
		this.post_CreateUser("{\r\n  \"id\": 1,\r\n  \"first_name\": \"Nusrat\",\r\n  \"middle_name\": \"\",\r\n  \"last_name\": \"Balur\",\r\n  \"date_of_birth\": \"28-11-1992\"\r\n}", "http://thetestingworldapi.com/Help/api/studentsDetails", "Content-Type","application/json", 200);
		//this.post_CreateUser("{\r\n  \"id\": 0,\r\n  \"username\": \"ABC\",\r\n  \"firstName\": \"Abc\",\r\n  \"lastName\": \"Bcd\",\r\n  \"email\": \"abc@bbc.com\",\r\n  \"password\": \"abcbbc1\",\r\n  \"phone\": \"1234567890\",\r\n  \"userStatus\": 0\r\n}", "https://petstore.swagger.io/v2/user", "Content-Type","application/json", 200);
	}
		
	@Test(description="perform PUT operation with escape character")
	public void putEscape() throws IOException
	{
		
		this.put_updateUserEscapechar("{\r\n  \"id\": 1,\r\n  \"first_name\": \"Nurahan\",\r\n  \"middle_name\": \"\",\r\n  \"last_name\": \"Lalkhanwar\",\r\n  \"date_of_birth\": \"29-02-1982\"\r\n}", "http://thetestingworldapi.com/Help/api/studentsDetails", "Content-Type", "application/json", 200);		
	}
	
	@Test(description="to perform GET modified User details")
	public void getUser()
	{
				//get User Details
		this.get_GetUser(1,"http://thetestingworldapi.com/Help/api/studentsDetails", "message", 200);
	}
	
	
	@Test(description="perform DELETE operation")
	public void deleteUser()throws IOException
	{
		this.deleteUser(1,"http://thetestingworldapi.com/Help/api/studentsDetails", "message", 200);
	}
	
		
}
