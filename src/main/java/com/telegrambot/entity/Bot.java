package com.telegrambot.entity;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class Bot extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {

//		System.out.println(update.getMessage().getFrom().getUserName());
//		System.out.println(update.getMessage().getText());

		String command = update.getMessage().getText();

		SendMessage message = new SendMessage();

		if (command.equals("/myfullname")) {
			System.out.println(
					update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
			message.setText("Your fullname is: " + update.getMessage().getFrom().getFirstName() + " "
					+ update.getMessage().getFrom().getLastName());
		} else if (command.equals("/apply_admin")) {
			
			//add new user_ambassador
		} else {
			message.setText("Hi " + update.getMessage().getFrom().getFirstName()
					+ " .We have received your message, we will reply you soon.");
		}

		message.setChatId(update.getMessage().getChatId());

		try {
			execute(message);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "thong0605_bot";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "1684647984:AAFQE2vKgbHEc2jSJntkM8WiQIBQeBmb44U";
	}

}
