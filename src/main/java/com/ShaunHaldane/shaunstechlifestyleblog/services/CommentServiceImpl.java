package com.ShaunHaldane.shaunstechlifestyleblog.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Comment;
import com.ShaunHaldane.shaunstechlifestyleblog.repositories.CommentRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public void save(Comment comment, String username) {
		comment.setUsername(username);
		commentRepository.save(comment);
	}

}
