package com.ShaunHaldane.shaunstechlifestyleblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	@Query("from Post p left join fetch p.comments where p.id = :id")
	public Post getByIdWithComments(@Param("id") int id);

}
