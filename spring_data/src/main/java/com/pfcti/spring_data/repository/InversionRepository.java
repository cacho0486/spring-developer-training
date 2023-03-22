package com.pfcti.spring_data.repository;
import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.model.Inversion;
import com.pfcti.spring_data.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InversionRepository extends JpaRepository<Inversion,Integer> {

    void deleteAllByCliente_Id(int clientId);

    List<Inversion> findInversionsByCliente_IdAndEstadoIsTrue(int clientId);
}

