package com.onlinevegetable.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinevegetable.model.Order_Class;
import com.onlinevegetable.repository.Order_interface;
@Service
public class OrderService
{
	@Autowired
	private Order_interface order_rep;
	public List<Order_Class> getAllOrder()
	{
		return order_rep.findAll();
	}
	public Order_Class findOrderById(Integer id) 
	{
		return order_rep.findById(id).orElseThrow();	
	}
	
	public Order_Class saveNewOrder(Order_Class order) 
	{
		return order_rep.save(order);
	
	}
	public void deleteOrder(Integer id) 
	{
		order_rep.deleteById(id);
	}

}
