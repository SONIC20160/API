package postgresql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import postgresql.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{}