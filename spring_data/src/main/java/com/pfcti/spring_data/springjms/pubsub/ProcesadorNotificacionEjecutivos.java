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
public class ProcesadorNotificacionEjecutivos {

    @ServiceActivator(inputChannel = "pubSubNotification")
    public Message<String> consumirMensajeParaEnvioFormatoEjecutivos(Message<CuentaDTO> message){
        CuentaDTO cuentaDto = message.getPayload();
        log.info("consumirMensajeParaEnvioFormatoEjecutivos");
        // Puede tener la logica que necesitemos
        // Envio SMS con formato a Cliente
        return MessageBuilder.withPayload("Mensaje recibido por ProcesadorNotificacionEjecutivos")
                .build();
    }
}
