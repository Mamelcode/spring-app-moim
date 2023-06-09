package org.edupoll.controller;

import java.util.List;
import java.util.Optional;

import org.edupoll.model.entity.Avatar;
import org.edupoll.model.entity.Moim;
import org.edupoll.model.entity.Reply;
import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.repository.AvatarRepository;
import org.edupoll.repository.MoimRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AssociationController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AvatarRepository avatarRepository;
	
	@Autowired
	MoimRepository moimRepository;
	
	@GetMapping("/assoc/01")
	public String assoc01Handle(String userId) {
		
		User found = userRepository.findById(userId).orElse(null);
		for(Moim m : found.getMoim()) {
			System.out.println(m.getTitle());
		}
		System.out.println(found.toString());
		
		return "index";
	}
	
	@GetMapping("/assoc/02")
	public String assoc02Handle(String avatarId) {
		Optional<Avatar> avatarOption = avatarRepository.findById(avatarId);
		
		if(avatarOption.isPresent()) {
			Avatar a = avatarOption.get();
			List<UserDetail> details = a.getDetails();
			for(UserDetail u : details) {
				System.out.println("--> "+ u.getUser().getId());
			}
		}else {
			System.out.println("찾을수업음!");
		}
		
		return "index";
	}
	
	@GetMapping("/assoc/03")
	public String assoc03Handle(String moimId) {
		Optional<Moim> moimOption = moimRepository.findById(moimId);
		
		System.out.println("count ==> "+ moimRepository.count());
		
		System.out.println("댓글 갯수 => "+ moimOption.get().getReplys().size());
		
		if(moimOption.isPresent()) {
			Moim moim = moimOption.get();
			for(Reply r : moim.getReplys()) {
				System.out.println("댓글 => "+ r.getText());
			}
		}
		
		return "index";
	}
}
