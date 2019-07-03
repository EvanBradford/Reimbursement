package application;

public class reimbursements {
	protected int requestId;
	protected double amount;
	protected String purpose;
	protected String submitDate;
	protected String status;
	protected int employee_id;
	
	public reimbursements() {
	}
	
	public reimbursements(int requestId, double amount, String purpose, String submitDate, String status,
			int employee_id) {
		super();
		this.requestId = requestId;
		this.amount = amount;
		this.purpose = purpose;
		this.submitDate = submitDate;
		this.status = status;
		this.employee_id = employee_id;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + employee_id;
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + requestId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		reimbursements other = (reimbursements) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (requestId != other.requestId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "reimbursements [requestId=" + requestId + ", amount=" + amount + ", purpose=" + purpose
				+ ", submitDate=" + submitDate + ", status=" + status + ", employee_id=" + employee_id + "]";
	}
	
	
}
