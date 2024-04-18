package com.training.Bfit.model;

import java.util.Date;
import java.util.Objects;

public class Cancellations {
   private int cancellation_Id;
   private Members member;
   private Date cancellationDate;
   private String reason;
public int getCancellation_Id() {
	return cancellation_Id;
}
public void setCancellation_Id(int cancellation_Id) {
	this.cancellation_Id = cancellation_Id;
}
public Members getMember() {
	return member;
}
public void setMember(Members member) {
	this.member = member;
}
public Date getCancellationDate() {
	return cancellationDate;
}
public void setCancellationDate(Date cancellationDate) {
	this.cancellationDate = cancellationDate;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
@Override
public int hashCode() {
	return Objects.hash(cancellationDate, cancellation_Id, member, reason);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cancellations other = (Cancellations) obj;
	return Objects.equals(cancellationDate, other.cancellationDate) && cancellation_Id == other.cancellation_Id
			&& Objects.equals(member, other.member) && Objects.equals(reason, other.reason);
}
@Override
public String toString() {
	return "Cancellations [cancellation_Id=" + cancellation_Id + ", member=" + member + ", cancellationDate="
			+ cancellationDate + ", reason=" + reason + "]";
}
public Cancellations(int cancellation_Id, Members member, Date cancellationDate, String reason) {
	super();
	this.cancellation_Id = cancellation_Id;
	this.member = member;
	this.cancellationDate = cancellationDate;
	this.reason = reason;
}
public Cancellations() {
	super();
	// TODO Auto-generated constructor stub
}

   
}
