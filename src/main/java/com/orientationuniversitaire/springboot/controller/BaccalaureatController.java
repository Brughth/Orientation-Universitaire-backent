package com.orientationuniversitaire.springboot.controller;

import com.orientationuniversitaire.springboot.entity.Baccalaureats;
import com.orientationuniversitaire.springboot.exception.ResourceNotFoundException;
import com.orientationuniversitaire.springboot.repository.BaccalaureatRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/baccalaureats")
public class BaccalaureatController {


    @Autowired
    private BaccalaureatRepository baccalaureatRepository;

    // get all baccs
    @GetMapping
    public List<Baccalaureats> getAllBaccalaureats() {
        return this.baccalaureatRepository.findAll();
    }

    // get bac by id
    @GetMapping("/{id}")
    public Baccalaureats getBaccalaureatById(@PathVariable(value = "id") int bacId){
        return this.baccalaureatRepository.findById(bacId)
            .orElseThrow(() -> new ResourceNotFoundException("Baccalaureat not found with id: " + bacId));
    }

    // create bac
    
    @PostMapping
    public Baccalaureats createBaccalaureat(@RequestBody Baccalaureats baccalaureats){
        return this.baccalaureatRepository.save(baccalaureats);
    }

    // update bac
    @PutMapping("/{id}")
    public Baccalaureats updateBaccalaureat(@RequestBody Baccalaureats baccalaureats, @PathVariable("id") int bacId){

        Baccalaureats existingBacc = this.baccalaureatRepository.findById(bacId)
        .orElseThrow(() -> new ResourceNotFoundException("Baccalaureat not found with id: " + bacId));

        existingBacc.setNom(baccalaureats.getNom());
        existingBacc.setDescription(baccalaureats.getDescription());

        return this.baccalaureatRepository.save(existingBacc);
        
    }

    // delete bac by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Baccalaureats> deleteBaccalaureat(@PathVariable("id") int bacId){

        Baccalaureats existingBacc = this.baccalaureatRepository.findById(bacId)
            .orElseThrow(() -> new ResourceNotFoundException("Baccalaureat not found with id: " + bacId));

        this.baccalaureatRepository.delete(existingBacc);

        return  ResponseEntity.ok().build();

    }
}
