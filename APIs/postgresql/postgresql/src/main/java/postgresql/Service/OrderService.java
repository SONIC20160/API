package postgresql.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import postgresql.Model.Order;
import postgresql.Repository.OrderRepository;

@Service
@Transactional
public class OrderService {

    @Autowired
	private OrderRepository repo;

	public List<Order> getAll(){return repo.findAll();}

	public void save(Order order){repo.save(order);}

	public Order getById(Integer id){return repo.findById(id).get();}

	public void delete(Integer id){repo.deleteById(id);}
}