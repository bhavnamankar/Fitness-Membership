package com.training.Bfit.model;

import java.util.Date;
import java.util.Objects;

public class Suspensions {
         private int suspension_Id;
         private Members member;
         private Date startDate;
         private Date endDate;
         private String  suspensionApprovalStatus;
		public int getSuspension_Id() {
			return suspension_Id;
		}
		public void setSuspension_Id(int suspension_Id) {
			this.suspension_Id = suspension_Id;
		}
		public Members getMember_Id() {
			return member;
		}
		public void setMember_Id(Members member) {
			this.member = member;
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
		public String getSuspensionApprovalStatus() {
			return suspensionApprovalStatus;
		}
		public void setSuspensionApprovalStatus(String suspensionApprovalStatus) {
			this.suspensionApprovalStatus = suspensionApprovalStatus;
		}
		@Override
		public int hashCode() {
			return Objects.hash(endDate, member, startDate, suspensionApprovalStatus, suspension_Id);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Suspensions other = (Suspensions) obj;
			return Objects.equals(endDate, other.endDate) && member == other.member
					&& Objects.equals(startDate, other.startDate)
					&& Objects.equals(suspensionApprovalStatus, other.suspensionApprovalStatus)
					&& suspension_Id == other.suspension_Id;
		}
		@Override
		public String toString() {
			return "Suspensions [suspension_Id=" + suspension_Id + ", member" + member + ", startDate="
					+ startDate + ", endDate=" + endDate + ", suspensionApprovalStatus=" + suspensionApprovalStatus
					+ "]";
		}
		public Suspensions(int suspension_Id, Members member, Date startDate, Date endDate,
				String suspensionApprovalStatus) {
			super();
			this.suspension_Id = suspension_Id;
			this.member = member;
			this.startDate = startDate;
			this.endDate = endDate;
			this.suspensionApprovalStatus = suspensionApprovalStatus;
		}
		public Suspensions() {
			super();
		}
         
}
