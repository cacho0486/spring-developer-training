package com.pfcti.spring_data.springjms.pubsub;

import com.pfcti.spring_data.dto.CuentaDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ProcesadorNotificacionClientes {

    @ServiceActivator(inputChannel = "pubSubNotification")
    public Message<String> consumirMensajeParaEnvioFormatoCliente(Message<CuentaDTO> message){
        CuentaDTO cuentaDTO = message.getPayload();
        log.info(("consumirMensajeParaEnvionotificaciones"));
        return MessageBuilder.withPayload("Mensaje recibido por ProcesadorNotificacionClientes")
                .build();
    }

}
