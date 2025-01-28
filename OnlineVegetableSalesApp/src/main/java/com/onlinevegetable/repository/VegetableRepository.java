package com.onlinevegetable.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinevegetable.model.VegetableDTO;
@Repository
public interface VegetableRepository extends JpaRepository<VegetableDTO, Integer> 
{

}
