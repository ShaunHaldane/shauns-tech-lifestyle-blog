package com.ShaunHaldane.shaunstechlifestyleblog.services;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Comment;

public interface CommentService {

	public void save(Comment comment, String username);
	
}
