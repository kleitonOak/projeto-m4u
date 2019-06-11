package com.m4u.kleiton.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.m4u.kleiton.exception.RestfulResponseErrorHandler;

@Component
public class SmsServiceClientImpl implements SmsServiceClient{
	@Value("${urlsmsservice}")
	private String urlSmsService;
	
	@Override
	public String enviarMensagem(SmsClientDTO sms) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<SmsClientDTO> smsRequest = new HttpEntity<>(sms, headers);

			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setErrorHandler(new RestfulResponseErrorHandler());
			restTemplate.exchange(urlSmsService, HttpMethod.PUT, smsRequest, Object.class);
			return "Mensagem Enviada";
	}

}
