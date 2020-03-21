package hu.wirthandras.epidemap.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Disease {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotEmpty(message = "Hely kitöltése kötelező")
	public String place;
	
	@NotEmpty(message = "Betegség kitöltése kötelező")
	public String name;
	
	@NotEmpty(message = "Mutáció kitöltése kötelező")
	public String mutation;
	
	@NotEmpty(message = "Nem kitöltése kötelező")
	public String gender;
			
	public  Disease() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMutation() {
		return mutation;
	}

	public void setMutation(String mutation) {
		this.mutation = mutation;
	}
}
