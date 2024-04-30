package example1.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import example1.example.model.Model;


public interface Repository extends JpaRepository<Model,Integer>
{
    Optional<Model> findById(int id);
}
