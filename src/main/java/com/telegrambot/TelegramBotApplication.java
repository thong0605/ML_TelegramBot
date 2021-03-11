package com.telegrambot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.telegrambot.entity.Bot;

@SpringBootApplication
public class TelegramBotApplication {
	public static void main(String[] args) {
		// Initialize Api Context
		ApiContextInitializer.init();

		// TODO Register our bot
		try {
			// Instantiate Telegram Bots API
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
			telegramBotsApi.registerBot(new Bot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
