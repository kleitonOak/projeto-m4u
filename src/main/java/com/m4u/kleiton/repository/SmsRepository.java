package com.m4u.kleiton.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m4u.kleiton.entity.SmsEntity;

public interface SmsRepository extends JpaRepository<SmsEntity, Long> {

	List<SmsEntity> findBysmsFrom(Long from);
}
