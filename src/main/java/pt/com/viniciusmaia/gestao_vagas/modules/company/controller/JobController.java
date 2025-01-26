package pt.com.viniciusmaia.gestao_vagas.modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pt.com.viniciusmaia.gestao_vagas.exceptions.JobFoundException;
import pt.com.viniciusmaia.gestao_vagas.modules.company.entities.JobEntity;
import pt.com.viniciusmaia.gestao_vagas.modules.company.useCases.CreateJobUseCase;

@RestController
@RequestMapping("/job")
public class JobController {
    
    @Autowired
    CreateJobUseCase createJobUseCase;

    public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity) {
        try {
            var result = this.createJobUseCase.execute(jobEntity);
            return ResponseEntity.ok().body(result);
        } catch (JobFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
