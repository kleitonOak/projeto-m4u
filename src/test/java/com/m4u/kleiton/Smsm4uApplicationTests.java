package com.m4u.kleiton;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.m4u.kleiton.client.SmsServiceClient;
import com.m4u.kleiton.controller.SmsController;
import com.m4u.kleiton.entity.SmsEntity;
import com.m4u.kleiton.exception.BusinessException;
import com.m4u.kleiton.service.SmsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Smsm4uApplicationTests {
	//@Value("${urlsmsservice}")
	private String urlSmsService;
	
	@MockBean
	SmsServiceClient serviceClient;

	@MockBean
	SmsService service;

	@Autowired
	SmsController smsController;
	
	@Autowired
	SmsService smsService;

//	@Test
//	public void enviarSms() {
//		Long id = 1L;
//		Long from = 21998845885L;
//		Long to = 21998845886L;
//		String body = "oi";
//		Date date = new Date();
//		SmsEntity sms = new SmsEntity(id, from, to, body, date);
//
//		given(this.service.enviarSms(sms)).willReturn("Mensagem Enviada");
//		ResponseEntity<String> retorno = smsController.enviarSms(id, from, to, body, date);
//
//		assertThat(retorno.toString()).isEqualTo("<201 Created,Mensagem Enviada,{}>");
//	}
//
//	@Test
//	public void enviarSms2() {
//		Long id = 1L;
//		Long from = 21998845885L;
//		Long to = 21998845886L;
//		String body = "oi";
//		Date date = new Date();
//		SmsEntity sms = new SmsEntity(id, from, to, body, date);
//
//		given(this.service.enviarSms(sms)).willReturn("Mensagem Enviada");
//		ResponseEntity<String> retorno = smsController.enviarSms2(sms);
//
//		assertThat(retorno.toString()).isEqualTo("<201 Created,Mensagem Enviada,{}>");
//	}
//	
//	@Test
//	public void enviarSmsDataExpirada() {
//		Long id = 1L;
//		Long from = 21998845885L;
//		Long to = 21998845886L;
//		String body = "oi";
//
//		Calendar calendarValidadeMensagem = Calendar.getInstance();
//		calendarValidadeMensagem.set(Calendar.YEAR, 2016);
//		calendarValidadeMensagem.set(Calendar.MONTH, Calendar.AUGUST);
//		calendarValidadeMensagem.set(Calendar.DAY_OF_MONTH, 20);
//
//		Date date = calendarValidadeMensagem.getTime();
//		SmsEntity sms = new SmsEntity(id, from, to, body, date);
//		try {
//			smsController.enviarSms2(sms);
//		} catch (BusinessException be) {
//			assertThat(be.getMessage()).containsSequence("Expirou");
//		}
//
//	}

//		@Test
//		public void enviarSms3() {
//	
//			Long id = 1L;
//			Long from = 21998845885L;
//			Long to = 21998845886L;
//			String body = null;
//			Date date = new Date();
//			SmsEntity sms = new SmsEntity(id, from, to, body, date);
//			urlSmsService = "http://localhost:8090/kleitonApi/sendSms3";
//			//urlSmsService = "/kleitonApi/sendSms3";
//	
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			HttpEntity<SmsEntity> smsRequest = new HttpEntity<>(sms, headers);
//	
//			RestTemplate restTemplate = new RestTemplate();
//			ResponseEntity<?> retorno = restTemplate.exchange(urlSmsService, HttpMethod.PUT, smsRequest, String.class);
//	
//			assertThat(HttpStatus.CREATED).isEqualTo(retorno.getStatusCode());
//		}
	
	@Test
	public void testParam(){
		try{
			RestTemplate restTemplate = new RestTemplate();
			Long cpf = 123455L;
			
			String url = "http://localhost:8091/kleitonApi/sendSms3?cpf={cpf}";
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("cpf", String.valueOf(cpf));
 			Long retorno = restTemplate.postForObject(url, null, Long.class, uriVariables);
			System.out.println("Retorno: "+retorno);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

//	@Test
//	public void listarSms() {
//
//		urlSmsService = "http://localhost:8090/kleitonApi/";
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//
//		RestTemplate restTemplate = new RestTemplate();
//		@SuppressWarnings("unchecked")
//		ResponseEntity<? extends ArrayList<SmsEntity>> retorno = restTemplate.getForEntity(urlSmsService, (Class<? extends ArrayList<SmsEntity>>) ArrayList.class);
//
//		assertThat(HttpStatus.OK).isEqualTo(retorno.getStatusCode());
//	}

}
