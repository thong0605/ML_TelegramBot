package com.telegrambot.entity;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.telegrambot.utils.Buttons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.telegram.telegrambots.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.api.methods.ParseMode;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class Bot extends TelegramLongPollingBot {

	private Buttons button = new Buttons();

	@Override
	public void onUpdateReceived(Update update) {
		
		Message message = update.getMessage();

		// Check if the update has a message and the message has text
		if (update.hasMessage() && message.hasText()) {

			// handleStart(message);
			
			long chat_id = update.getMessage().getChatId();
			String user_fname = update.getMessage().getFrom().getFirstName();

			switch (message.getText()) {
			case "/start":
				// Choice's buttons called
				String message_text = "Hi " + user_fname + ", I'm Tony. Please choose one of two options below. \n"
						+ "Or type /contact to leave contact information";
				handleStart(message, message_text);
				break;
			case "Online Assembly Member (Beta)":
				String apply_admin = "[MundoLingo](https://mundolingo.typeform.com/to/Rg2Snz)";
				sendMsg(update.getMessage().getChatId(), apply_admin);
				break;
			case "Room Keys":
				String key = "Here's your room keys to our community. \n" + "[Google](https://www.google.com/)";
				sendMsg(update.getMessage().getChatId(), key);
				break;

			case "/contact":
				String contact_message = "Choose one of those below: \n";
				sendContact(update.getMessage().getChatId(), contact_message);
				break;
			default:
			}

		} else if (update.getMessage().hasLocation()) {
			// Sending contact information
			long chat_id = update.getMessage().getChatId();
			sendMsg(chat_id, "Your location: " + update.getMessage().getLocation().toString());
		} else if (update.hasCallbackQuery() && update.getCallbackQuery().getMessage() != null) {
			// handleQuestionnaire(update);
			
		}
	}
	
	// handleStart
	private void handleStart(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(button.setButtons("Online Assembly Member (Beta)", "Room Keys"));

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("An error occurred while starting conversation:" + e);
        }
    }

	// Send messages
	@SuppressWarnings("deprecation")
	public synchronized void sendMsg(long chatId, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(chatId);
		sendMessage.setText(text);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			System.out.println("An error occurred while starting conversation:" + e);
		}
	}

	@SuppressWarnings("deprecation")
	public synchronized void sendContact(long chatId, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(chatId);
		sendMessage.setText(text);
		button.contactButtons(sendMessage);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	///////////////////////////////////////////
	@SuppressWarnings("deprecation")
	public synchronized void answerCallbackQuery(String callbackId, String message) {
		AnswerCallbackQuery answer = new AnswerCallbackQuery();
		answer.setCallbackQueryId(callbackId);
		answer.setText(message);
		answer.setShowAlert(true);
		try {
			answerCallbackQuery(answer);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	//questionnaire to be executed
//	private static final String SEPARATOR = "_";
//
//	private InlineKeyboardMarkup getQuestionnaireChoiceKeyboard() {
//	    InlineKeyboardMarkup replyMarkup = new InlineKeyboardMarkup();
//	    final List<InlineKeyboardButton> keyboardButtons = new ArrayList<>(availableQuestionnaires.size());
//
//	    this.availableQuestionnaires.stream().forEach((questionnaire) -> {
//	        JSONObject json = new JSONObject();
//	        json.put("text", questionnaire.getQuestionnaireTitle());
//	        json.put("callback_data", mapQuestionnaireTitleToIndexId(questionnaire.getQuestionnaireTitle()) + SEPARATOR);
//	        keyboardButtons.add(new InlineKeyboardButton(json));
//	    });
//
//	    replyMarkup.setKeyboard(Collections.singletonList(keyboardButtons));
//	    return replyMarkup;
//	}
	
	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "thong0605_bot";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "1612458854:AAHGdQBqR0whpQfU9V1IeZCN_Zw_Q193K1k";
	}

}
