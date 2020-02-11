package com.chuno.found;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoundController {

    @Autowired
    private FoundRepository foundRepository;

    @GetMapping("/")
    public String home(){



        return "home";
    }

    @GetMapping("/find")
    public List<Found> getFoundAll(){

        System.out.println(this.foundRepository.findAll());

        return this.foundRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Found> getFoundById(@PathVariable Long id){

        System.out.println(this.foundRepository.findById(id));

        return this.foundRepository.findById(id);
    }

    @PostMapping("/find")
    public void postFound(@RequestBody FoundDto dto){
        System.out.println("ho");
        System.out.println(dto);
        System.out.println(dto.toEntity());
        System.out.println(dto.getFound_name());
        System.out.println(dto.getFound_content());

        System.out.println("h2");

        this.foundRepository.save(dto.toEntity());
    }

}
