package hello;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String genId;
	public int id;
	private String creater;
	private String createdDay;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getCreatedDay() {
		return createdDay;
	}
	public void setCreatedDay(String createdDay) {
		this.createdDay = createdDay;
	}
}
