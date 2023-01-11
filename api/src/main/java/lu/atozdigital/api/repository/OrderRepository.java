package lu.atozdigital.api.repository;

import lu.atozdigital.api.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
