package com.m4u.kleiton.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m4u.kleiton.client.SmsClientDTO;
import com.m4u.kleiton.client.SmsServiceClient;
import com.m4u.kleiton.entity.SmsEntity;
import com.m4u.kleiton.exception.BusinessException;
import com.m4u.kleiton.repository.SmsRepository;

@Service
@Transactional
public class SmsServiceImpl implements SmsService {

	@Autowired
	SmsRepository smsRepository;

	@Autowired
	SmsServiceClient serviceClient;

	@Override
	public String enviarSms(SmsEntity smsEntity) {
		Date dataSistema = new Date();

		//Verificar data de validade da mensagem
		if (smsEntity.getSmsDate() != null && dataSistema.compareTo(smsEntity.getSmsDate()) > 0) {
			throw new BusinessException("A data da mensagem expirou!");
		}
		//Salvando no banco
		smsRepository.save(smsEntity);

		//populando o objeto
		SmsClientDTO sms = new SmsClientDTO();
		sms.setId(smsEntity.getId().intValue());
		sms.setBody(smsEntity.getBody());
		sms.setFrom(smsEntity.getSmsFrom().toString());
		sms.setTo(smsEntity.getTo().toString());

		//Chamando a api
		return serviceClient.enviarMensagem(sms);
	}

	@Override
	public List<SmsEntity> listarSms() {
		return smsRepository.findAll();
	}
}
