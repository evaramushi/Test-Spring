package sf.dto;

public class ApplicationGetDto {
	
	private int id;
	
	
	private JobGetDto job;
	private UserGetDto user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public JobGetDto getJob() {
		return job;
	}
	public void setJob(JobGetDto job) {
		this.job = job;
	}
	public UserGetDto getUser() {
		return user;
	}
	public void setUser(UserGetDto user) {
		this.user = user;
	}
	
	
	
	

}
