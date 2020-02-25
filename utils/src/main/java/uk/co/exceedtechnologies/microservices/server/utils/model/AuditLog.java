package uk.co.exceedtechnologies.microservices.server.utils.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class AuditLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long timestamp;
	private String source;
	private String log;
}
