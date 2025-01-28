package com.onlinevegetable.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.onlinevegetable.model.Order_Class;
import com.onlinevegetable.model.User;
import com.onlinevegetable.model.VegetableDTO;
import com.onlinevegetable.repository.service.OrderService;
import com.onlinevegetable.repository.service.UserService;
import com.onlinevegetable.repository.service.VegetableService;
import jakarta.servlet.http.HttpSession;
@Controller
public class OrderController 
{

@Autowired
private OrderService orderSer;
@Autowired
private VegetableService vegService;
@Autowired
private UserService userSe;

@GetMapping("/order/{id}")
public String OrderPage(Model model, @PathVariable Integer id, HttpSession session) 
{
	model.addAttribute("vegOrder", vegService.getVegtableById(id));
	session.setAttribute("vnm", vegService.getVegtableById(id).getName());
	session.setAttribute("pri", vegService.getVegtableById(id).getPrice());
	model.addAttribute("getAllUser", userSe.getAllUsers());
	session.setAttribute("vegId", id);
	return "orderPage";
}

@GetMapping("/order/doneOrder")
public String getMapping(Order_Class order,@RequestParam("quantity") Integer qun,Model model, User user, HttpSession session) 
{
    order.setOrID(user.getUserId());
    order.setVegetable((String)session.getAttribute("vnm"));
	order.setTotalAmount(qun*(double)session.getAttribute("pri"));
	order.setQuantity(qun);
	order.setCustomerId((int)(session.getAttribute("user")));
	orderSer.saveNewOrder(order);
	model.addAttribute("us",session.getAttribute("userName"));
	model.addAttribute("billOrder", order);
	int id=(int)session.getAttribute("vegId");
	update(id, order.getOrID());
	return "billPage";	
}

public void update(Integer id,Integer idd) 
{
	VegetableDTO veg=vegService.getVegtableById(id);
	Order_Class o=orderSer.findOrderById(idd);
	veg.setQuantity(veg.getQuantity()-o.getQuantity());
	vegService.saveVegetable(veg);
}

@GetMapping("/backToAllStock")
public String backToViewAllStock() 
{
	return "redirect:/viewAllStock";	
}



}
