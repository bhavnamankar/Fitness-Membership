package com.training.Bfit.model;

import java.util.Date;
import java.util.Objects;

public class Membership_Status {
     private Members member;
     private String membershipStatus;
     private Date startDate;
     private Date endDate;
	public Membership_Status() {
		super();
	}
	public Members getMember() {
		return member;
	}
	public void setMember(Members member) {
		this.member = member;
	}
	public String getMembershipStatus() {
		return membershipStatus;
	}
	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(endDate, member, membershipStatus, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membership_Status other = (Membership_Status) obj;
		return Objects.equals(endDate, other.endDate) && Objects.equals(member, other.member)
				&& Objects.equals(membershipStatus, other.membershipStatus)
				&& Objects.equals(startDate, other.startDate);
	}
	@Override
	public String toString() {
		return "Membership_Status [ member=" + member + ", membershipStatus=" + membershipStatus
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public Membership_Status( Members member, String membershipStatus, Date startDate,
			Date endDate) {
		super();
		this.member = member;
		this.membershipStatus = membershipStatus;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
}
