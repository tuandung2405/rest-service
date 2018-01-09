package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	private List<Order> orders;
	
	OrderController() {
		orders = this.buildOrders();
	}
	
	@RequestMapping(value="order/{id}", method=RequestMethod.GET)
	public Order findOrderById(@PathVariable("id")Integer id) {
    	return this.orders.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(value="order", method=RequestMethod.GET)
	public List<Order> findAll() {
    	return this.orders;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Order createOrder(@RequestBody Order order) {
		Integer nextId = 0;
		if(this.orders.isEmpty()) {
			Order lastOrder = this.orders.stream().skip(this.orders.size() - 1).findFirst().orElse(null);
			nextId = lastOrder.getId() + 1;
		}
		order.setId(nextId);
		return order;
	}
    
	@RequestMapping(method=RequestMethod.PUT)
	public Order updateOrder(@RequestBody Order order) {
		Order modifiedOrder = this.orders.stream().filter(o -> order.getId() == order.getId()).findFirst().orElse(null);
		modifiedOrder.setCreatedDay(order.getCreatedDay());
		modifiedOrder.setCreater(order.getCreater());
		return modifiedOrder;
	}
	
	@RequestMapping(value="order/{id}",method=RequestMethod.DELETE)
	public boolean deleteOrderById(@RequestBody Integer _id) {
		Order deleteOrder = this.orders.stream().filter(o -> o.getId() == _id).findFirst().orElse(null);
		if(deleteOrder != null) {
			this.orders.remove(deleteOrder);
			return true;
		} else {
			return false;
		}
	}
	
	List<Order> buildOrders() {
		List<Order> orders = new ArrayList<>();
		
		Order order1 = buildOrder(1, "Wind Sarm", "20171206");
		Order order2 = buildOrder(2, "Kieu Em", "20171206");
		Order order3 = buildOrder(3, "Cobba", "20171206");
		Order order4 = buildOrder(4, "Cong Danh", "20171206");

		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		
		return orders;
	}
    
	Order buildOrder(int _id, String creater, String createdDate) {
		Order order = new Order();
		order.setId(_id);
		order.setCreater(creater);
		order.setCreatedDay(createdDate);
		return order;
	}
}
