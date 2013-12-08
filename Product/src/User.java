public class User 
{
	String username;;
	String password;
	public User()
	{
		this.username = "Amber";
		this.password = "Lee";
	}
	public User(String u, String p)
	{
		this.username = u;
		this.password = p;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
}
