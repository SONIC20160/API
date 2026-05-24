package postgresql.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import postgresql.Model.OrderProduct;
import postgresql.Repository.OrderProductRepository;

@Service
@Transactional
public class OrderProductService {

    @Autowired
	private OrderProductRepository repo;

	public List<OrderProduct> getAll(){return repo.findAll();}

	public void save(OrderProduct order){repo.save(order);}

	public OrderProduct getById(Integer id){return repo.findById(id).get();}

	public void delete(Integer id){repo.deleteById(id);}
}