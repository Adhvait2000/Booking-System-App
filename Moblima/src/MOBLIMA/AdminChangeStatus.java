package MOBLIMA;

public enum AdminChangeStatus {
	// when the change made in the admin section is Successful

	SUCCESSFUL("Changes made are successful."),

	// when the change made is unsuccessful

	UNSUCCESSFUL("Changes made are unsuccessful."),

	// when changes made are rejected in the admin section

	REJECTED("Changes made cannot be applied!");

	private String status;

	// set status

	AdminChangeStatus(String status) {
		this.status = status;
	}

	// return status
	public String returnStatus() {
		return status;
	}
}