package Models;

public class ServicePortalMaintainance {

	String Topic;
	String TopicDescription;
	String From;
	String To;
	String BuildingAddress;
	String Address;
	
	public String getTopic() {
		return Topic;
	}
	public void setTopic(String topic) {
		Topic = topic;
	}
	public String getTopicDescription() {
		return TopicDescription;
	}
	public void setTopicDescription(String topicDescription) {
		TopicDescription = topicDescription;
	}
	public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	public String getBuildingAddress() {
		return BuildingAddress;
	}
	public void setBuildingAddress(String buildingAddress) {
		BuildingAddress = buildingAddress;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public ServicePortalMaintainance()
	{
		setTopic("Maintenance Topic");
		setTopicDescription("Maintenance Topic Description");
		setFrom("01:00");
		setTo("23:00");
		setBuildingAddress("Sir Winston Churchillln 299");
		setAddress("building unit description - Sir Winston Churchillln 299 a");
	}
	
	
}
