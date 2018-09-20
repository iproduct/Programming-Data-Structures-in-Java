package addressbook.model;

import java.util.Date;

public class Contact implements Comparable<Contact>{
	private String fName;
	private String lName;
	private String email;
	private String mobilePhone;
	private String businessPhone;
	private String homePhone;
	private String organization;
	private Address address;
	private String description;
	private Date created;
	private Date updated;
	private String photoUrl;
	
	public Contact() {
	}

	public Contact(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}
	
	public Contact(String fName, String lName, String email, String mobilePhone) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.mobilePhone = mobilePhone;
	}
	
	public Contact(String fName, String lName, String email, String mobilePhone, String businessPhone, String homePhone,
			String organization, Address address, String description, Date created, Date updated, String photoUrl) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.businessPhone = businessPhone;
		this.homePhone = homePhone;
		this.organization = organization;
		this.address = address;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.photoUrl = photoUrl;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
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
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
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
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [fName=").append(fName).append(", lName=").append(lName).append(", email=")
				.append(email).append(", mobilePhone=").append(mobilePhone).append(", businessPhone=")
				.append(businessPhone).append(", homePhone=").append(homePhone).append(", organization=")
				.append(organization).append(", address=").append(address).append(", description=").append(description)
				.append(", created=").append(created).append(", updated=").append(updated).append(", photoUrl=")
				.append(photoUrl).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Contact other) {
		int compare = this.fName.compareTo(other.fName);
		if(compare == 0) {
			compare = this.lName.compareTo(other.lName);
		}
		return compare;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
