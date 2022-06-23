package org.song.myapp.controller;

import org.song.myapp.model.DiaryDTO;
import org.song.myapp.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/diary/*")
@Log4j
public class DiaryController {
// bean 가져오는 어노테이션
	// bean에 만들어진 service 불러온거래요
	@Setter(onMethod_=@Autowired)
	private DiaryService service;
	// 위 2개 ㅓ노테이션은 세트래요!
	
	@GetMapping("/list")
	public String selectAll(Model model) {
		model.addAttribute("list", service.selectAll());
		return "list";
	}
	
	@GetMapping("/detail")
	public String selectOne(Model model, @RequestParam("no") int no) {
		model.addAttribute("diary", service.selectOne(no));
		return "detail";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("/insert")
	public String insert(@RequestParam("title") String title,
			@RequestParam("writer") String writer,
			@RequestParam("content") String content) {
		service.insert(new DiaryDTO(0, title, writer, content, ""));
		return "redirect:list";
	}
	
	@GetMapping("/delete")
		public String delete(@RequestParam("no") int no) {
		service.delete(no);
		return "redirect:list";
	}

	@GetMapping("/update")
	public String update(Model model, @RequestParam("no") int no) {
		model.addAttribute("detail", service.selectOne(no));
		return "update";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("title") String title, 
			@RequestParam("content") String content, 
			@RequestParam("no") int no) {
		service.update(new DiaryDTO(no, title, "", content, ""));
		return "detail?no="+no;
	}
	
} // class
