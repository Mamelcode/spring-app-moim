package org.edupoll.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {

	@Id @Column(name = "chat_message_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id; // 기본키
	
	String description; // 메세지 내용
	LocalDateTime created; // 메세지 작성일
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	User user; // 작성자
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chat_room_id")
	ChatRoom chatRoom; // 채팅방 이름
	
	
	void prePersist() {
		this.created = LocalDateTime.now();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getCreated() {
		return created;
	}


	public void setCreated(LocalDateTime created) {
		this.created = created;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public ChatRoom getChatRoom() {
		return chatRoom;
	}


	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}
}
