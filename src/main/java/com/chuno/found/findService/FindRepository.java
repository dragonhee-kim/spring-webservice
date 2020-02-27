package com.chuno.found.findService;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FindRepository extends JpaRepository<Find, Long> {

    List<Find> findByCategory(String category);

}
