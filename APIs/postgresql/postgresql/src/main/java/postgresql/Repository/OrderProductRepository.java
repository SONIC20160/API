package postgresql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import postgresql.Model.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer>{}