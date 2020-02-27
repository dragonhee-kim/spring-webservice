package com.chuno.found.lostService;

import com.chuno.found.findService.Find;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LostRepository extends JpaRepository<Lost,Long> {

    List<Lost> findByCategory(String category);
}
