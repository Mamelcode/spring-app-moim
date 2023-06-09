package org.edupoll.security.support;

import java.util.Optional;

import org.edupoll.model.dto.request.JoinUserRequestData;
import org.edupoll.model.entity.User;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountManager implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username ==> "+ username);
		
		Optional<User> option = userRepository.findById(username);
		if(option.isPresent()) {
			User user = option.get();
			return new Account(user);		
		}else {
			throw new UsernameNotFoundException("Not Found : "+ username);
		}
	}
	
	public boolean createUser(JoinUserRequestData userData) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		userData.setPass("{bcrypt}"+encoder.encode(userData.getPass()));
		User user = new User(userData.getId(), userData.getPass(), userData.getNick()
				, "ROLE_VIP");
		userRepository.save(user);
		
		return true;
	}
}
