package org.edupoll.model.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name = "follows",
		uniqueConstraints = {
				@UniqueConstraint(
					name="follow_01",
					columnNames = {
					"ownerId", "targetId"
			}
		)		
	}
)
public class Follow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	LocalDate created;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ownerId")
	User owner;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "targetId")
	User target;
	
	
	public Follow() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getTarget() {
		return target;
	}

	public void setTarget(User target) {
		this.target = target;
	}
	
	// 객체 insert 전 할 작업
	@PrePersist
	public void doPrepersist() {
		System.out.println("doPrepersist");
		this.created = LocalDate.now();
	}
}
