package com.training.Bfit.model;
import java.util.*;
import java.util.Objects;

public class Membership_Plans {
      private int plan_Id;
      private String planName;
      private int durationMonth;
      private int price;
      
      
	public Membership_Plans() {
		super();
	}
	public Membership_Plans(int plan_Id, String planName, int durationMonth, int price) {
		super();
		this.plan_Id = plan_Id;
		this.planName = planName;
		this.durationMonth = durationMonth;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Membership_Plan [plan_Id=" + plan_Id + ", planName=" + planName + ", durationMonth=" + durationMonth
				+ ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(durationMonth, planName, plan_Id, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membership_Plans other = (Membership_Plans) obj;
		return durationMonth == other.durationMonth && Objects.equals(planName, other.planName)
				&& plan_Id == other.plan_Id && price == other.price;
	}
	public int getPlan_Id() {
		return plan_Id;
	}
	public void setPlan_Id(int plan_Id) {
		this.plan_Id = plan_Id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getDurationMonth() {
		return durationMonth;
	}
	public void setDurationMonth(int durationMonth) {
		this.durationMonth = durationMonth;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
