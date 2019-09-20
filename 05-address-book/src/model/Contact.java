package model;

import java.util.Date;

public class Contact {
	private String firstName;
	private String lastName;
	private String email;
	private String mobilePhone;
	private String businessPhone;
	private String homePhone;
	private String organization;
	private Address address;
	private String description;
	private Date created = new Date();
	private Date modified = created;
	private String photoUrl;
	public Contact() {
	}
	public Contact(String firstName, String lastName, String email, String mobilePhone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobilePhone = mobilePhone;
	}
	public Contact(String firstName, String lastName, String email, String mobilePhone, String businessPhone,
			String homePhone, String organization, Address address, String description, String photoUrl) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.businessPhone = businessPhone;
		this.homePhone = homePhone;
		this.organization = organization;
		this.address = address;
		this.description = description;
		this.photoUrl = photoUrl;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getBusinessPhone() {
		return businessPhone;
	}
	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Contact other = (Contact) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ").append(firstName).append(" ").append(lastName)
				.append("\nEmail: ").append(email).append("\nMobile: ").append(mobilePhone);
		if(businessPhone != null)
			builder.append(", Business: ").append(businessPhone);
		if(homePhone != null)
			builder.append(", Home: ").append(homePhone);
		if(organization != null)
			builder.append("\nOrganization: ").append(organization);
		if(address != null)
			builder.append("\nAddress=").append(address);
		if(description != null)
			builder.append("\nDescription=").append(description);
		if(photoUrl != null)
			builder.append("\nPhoto: ").append(photoUrl);
		return builder.toString();
	}
	
	
}
