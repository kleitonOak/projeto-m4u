package com.m4u.kleiton.service;

import java.util.List;

import com.m4u.kleiton.entity.SmsEntity;

public interface SmsService {
	public String enviarSms(SmsEntity smsEntity);
	public List<SmsEntity> listarSms();
}
