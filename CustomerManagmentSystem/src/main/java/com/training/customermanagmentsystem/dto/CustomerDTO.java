package com.training.customermanagmentsystem.dto;

import org.springframework.lang.NonNull;


public class CustomerDTO {
	
	
	  
	   private Integer id;
	
	   @NonNull
		private String name;
		
	   @NonNull
		private String phone;
		
		private String email;
		
		private String gender;
		
		@NonNull
		private String city;

		
		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}




		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		@Override
		public String toString() {
			return "CustomerDTO [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", gender="
					+ gender + ", city=" + city + "]";
		}


		public CustomerDTO(String name, String phone, String email, String gender, String city) {
			super();
			this.name = name;
			this.phone = phone;
			this.email = email;
			this.gender = gender;
			this.city = city;
		}


		public CustomerDTO() {
			super();
		}


		public CustomerDTO(Integer id) {
			super();
			this.id = id;
		}


		public CustomerDTO(Integer id, String name, String phone, String email, String gender, String city) {
			super();
			this.id = id;
			this.name = name;
			this.phone = phone;
			this.email = email;
			this.gender = gender;
			this.city = city;
		}


		


}
