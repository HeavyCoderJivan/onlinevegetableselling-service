package com.onlinevegetable.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.onlinevegetable.model.VegetableDTO;
import com.onlinevegetable.service.VegetableService;
@Controller
public class VegController
{
	
@Autowired
private VegetableService vegSer;

@GetMapping("/insert")
public String insertVegetable(Model model) 
{
	model.addAttribute("addVeg", new VegetableDTO());
	return "addStock";
}
@PostMapping("/saveveg")
public String insetNewStock(@ModelAttribute VegetableDTO v ) 
{
	vegSer.saveVegetable(v);
	return "redirect:/showAllStock";
}

@GetMapping("/showAllStock")
public String showAllVeg(Model model) 
{
	List<VegetableDTO> vegList=vegSer.getAllVegetables();
	model.addAttribute("vegList", vegList);
	return "VegetablePage";	
}

@GetMapping("/updateVeg/{id}")
public String updatePage(@PathVariable Integer id,Model model) 
{
	VegetableDTO veg=vegSer.getVegtableById(id);
	model.addAttribute("vegObj", veg);
	return "Updateveg";	
}

@PostMapping("/updateVeg/saveVeg/{idd}")
public String saveUpdatedVeg(@ModelAttribute("vegObj") VegetableDTO veg,@PathVariable Integer idd) 
{
	VegetableDTO v=  vegSer.getVegtableById(idd);
    veg.setQuantity(veg.getQuantity()+v.getQuantity());
    vegSer.saveVegetable(veg);
  return "redirect:/showAllStock";	
}


@GetMapping("/deleteVeg/{id}")
public String deleteVeg(@PathVariable Integer id) 
{
	vegSer.deleteVegById(id);
	return "redirect:/showAllStock";
}



@GetMapping("/viewAllStock")
public String vieALLVegetable(Model model) 
{
	model.addAttribute("vegListAwa", vegSer.getAllVegetables());
	return "vegetablePage2";	
}








}
