package postgresql.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import postgresql.Model.Product;
import postgresql.Service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ProductController {

    @Autowired
	private ProductService service;

	@GetMapping
	public List<Product> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		try {
			Product product = service.getById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("ID not found", HttpStatus.NOT_FOUND);
	    }
	}

	@PostMapping
	public ResponseEntity<?> post(@RequestBody Product product) {
		try {
			service.save(product);
			return new ResponseEntity<Product>(product, HttpStatus.CREATED);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("Error on post", HttpStatus.NOT_IMPLEMENTED);
	    }
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		try {
			Product auxProduct = service.getById(id);
			product.setId(auxProduct.getId());
			service.save(product);
			return new ResponseEntity<String>("Updated", HttpStatus.ACCEPTED);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("Error on put", HttpStatus.NOT_MODIFIED);
	    }
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			service.delete(id);
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("Error on delete", HttpStatus.NOT_ACCEPTABLE);
	    }
	}   
}