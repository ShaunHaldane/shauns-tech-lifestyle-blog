package com.ShaunHaldane.shaunstechlifestyleblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
