package org.edupoll.util;

import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.etc.CateSeleteWapper;
import org.springframework.stereotype.Component;

@Component
public class CateSeleteSupport {

	public List<CateSeleteWapper> cateSelete(String[] cate) {
		
		List<String>cates = List.of("취미","학습","봉사","건강","비지니스","문화","스포츠","기타");
		List<CateSeleteWapper> list = new ArrayList<>();
		
		
		if(cate != null) {
			for(String s : cates) {
				CateSeleteWapper wapper = new CateSeleteWapper();
				wapper.setCate(s);
				for(String c : cate) {
					if(c.equals(s)) {
						wapper.setCate(s.equals(c));
						break;
					}
				}
				list.add(wapper);
			}
		}else {
			for(String s : cates) {
				CateSeleteWapper wapper = new CateSeleteWapper(s, false);
				list.add(wapper);
			}
		}
		
		return list;
	}
}
