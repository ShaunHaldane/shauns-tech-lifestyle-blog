package com.ShaunHaldane.shaunstechlifestyleblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Post;
import com.ShaunHaldane.shaunstechlifestyleblog.services.PostService;

@Controller
public class HomeController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public String getPosts(Model model) {
		List<Post> posts = postService.getAll();
		model.addAttribute("posts", posts);
		return "home";
	}
	
	@GetMapping("/privacyPolicy")
	public String getPrivacyPolicy() {
		return "privacy-policy";
	}
	
	@GetMapping("/about")
	public String getAbout() {
		return "about";
	}

}
