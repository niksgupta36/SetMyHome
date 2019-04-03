package models;

import java.util.List;

public class Event {
	
	String title;
	String date;
	String description;
	List<timeSlot> timeSlots;
	
	
	
	public Event(String title, String date, String description, List<timeSlot> timeSlots) {
		super();
		this.title = title;
		this.date = date;
		this.description = description;
		this.timeSlots = timeSlots;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<timeSlot> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<timeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}
	
		
}
