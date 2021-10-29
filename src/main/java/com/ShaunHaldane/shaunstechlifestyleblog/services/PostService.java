package com.ShaunHaldane.shaunstechlifestyleblog.services;

import java.util.List;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Post;

public interface PostService {

	public List<Post> getAll();
	
	public Post getById(int id);
	
	public void saveOrUpdate(Post post);
	
	public void delete(int id);
	
	public Post getByIdWithComments(int id);
	
}
