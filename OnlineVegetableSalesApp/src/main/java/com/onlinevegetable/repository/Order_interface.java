package com.onlinevegetable.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlinevegetable.model.Order_Class;
@Repository
public interface Order_interface extends JpaRepository<Order_Class, Integer>
{

}
