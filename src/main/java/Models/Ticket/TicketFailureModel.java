package Models.Ticket;

import Stepdefinations.Base.TicketType;

public class TicketFailureModel {

	String FailureLocation;
	String FailureSpace;
	String FailurePreciseLocation;
	String FailureDetailedDescription;
	String FailurePriority;
	String Failure;
	String FailureMachineNumber;

	public String getFailureLocation() {
		return FailureLocation;
	}
	public void setFailureLocation(String failureLocation) {
		FailureLocation = failureLocation;
	}
	public String getFailureSpace() {
		return FailureSpace;
	}
	public void setFailureSpace(String failureSpace) {
		FailureSpace = failureSpace;
	}
	public String getFailurePreciseLocation() {
		return FailurePreciseLocation;
	}
	public void setFailurePreciseLocation(String failurePreciseLocation) {
		FailurePreciseLocation = failurePreciseLocation;
	}
	public String getFailureDetailedDescription() {
		return FailureDetailedDescription;
	}
	public void setFailureDetailedDescription(String failureDetailedDescription) {
		FailureDetailedDescription = failureDetailedDescription;
	}
	public String getFailurePriority() {
		return FailurePriority;
	}
	public void setFailurePriority(String failurePriority) {
		FailurePriority = failurePriority;
	}
	public String getFailure() {
		return Failure;
	}
	public void setFailure(String failure) {
		Failure = failure;
	}
	public String getFailureMachineNumber() {
		return FailureMachineNumber;
	}
	public void setFailureMachineNumber(String failureMachineNumber) {
		FailureMachineNumber = failureMachineNumber;
	}

	public TicketFailureModel() {
	}

	public TicketFailureModel(TicketType ticketType)	{
		switch(ticketType){
		case Initial:
			setFailurePreciseLocation("Precise location");
			setFailureDetailedDescription("Detailed description");
			setFailureMachineNumber("machine1");
			break;
		case Performing:
			setFailureDetailedDescription("Detailed description Performing Ticket");
			break;
		case ExternalPerforming:
			setFailureDetailedDescription("Detailed description External Performing Ticket");
			break;
		case Delegated:
			setFailureDetailedDescription("Detailed description Delegated Ticket");
			break;
		}
	}
}