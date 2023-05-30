package org.edupoll.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.MoimListData;
import org.edupoll.model.entity.Moim;
import org.edupoll.service.MoimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/moim")
public class MoimController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	MoimService moimService;
	
	@GetMapping("/create")
	public String moimCreateViewHandle(Model model) {
		
		String[] cates = new String[] {"취미","학습","봉사","건강","비지니스","문화","스포츠"};
		String[] persons = new String[] {"2","3","4","5","6","7","8","9","10"};
		
		
		model.addAttribute("cates", cates);
		model.addAttribute("persons", persons);
		
		return "main/moimCreate";
	}
	
	@PostMapping("/create")
	public String moimCreateHandle(@SessionAttribute String logonId , Moim moim) {
		
		logger.debug("moim crate ==> {} ", moim);
		boolean result = moimService.createMoim(moim, logonId);
		
		return "redirect:/main/moim/list";
	}
	
	@GetMapping("/list")
	public String moimListHandle(@RequestParam(defaultValue = "1")int page , Model model) {
		
		List<Moim> moims = moimService.findByMoimAll(page);
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		List<MoimListData> list = new ArrayList<>();
		
		for(Moim m : moims) {
			MoimListData data = new MoimListData();
			data.setId(m.getId());
			data.setCate(m.getCate());
			data.setCurrentPerson(m.getCurrentPerson());
			data.setDescription(m.getDescription());
			data.setDuration(m.getDuration());
			data.setFormatDate(sd.format(m.getTargetDate()));
			data.setTitle(m.getTitle());
			data.setMaxPerson(m.getMaxPerson());
			
			list.add(data);
		}
		
		
		long cnt = moimService.countMoim();
		List<String> pages = new ArrayList<>();
		for(int i=1; i<=cnt/6 + (cnt % 6 > 0 ? 1 : 0); i++) {
			pages.add(String.valueOf(i));
			if(i == 10) {
				break;
			}
		}
		model.addAttribute("pages", pages);	
		
		model.addAttribute("moims", list);
		
		return "main/moimList";
	}
	
	@GetMapping("/view")
	public String moimViewHandle(String moimId, Model model) {
		
		Moim moim = moimService.findByMoim(moimId);
		
		logger.debug("View Handle ==> {}", moim);
		
		model.addAttribute("moim", moim);
		
		return "main/moimView";
	}
	
}
