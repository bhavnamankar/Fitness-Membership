package com.training.Bfit.model;
import java.util.Date;
import java.util.Objects;

public class Transactions {
          private int transactions_Id;
          private Members member;
          private Date transactionDate;
          private String paymentMethod;
		public Transactions() {
			super();
		}
		public int getTransactions_Id() {
			return transactions_Id;
		}
		public void setTransactions_Id(int transactions_Id) {
			this.transactions_Id = transactions_Id;
		}
		
		public Members getMember() {
			return member;
		}
		public void setMember(Members member) {
			this.member = member;
		}
		public Date getTransactionDate() {
			return transactionDate;
		}
		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}
		public String getPaymentMethod() {
			return paymentMethod;
		}
		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}
		@Override
		public int hashCode() {
			return Objects.hash(member, paymentMethod, transactionDate, transactions_Id);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Transactions other = (Transactions) obj;
			return Objects.equals(member, other.member) && Objects.equals(paymentMethod, other.paymentMethod)
					&& Objects.equals(transactionDate, other.transactionDate)
					&& transactions_Id == other.transactions_Id;
		}
		@Override
		public String toString() {
			return "Transactions [transactions_Id=" + transactions_Id  + ", member=" + member
					+ ", transactionDate=" + transactionDate + ", paymentMethod=" + paymentMethod + "]";
		}
		public Transactions(int transactions_Id, Members member, Date transactionDate,
				String paymentMethod) {
			super();
			this.transactions_Id = transactions_Id;
			this.member = member;
			this.transactionDate = transactionDate;
			this.paymentMethod = paymentMethod;
		}
		
}
