package com.github.diinisalma.bioskop.repository;

import com.github.diinisalma.bioskop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
