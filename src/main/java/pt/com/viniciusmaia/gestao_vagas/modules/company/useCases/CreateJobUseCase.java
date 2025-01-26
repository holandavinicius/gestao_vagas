package pt.com.viniciusmaia.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.com.viniciusmaia.gestao_vagas.exceptions.JobFoundException;
import pt.com.viniciusmaia.gestao_vagas.modules.company.entities.JobEntity;
import pt.com.viniciusmaia.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
    
    @Autowired
    JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity){   
        this.jobRepository.findByDescriptionAndLevel(jobEntity.getDescription(), jobEntity.getLevel())
                .ifPresent((job) -> {
                    throw new JobFoundException();
                });
        return this.jobRepository.save(jobEntity);
    }
}
