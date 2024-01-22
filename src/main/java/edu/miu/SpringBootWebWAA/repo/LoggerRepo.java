package edu.miu.SpringBootWebWAA.repo;

import edu.miu.SpringBootWebWAA.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger, Integer> {
}
