package com.iot.lab6.controller;

import com.iot.lab6.exception.ResourceNotFoundException;
import com.iot.lab6.model.Model;
import com.iot.lab6.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ModelController {

    @Autowired
    private ModelRepository modelRepository;

    @GetMapping("/models")
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @GetMapping("/model/{id}")
    public Model getById(@PathVariable(value = "id") Integer model_id) {
        return modelRepository.findById(model_id).orElseThrow(() -> new ResourceNotFoundException("Model", "id", model_id));
    }

    @PostMapping("/model")
    public Model createModel(@Valid @RequestBody Model model) {
        return modelRepository.save(model);
    }

    @PutMapping("/model/{id}")
    public Model updateModel(@PathVariable(value = "id") Integer model_id, @Valid @RequestBody Model modelDetails) {
        Model model = modelRepository.findById(model_id).orElseThrow(() -> new ResourceNotFoundException("Model", "id", model_id));

        model.setModel(modelDetails.getModel());
        model.setName(modelDetails.getName());
        model.setSeats(modelDetails.getSeats());

        Model updateModel = modelRepository.save(model);
        return updateModel;
    }

    @DeleteMapping("/model/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer model_id) {
        Model model = modelRepository.findById(model_id).orElseThrow(() -> new ResourceNotFoundException("Model", "id", model_id));

        modelRepository.delete(model);

        return ResponseEntity.ok().build();
    }
}
