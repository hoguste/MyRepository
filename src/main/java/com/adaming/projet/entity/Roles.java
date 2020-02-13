package com.adaming.projet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {
	@Id
	private long idRole;
	@Column(name = "role_name")
	private String roleName;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUser")
	private Users users;
	
	

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public long getIdRole() {
		return idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Roles(long idRole, String roleName, Users users) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
		this.users = users;
	}

	public Roles() {
		super();
	}

	@Override
	public String toString() {
		return "Roles [idRole=" + idRole + ", roleName=" + roleName + ", users=" + users + "]";
	}

}