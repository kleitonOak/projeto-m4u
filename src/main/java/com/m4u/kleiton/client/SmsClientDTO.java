package com.m4u.kleiton.client;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.m4u.kleiton.entity.SmsEntity;

public class SmsClientDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1676005226503206487L;
	private Integer id;
	private String from;
	private String to;
	private String body;

	public SmsClientDTO() {
		super();
	}

	public SmsClientDTO(Integer id, String from, String to, String body) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.body = body;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
    public int hashCode() {
        HashCodeBuilder codeBuilder = new HashCodeBuilder();
        codeBuilder.append(id);
        codeBuilder.append(from);
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
        equalsBuilder.append(from, objParam.getSmsFrom());
        equalsBuilder.append(to, objParam.getTo());
        return equalsBuilder.isEquals();
    }
	
}
