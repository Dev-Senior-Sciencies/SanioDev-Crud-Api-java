package com.crud.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.model.Vehicles;
import com.crud.api.repository.VehiclesRepository;

@RestController
@RequestMapping("/veiculos")
public class VehiclesController {
	
	@Autowired
	private VehiclesRepository vehiclesRepository;
	
	@GetMapping
	public List<Vehicles> listar() {
		return vehiclesRepository.findAll();
	}
	
	
	@PostMapping
	public Vehicles adicion(@RequestBody Vehicles vehicles) {
		return vehiclesRepository.save(vehicles);
		
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Vehicles> findById(@PathVariable Long id){
		return vehiclesRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Vehicles> update(@PathVariable("id") Long id, @RequestBody Vehicles vehicles){
		
		return vehiclesRepository.findById(id)
				.map(record -> {
					record.setNome(vehicles.getNome());
					record.setPlaca(vehicles.getPlaca());
					record.setMarca_name(vehicles.getMarca_name());
					record.setMarca_Id(vehicles.getMarca_Id());
					Vehicles updated = vehiclesRepository.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return vehiclesRepository.findById(id)
				.map(record -> {
					vehiclesRepository.deleteById(id);
					return ResponseEntity.ok().body("Foi removido o Veiculo do Id " + id);
				}).orElse(ResponseEntity.notFound().build());
	}
}
