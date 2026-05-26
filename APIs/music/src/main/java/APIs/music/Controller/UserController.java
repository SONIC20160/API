package APIs.music.Controller;

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

import APIs.music.Model.User;
import APIs.music.DTO.UserDTO;
import APIs.music.Service.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class UserController {

    @Autowired
	private UserService service;

	@GetMapping
	public List<User> getAll(){return service.getAll();}

	@GetMapping("{username}")
	public ResponseEntity<?> getByUsername(@PathVariable String username) {
		try {
			User user = service.getByUsername(username);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
	    }
	}

	@PostMapping("/login")
	public ResponseEntity<?> getById(@RequestBody UserDTO dto) {
		try {
			User user = service.getByUsername(dto.getUsername());
			if(dto.getPassword().compareTo(user.getPassword()) == 0){
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}

	@PostMapping
	public ResponseEntity<?> post(@RequestBody User user) {
		try {
			service.save(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	    }
	}

	@PutMapping("{username}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable String username) {
		try {
			User auxUser = service.getByUsername(username);
			user.setUsername(auxUser.getUsername());
			service.save(user);
			return new ResponseEntity<String>("Updated", HttpStatus.ACCEPTED);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("Username not found", HttpStatus.NOT_FOUND);
	    }
	}

	@DeleteMapping("{username}")
	public ResponseEntity<?> delete(@PathVariable String username) {
		User user = service.getByUsername(username);
		service.delete(user.getID());
		return new ResponseEntity<User>(HttpStatus.ACCEPTED);
	}
    
}