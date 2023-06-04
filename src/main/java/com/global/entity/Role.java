package com.global.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


@Entity
@Component
public class Role {

	// instance variable
	@Id
	@SequenceGenerator(name = "myRoleSeq", sequenceName = "myRoleSeq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "myRoleSeq")
	private int rId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String roleId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String roleName;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String isActive="true";
	
	@OneToMany(mappedBy = "role")
	private List<User> user;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [rId=" + rId + ", roleId=" + roleId + ", roleName=" + roleName + ", isActive=" + isActive
				+ ", user=" + user + "]";
	}

	


	

}
