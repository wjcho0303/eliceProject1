package com.crud_project.elice.user.repository;
import com.crud_project.elice.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
