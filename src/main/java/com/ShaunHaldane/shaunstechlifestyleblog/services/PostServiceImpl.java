package com.ShaunHaldane.shaunstechlifestyleblog.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Post;
import com.ShaunHaldane.shaunstechlifestyleblog.repositories.PostRepository;

@Service
@Transactional
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> getAll() {
		return postRepository.findAll();
	}

	@Override
	public Post getById(int id) {
		return postRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Post post) {
		postRepository.save(post);
	}

	@Override
	public void delete(int id) {
		postRepository.deleteById(id);
	}

	@Override
	public Post getByIdWithComments(int id) {
		return postRepository.getByIdWithComments(id);
	}
}

