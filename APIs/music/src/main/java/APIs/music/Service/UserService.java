package APIs.music.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import APIs.music.Model.User;
import APIs.music.Repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
	private UserRepository repo;

	public List<User> getAll(){return repo.findAll();}

	public void save(User user){repo.save(user);}

	public User getByID(Integer id){return repo.findById(id).get();}

	public void delete(Integer id){repo.deleteById(id);}

	public User getByUsername(String username){
		User user = repo.getByUsername(username);
		if(user == null){
			throw new NoSuchElementException();
		}
		return user;
	}
}