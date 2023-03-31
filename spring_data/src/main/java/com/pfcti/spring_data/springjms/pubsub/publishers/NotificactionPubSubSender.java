package com.pfcti.spring_data.springjms.pubsub.publishers;

import com.pfcti.spring_data.dto.CuentaDTO;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface NotificactionPubSubSender {
    @Gateway(requestChannel = "pubSubNotification")
    Message<String> sendNotificaction(Message<CuentaDTO> messege);
}
