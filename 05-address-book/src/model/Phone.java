package model;
import static model.PhoneKind.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
	private String extension;
	private String number;
	private PhoneKind kind;
	
	public Phone() {
	}

	public Phone(String extension, String number) {
		this.extension = extension;
		this.number = number;
		kind = PERSONAL;
	}

	public Phone(String extension, String number, PhoneKind kind) {
		this.extension = extension;
		this.number = number;
		this.kind = kind;
	}
	
	public static Phone parsePhone(String phoneStr, PhoneKind kind) {
		phoneStr = phoneStr.trim();
		Pattern p = Pattern.compile("^(\\(?\\+?\\d{2,5}\\)?)?[\\s,-]+([\\d\\s]{6,})$");
		Matcher m = p.matcher(phoneStr);
		if(m.matches()) {
			return new Phone(m.group(1), m.group(2), kind);
		} else {
			return new Phone("", phoneStr, kind);
		}
	}
	public static Phone parsePhone(String phoneStr) {
		return parsePhone(phoneStr, PERSONAL);
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneKind getKind() {
		return kind;
	}

	public void setKind(PhoneKind kind) {
		this.kind = kind;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		Phone other = (Phone) obj;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (kind != other.kind)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(kind).append(": (").append(extension).append(") ").append(number);
		return builder.toString();
	}
	
}
