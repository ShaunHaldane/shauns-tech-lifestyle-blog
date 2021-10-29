package com.ShaunHaldane.shaunstechlifestyleblog.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Comment;
import com.ShaunHaldane.shaunstechlifestyleblog.models.Post;
import com.ShaunHaldane.shaunstechlifestyleblog.services.CommentService;
import com.ShaunHaldane.shaunstechlifestyleblog.services.PostService;

@Controller
public class CommentController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/addComment/{postId}")
	public String showCommentForm(@PathVariable int postId, Model model, Principal principal) {
		Post post = postService.getById(postId);
		if(post != null) {
			model.addAttribute("post", post);
			Comment comment = new Comment();
			comment.setPost(post);
			model.addAttribute("comment", comment);
			return "add-comment";
		}
		return "redirect:/";
	}
	
	@PostMapping("/processCommentForm")
	public String addCommentData(@ModelAttribute Comment comment, Principal principal) {
		commentService.save(comment, principal.getName());
		return "redirect:/";
	}
	
}
