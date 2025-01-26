package pt.com.viniciusmaia.gestao_vagas.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.com.viniciusmaia.gestao_vagas.modules.company.entities.JobEntity;

public interface JobRepository extends  JpaRepository<JobEntity, UUID> {
    Optional<JobEntity> findByDescriptionAndLevel(String description, String level);
}
