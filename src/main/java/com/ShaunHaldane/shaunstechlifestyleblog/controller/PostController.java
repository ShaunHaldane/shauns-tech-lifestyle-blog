package com.ShaunHaldane.shaunstechlifestyleblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Post;
import com.ShaunHaldane.shaunstechlifestyleblog.services.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;

	@GetMapping("/addPost")
	public String showPostForm(Model model) {
		model.addAttribute("post", new Post());
		return "add-post";
	}
	
	@PostMapping("/processPostForm")
	public String showPostData(@ModelAttribute Post post, BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			return "add-post";
//		}
		postService.saveOrUpdate(post);
		return "redirect:/";
	}
	
	@GetMapping("/deletePost/{id}")
	public String deletePost(@PathVariable int id) {
		Post post = postService.getById(id);
		if(post != null) {
			postService.delete(id);
		}
		return "redirect:/";
	}
	
	@GetMapping("/editPost/{id}")
	public String editPost(@PathVariable int id, Model model) {
		Post post = postService.getById(id);
		if(post != null) {
			model.addAttribute("post", post);
			return "add-post";
		}
		return "redirect:/";
	}
	
	@GetMapping("/post/{id}")
	public String getArticle(@PathVariable int id, Model model) {
		Post post = postService.getById(id);
		if(post != null) {
			model.addAttribute("post", post);
			return "post";
		}
		return "redirect:/";
	}
}




