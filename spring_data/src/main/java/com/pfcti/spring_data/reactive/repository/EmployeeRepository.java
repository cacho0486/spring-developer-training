package com.pfcti.spring_data.reactive.repository;
import com.pfcti.spring_data.reactive.model.Employee;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer>{
    @Query("{'name':  ?0}")
    Flux<Employee> findByName(final String name);
}
