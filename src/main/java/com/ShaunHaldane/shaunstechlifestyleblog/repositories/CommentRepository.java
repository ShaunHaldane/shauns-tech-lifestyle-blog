package com.ShaunHaldane.shaunstechlifestyleblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
