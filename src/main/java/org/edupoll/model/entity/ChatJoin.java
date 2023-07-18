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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_joins")
public class ChatJoin {
	
	@Id @Column(name = "chat_join_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id; // 기본키
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	User user; // 채팅방 참여 유저
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chat_room_id")
	ChatRoom chatRoom; // 채팅방 이름
	
	LocalDateTime joined; // 채팅방 참여일
	
	@PrePersist
	void prePersist() {
		this.joined = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDateTime getJoined() {
		return joined;
	}

	public void setJoined(LocalDateTime joined) {
		this.joined = joined;
	}
}
