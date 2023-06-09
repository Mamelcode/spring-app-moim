package org.edupoll.security.support;

import java.util.ArrayList;
import java.util.Collection;

import org.edupoll.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Account implements UserDetails{

	User user;
	
	public Account(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> list = new ArrayList<>();
		list.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return user.getAuthority();
			}
		});
		return list;
	}
	
	public String getNick() {
		return user.getNick();
	}

	@Override
	public String getPassword() {
		return user.getPass();
	}

	@Override
	public String getUsername() {
		return user.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
