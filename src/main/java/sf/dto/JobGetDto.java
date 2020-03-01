package sf.dto;

public class JobGetDto {

	private int id;
	private String name;
	private String description;
	private String owner;
	
	private UserGetDto user;
	
	private AdminGetDto admin;

	public AdminGetDto getAdmin() {
		return admin;
	}

	public void setAdmin(AdminGetDto admin) {
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public UserGetDto getUser() {
		return user;
	}

	public void setUser(UserGetDto user) {
		this.user = user;
	}
	
}
