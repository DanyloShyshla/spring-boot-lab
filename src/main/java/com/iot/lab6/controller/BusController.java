package com.iot.lab6.controller;

import com.iot.lab6.exception.ResourceNotFoundException;
import com.iot.lab6.model.Bus;
import com.iot.lab6.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BusController {

    @Autowired
    private BusRepository busRepository;

    @GetMapping("/buses")
    public List<Bus> getAll() {
        return busRepository.findAll();
    }

    @GetMapping("/bus/{id}")
    public Bus getById(@PathVariable(value = "id") Integer bus_id) {
        return busRepository.findById(bus_id).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", bus_id));
    }

    @PostMapping("/bus")
    public Bus createBus(@Valid @RequestBody Bus bus) {
        return busRepository.save(bus);
    }

    @PutMapping("/bus/{id}")
    public Bus updateBus(@PathVariable(value = "id") Integer bus_id, @Valid @RequestBody Bus busDetails) {
        Bus bus = busRepository.findById(bus_id).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", bus_id));
        
        bus.setNumber(busDetails.getNumber());
        bus.setMileage(busDetails.getMileage());
        bus.setProductionYear(busDetails.getProductionYear());
        bus.setIsOnTheRoute(busDetails.getIsOnTheRoute());
        bus.setModelModelId(busDetails.getModelModelId());

        Bus updateBus = busRepository.save(bus);
        return updateBus;
    }

    @DeleteMapping("/bus/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer bus_id) {
        Bus bus = busRepository.findById(bus_id).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", bus_id));

        busRepository.delete(bus);

        return ResponseEntity.ok().build();
    }

}

