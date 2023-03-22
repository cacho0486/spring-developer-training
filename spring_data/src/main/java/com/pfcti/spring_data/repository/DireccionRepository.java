package com.pfcti.spring_data.repository;
import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion,Integer> {

    void deleteAllByCliente_Id(int clientId);
}