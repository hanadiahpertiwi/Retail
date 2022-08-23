package com.ERetail.repository;

import com.ERetail.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUsersRepository extends JpaRepository<AppUsers, Long> {
   public AppUsers findByUsername(String username);
}
