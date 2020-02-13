package com.adaming.projet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	private long idUser;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private boolean actived;
	@OneToMany(mappedBy="users", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Roles> role;
	
	
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public List<Roles> getRole() {
		return role;
	}
	public void setRole(List<Roles> role) {
		this.role = role;
	}
	public Users(long idUser, String username, String password, boolean actived, List<Roles> role) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.role = role;
	}
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", username=" + username + ", password=" + password + ", actived=" + actived
				+ ", role=" + role + "]";
	}
	
	
}
