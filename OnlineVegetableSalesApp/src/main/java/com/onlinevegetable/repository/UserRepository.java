package com.onlinevegetable.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.onlinevegetable.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{
	@Query("SELECT DISTINCT p FROM User p WHERE p.emailId=?1")
	public User getUserByEmail(String email);

}
