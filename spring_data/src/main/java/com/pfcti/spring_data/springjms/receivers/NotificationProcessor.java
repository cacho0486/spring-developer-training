package com.pfcti.spring_data.springjms.receivers;

import com.pfcti.spring_data.springjms.DTO.NoticationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationProcessor {

    @JmsListener(destination ="smsReceiverJms")// va a representar el nombre de la cola que recibe
    public void processMessage(NoticationDto noticationDto){
        //Logica de enevio de SMS
        log.info("sms info: {}", noticationDto);
    }
}
