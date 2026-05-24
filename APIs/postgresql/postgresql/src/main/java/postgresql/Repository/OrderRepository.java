package postgresql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import postgresql.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{}