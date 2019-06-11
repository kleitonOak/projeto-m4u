package com.m4u.kleiton.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class SmsEntity implements Serializable{

	/**
	 * SERIAL VERSION
	 */
	private static final long serialVersionUID = -5416455235289339836L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long smsId;
	
	@NotNull
	private Long id;
	@NotNull
	@Min(11)
	private Long smsFrom;
	
	@NotNull
	@Min(11)
	private Long to;
	
	@Size(min=1, max=160)
	private String body;
	
	private Date smsDate;

	public SmsEntity() {
		super();
	}

	public SmsEntity(Long id, Long from, Long to, String body, Date smsDate) {
		super();
		this.id = id;
		this.smsFrom = from;
		this.to = to;
		this.body = body;
		this.smsDate = smsDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSmsFrom() {
		return smsFrom;
	}

	public void setSmsFrom(Long from) {
		this.smsFrom = from;
	}

	public Long getTo() {
		return to;
	}

	public void setTo(Long to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getSmsDate() {
		return smsDate;
	}

	public void setSmsDate(Date smsDate) {
		this.smsDate = smsDate;
	}

	

	public Long getSmsId() {
		return smsId;
	}

	public void setSmsId(Long smsId) {
		this.smsId = smsId;
	}

	@Override
	public String toString() {
		return "SmsEntity [idEntity=" + smsId + ", id=" + id + ", from=" + smsFrom + ", to=" + to + ", body=" + body + ", date=" + smsDate + "]";
	}
	
	@Override
    public int hashCode() {
        HashCodeBuilder codeBuilder = new HashCodeBuilder();
        codeBuilder.append(id);
        codeBuilder.append(smsFrom);
        codeBuilder.append(to);
        return codeBuilder.toHashCode();
    }
	
	@Override
    public boolean equals(Object obj) {
		if (!(obj instanceof SmsEntity) ) {
            return false;
        }
		
        if (this == obj) {
            return true;
        }
        
        SmsEntity objParam = (SmsEntity) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        
        equalsBuilder.append(id, objParam.getId());
        equalsBuilder.append(smsFrom, objParam.getSmsFrom());
        equalsBuilder.append(to, objParam.getTo());
        return equalsBuilder.isEquals();
    }

}
