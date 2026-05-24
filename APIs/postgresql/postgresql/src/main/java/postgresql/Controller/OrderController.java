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

import postgresql.Model.Order;
import postgresql.Service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class OrderController {

    @Autowired
	private OrderService service;

	@GetMapping
	public List<Order> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		try {
			Order order = service.getById(id);
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("ID not found", HttpStatus.NOT_FOUND);
	    }
	}

	@PostMapping
	public ResponseEntity<?> post() {
		try {
			Order newOrder = new Order();
			service.save(newOrder);
			return new ResponseEntity<Order>(newOrder, HttpStatus.CREATED);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("Error on post", HttpStatus.NOT_IMPLEMENTED);
	    }
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Order auxOrder = service.getById(id);
			auxOrder.setDate();
			service.save(auxOrder);
			return new ResponseEntity<String>("Updated", HttpStatus.ACCEPTED);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("Error on put", HttpStatus.NOT_MODIFIED);
	    }
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			service.delete(id);
			return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("Error on delete", HttpStatus.NOT_ACCEPTABLE);
	    }
	}   
}