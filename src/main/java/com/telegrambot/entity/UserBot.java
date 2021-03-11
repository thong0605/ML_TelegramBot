//package com.telegrambot.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.JoinColumn;
//
//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;
//
//@Entity
//@Table(name = "user_bot", appliesTo = "")
//public class UserBot implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "chat_id", unique = true, nullable = false, length = 255)
//    private String chatId;
//
//    @Column(name = "bot_verification_code", length = 6)
//    private String botVerificationCode;
//
//    @Enumerated
//    @Column(name = "last_bot_state", columnDefinition = "SMALLINT DEFAULT NULL")
//    private BotState lastBotState;
//
//    @Column(columnDefinition = "TINYINT(1)")
//    private boolean verified;
//
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @ManyToOne(fetch = FetchType.EAGER)
//    private User user;
//}