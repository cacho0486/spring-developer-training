package com.pfcti.spring_data.service;
import com.pfcti.spring_data.criteria.CuentaSpecification;
import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.model.Cuenta;
import com.pfcti.spring_data.repository.*;
import com.pfcti.spring_data.springjms.DTO.NoticationDto;
import com.pfcti.spring_data.springjms.pubsub.publishers.NotificactionPubSubSender;
import com.pfcti.spring_data.springjms.senders.NoticationSender;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    private NoticationSender noticationSender;

    private NotificactionPubSubSender notificationPubSubSender;

    public List<CuentaDTO> buscarCuentasDinamicamentePorCriterio(CuentaDTO cuentaDtoFilter){
        return cuentaRepository.findAll(cuentaSpecification.buildFilter(cuentaDtoFilter))
                .stream().map(this::fromCuentaToDto).collect(Collectors.toList());
    }

    private CuentaDTO fromCuentaToDto(Cuenta cuenta){
        CuentaDTO cuentaDTO = new CuentaDTO();
        BeanUtils.copyProperties(cuenta, cuentaDTO);
        return cuentaDTO;
    }

    private void enviarNotification(CuentaDTO cuentaDTO){
        NoticationDto noticationDto= new NoticationDto();
        ClienteDTO clienteDTO= clienteService.obtenerCliente(cuentaDTO.getClient_id());
        noticationDto.setPhoneNumber(clienteDTO.getTelefono());
        noticationDto.setMailBody("Estimado " + clienteDTO.getNombre() + "tu cuenta fue creada");
        noticationSender.sendSms(noticationDto);
        Message<CuentaDTO> message = MessageBuilder.withPayload(cuentaDTO).build();
        notificationPubSubSender.sendNotificaction(message);
    }

    public void insertarCuenta(CuentaDTO cuentaDTO){
        Cuenta cuenta = new Cuenta();
        cuenta.setNumero(cuentaDTO.getNumero());
        cuenta.setTipo(cuentaDTO.getTipo());
        cuenta.setEstado(cuentaDTO.getEstado());
        cuentaRepository.save(cuenta);
        this.enviarNotification((cuentaDTO));
    }
/*
    public void insertaCuenta(CuentaDTO cuentaDto) {
        Cuenta cuenta = new Cuenta();

        Cliente cliente = clienteRepository.findById(1);

        cuenta.setCliente(cliente);

        cuenta.setTipo(cuentaDto.getTipo());
        cuenta.setNumero(cuentaDto.getNumero());
        cuenta.setEstado(cuentaDto.getEstado());

        cuentaRepository.save(cuenta);*/


    public List<CuentaDTO> buscarCuentasPorCliente(int idCliente) {
        List<CuentaDTO> cuentasPorCliente = new ArrayList<>();
        cuentaRepository.findCuentasByCliente_IdAndEstadoIsTrue(idCliente)
                .stream()
                .map(cuenta -> {
                    cuentasPorCliente.add(fromCuentaToDto(cuenta));
                    log.info("Cuenta de Cliente :{}", cuenta);
                    return cuenta;}
                ).collect(Collectors.toList());
        return cuentasPorCliente;
    }

    public void actualizarCuenta(CuentaDTO cuentaDTO){
        Cuenta cuenta = new Cuenta();
        cuenta.setId(cuentaDTO.getId());
        cuenta.setNumero(cuentaDTO.getNumero());
        cuenta.setTipo(cuentaDTO.getTipo());
        cuenta.setEstado(cuentaDTO.getEstado());
        cuentaRepository.save(cuenta);
    }

    public CuentaDTO obtenerCuenta(int id){
        CuentaDTO cuentaDTO = new CuentaDTO();
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(() -> {throw new RuntimeException("Cuenta no existe");});
        cuentaDTO.setId(cuenta.getId());
        cuentaDTO.setEstado(cuenta.getEstado());
        cuentaDTO.setTipo(cuenta.getTipo());
        cuentaDTO.setNumero(cuenta.getNumero());
        return cuentaDTO;
    }

    public void desactivarCuentasPorCliente_id(Integer id){
        List<Cuenta> cuentasPorCliente = new ArrayList<>();
        cuentasPorCliente = cuentaRepository.findCuentasByCliente_IdAndEstadoIsTrue(id);
        cuentasPorCliente.forEach(cuenta -> {
            cuenta.setEstado(false);
            cuentaRepository.save(cuenta);
        });
    }

    public CuentaDTO desactivarCuentaPorId(CuentaDTO cuentaDto){
        Cuenta cuenta = cuentaRepository.findById(cuentaDto.getId()).orElseThrow(() -> {throw new RuntimeException("cuenta de Cliente No Existe");});
        cuenta.setEstado(false);
        cuentaRepository.save(cuenta);

        return fromCuentaToDto(cuenta);
    }
}