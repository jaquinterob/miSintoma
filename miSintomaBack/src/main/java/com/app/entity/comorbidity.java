package com.app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="comorbidity")
public class comorbidity {
	private static final long serialVersionUID = 1L;
	//
	@Id
	@GeneratedValue(  strategy= GenerationType.AUTO,   generator="native")
	@GenericGenerator( name = "native",  strategy = "native"  )
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameComorbidity() {
		return name;
	}

	public void setNameComorbidity(String name) {
		this.name = name;
	}
	
	public String getTypeOfComorbidity() {
		return type;
	}

	public void setTypeOfComorbidity(String type) {
		this.type = type;
	}
		
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "comorbidity [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	public comorbidity(String name, String type ) {
		this.name = name;
		this.type = type;
	}
	
	public comorbidity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
