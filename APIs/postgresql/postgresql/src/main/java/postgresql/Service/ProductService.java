package postgresql.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import postgresql.Model.Product;
import postgresql.Repository.ProductRepository;

@Service
@Transactional
public class ProductService {

    @Autowired
	private ProductRepository repo;

	public List<Product> getAll(){return repo.findAll();}

	public void save(Product product){repo.save(product);}

	public Product getById(Integer id){return repo.findById(id).get();}

	public void delete(Integer id){repo.deleteById(id);}
}