package org.edupoll.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_rooms")
public class ChatRoom {
	
	@Id @Column(name = "chat_room_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id; // 기본키
	
	String title; // 채팅방 제목
	
	LocalDateTime created; // 채팅방 개설일
	
	@OneToMany(mappedBy = "chatRoom", fetch = FetchType.LAZY)
	List<ChatMessage> messages;
	
	@OneToMany(mappedBy = "chatRoom", fetch = FetchType.LAZY)
	List<ChatJoin> joins;
	
	@PrePersist
	void prePersist() {
		this.created = LocalDateTime.now();
	}
	
	public List<ChatMessage> getMessages() {
		return messages;
	}
	
	public void setMessages(List<ChatMessage> messages) {
		this.messages = messages;
	}
	
	public List<ChatJoin> getJoins() {
		return joins;
	}

	public void setJoins(List<ChatJoin> joins) {
		this.joins = joins;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
}
