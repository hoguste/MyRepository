package com.adaming.projet.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource datasourceBean;

	public DataSource getDatasourceBean() {
		return datasourceBean;
	}

	public void setDatasourceBean(DataSource datasourceBean) {
		this.datasourceBean = datasourceBean;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasourceBean)
				.usersByUsernameQuery("select u.username, u.password, u.actived from users u where u.username=?")
				.authoritiesByUsernameQuery(
						"select u.username, r.role_name from users u, roles r  where u.idUser = r.idUser and u.username =?");
//		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic().and().authorizeRequests().antMatchers("/Etudiant/ajoutetudiant").hasAuthority("ADMIN_ETU");
		http.httpBasic().and().authorizeRequests().antMatchers("/Etudiant/supprimeretudiant").hasAuthority("ADMIN_ETU");
		http.httpBasic().and().authorizeRequests().antMatchers("/Matiere/ajoutmatiere").hasAuthority("ADMIN_MAT");
		http.httpBasic().and().authorizeRequests().antMatchers("/Etudiant/supprimeretudiant").hasAuthority("ADMIN_MAT");
		http.formLogin().loginPage("/login").passwordParameter("password").usernameParameter("username")
				.defaultSuccessUrl("/home").failureUrl("https://www.youtube.com/watch?v=Ygnez_odlNg");
//		super.configure(http);
	}

}
