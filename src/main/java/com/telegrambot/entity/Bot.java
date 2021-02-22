package com.telegrambot.entity;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Audio;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.api.objects.Voice;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;

public class Bot extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {

		// Check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {

			String message_text = update.getMessage().getText();

			long chat_id = update.getMessage().getChatId();

			if (message_text.equals("/start")) {
				SendMessage message = new SendMessage().setChatId(chat_id)
						.setText("Choose a position you want to get in:");
				// Choice's buttons show up
				InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
				List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
				List<InlineKeyboardButton> rowInline = new ArrayList<>();
				// Set up position's buttons
				rowInline.add(new InlineKeyboardButton().setText("Apply as new Ambassador")
						.setCallbackData("update_ambassador"));
				rowInline.add(
						new InlineKeyboardButton().setText("Apply as new Greeter").setCallbackData("update_greeter"));

				// Set the keyboard to the markup
				rowsInline.add(rowInline);

				// Add it to the message
				markupInline.setKeyboard(rowsInline);
				message.setReplyMarkup(markupInline);

				try {
					execute(message);
				} catch (TelegramApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (message_text.equals("/myfullname")) {
				// Test command
				SendMessage message = new SendMessage();
				message.setText("Your fullname is: " + update.getMessage().getFrom().getFirstName() + " "
						+ update.getMessage().getFrom().getLastName());
			} else {
				// If the bot get hit up by casual messages. Leave this message
				SendMessage message = new SendMessage();
				message.setText("Hi " + update.getMessage().getFrom().getFirstName()
						+ " .We have received your message, we will reply you soon.");
			}

		} else if (update.hasCallbackQuery()) {
			// Get callback data
			String call_data = update.getCallbackQuery().getData();
			long message_id = update.getCallbackQuery().getMessage().getMessageId();
			long chat_id = update.getCallbackQuery().getMessage().getChatId();

			if (call_data.equals("update_ambassador") || call_data.equals("update_greeter")) {
				String answer = "Applied successfully";
				EditMessageText new_message = new EditMessageText().setChatId(chat_id).setMessageId((int) message_id)
						.setText(answer);
				try {
					execute(new_message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
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
