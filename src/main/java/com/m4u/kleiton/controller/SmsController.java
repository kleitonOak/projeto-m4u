package com.m4u.kleiton.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m4u.kleiton.entity.SmsEntity;
import com.m4u.kleiton.service.SmsService;

@RestController
@RequestMapping(value = "/kleitonApi", headers = "Accept=application/json", method = {RequestMethod.PUT, RequestMethod.GET, RequestMethod.POST})
public class SmsController {

	@Autowired
	SmsService service;

	@RequestMapping(value = "/send/{id}/{from}/{to}/{body}", method = RequestMethod.GET)
	public ResponseEntity<String> enviarSms(@PathVariable Long id, @PathVariable Long from, @PathVariable Long to, @PathVariable String body, @RequestParam(value = "date", required = false) final Date date) {

		SmsEntity sms = new SmsEntity(id, from, to, body, date);
		return enviarSms2(sms);

		//return new ResponseEntity<String>(resposta, HttpStatus.OK);
	

	}

	@RequestMapping(value = "/sendSms")
	
	public ResponseEntity<String> enviarSms2(@Valid @RequestBody SmsEntity sms) {
		return new ResponseEntity<String>(service.enviarSms(sms),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/sendSms3")
	public ResponseEntity<Long> enviarSms2(@RequestParam(name="cpf") Long cpf) {
		return ResponseEntity.ok(cpf);
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<SmsEntity>> listarSms() {
		return new ResponseEntity<List<SmsEntity>>(service.listarSms(),HttpStatus.OK);

	}
}
