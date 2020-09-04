import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class jdbcconnection 
{
	public static void main(String[] args) throws SQLException 
	{
String host="localhost";
String port="3306";
Connection  con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt","root","root");//connected java eclipse to mysql db
Statement s=con.createStatement();
ResultSet  rs=s.executeQuery("select * from Employeeinfo where name='ram'");
while(rs.next())
{
	WebDriver driver= new FirefoxDriver();

	driver.get("https://login.salesforce.com/");
	driver.findElement(By.xpath("//*[@id='username']")).sendKeys(rs.getString("name"));

	driver.findElement(By.xpath("//*[@id='password']")).sendKeys(rs.getString("age"));


System.out.println(rs.getString("name"));
System.out.println(rs.getString("age"));
System.out.println("one github");

}
	}

}
