package APIs.music.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import APIs.music.Model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    public User getByUsername(String username);
}