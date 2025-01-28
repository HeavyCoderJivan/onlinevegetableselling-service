package com.onlinevegetable.repository.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinevegetable.model.VegetableDTO;
import com.onlinevegetable.repository.VegetableRepository;
@Service
public class VegetableService 
{
@Autowired
private VegetableRepository vegRepo;
public List<VegetableDTO> getAllVegetables()
{
	return vegRepo.findAll();
}

public VegetableDTO getVegtableById(Integer id) 
{
	return vegRepo.findById(id).orElseThrow();	
}

public VegetableDTO saveVegetable(VegetableDTO veg) 
{
	return vegRepo.save(veg);	
}

public void deleteVegById(Integer id) 
{
	vegRepo.deleteById(id);	
}

}
