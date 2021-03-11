package com.telegrambot.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import com.vdurmont.emoji.EmojiParser;

public class Buttons {
	private String smile_emoji = EmojiParser.parseToUnicode(":smiley: some text");

	public void contactButtons(SendMessage sendMessage) {
		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
		sendMessage.setReplyMarkup(keyboardMarkup);
		keyboardMarkup.setSelective(true);
		keyboardMarkup.setResizeKeyboard(true);
		keyboardMarkup.setOneTimeKeyboard(false);
		// New Rows List
		List<KeyboardRow> rowList = new ArrayList<KeyboardRow>();
		// Create a list of keyboard rows
		KeyboardRow firstRow = new KeyboardRow();
		KeyboardRow secondRow = new KeyboardRow();

		firstRow.add(
				new KeyboardButton().setText("Send my Phone Number").setRequestContact(true).setRequestLocation(false));
		secondRow.add(new KeyboardButton().setText("Send my Current Location").setRequestContact(false)
				.setRequestLocation(true));

		// Add single row to row list
		rowList.add(firstRow);
		rowList.add(secondRow);

		// Set keyboard's row to the mark up and Hide the keyboard after user click on
		// button
		keyboardMarkup.setKeyboard(rowList).setOneTimeKeyboard(true);
		// Then set the mark up as a message to be sent
		sendMessage.setReplyMarkup(keyboardMarkup);
	}

	public synchronized ReplyKeyboardMarkup setButtons(String tetx1, String tetx2) {
		// Create a keyboard
		// Set mark up Keyboard & add the mark up to message
		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
		//sendMessage.setReplyMarkup(keyboardMarkup);
		keyboardMarkup.setSelective(true);
		keyboardMarkup.setResizeKeyboard(true);
		keyboardMarkup.setOneTimeKeyboard(false);

		// New Rows List
		List<KeyboardRow> rowList = new ArrayList<KeyboardRow>();
		// Create a list of keyboard rows
		KeyboardRow firstRow = new KeyboardRow();
		KeyboardRow secondRow = new KeyboardRow();

		// Add button to the first row
		firstRow.add(new KeyboardButton().setText(tetx1));
		secondRow.add(new KeyboardButton().setText(tetx2));

		// Add row to row list
		rowList.add(firstRow);
		rowList.add(secondRow);

		// Set keyboard's row to the mark up and Hide the keyboard after user click on
		// button
		keyboardMarkup.setKeyboard(rowList);
		// Then set the mark up as a message to be sent 
		return keyboardMarkup;

	}

	private void setInline(SendMessage sendMessage) {
		List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
		List<InlineKeyboardButton> buttons1 = new ArrayList<>();
		buttons1.add(new InlineKeyboardButton().setText("Button").setCallbackData("callbackdata"));
		buttons.add(buttons1);

		InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
		sendMessage.setReplyMarkup(markupKeyboard);
		markupKeyboard.setKeyboard(buttons);
		// Then set the mark up as a message to be sent

	}
	
//	private static InlineKeyboardMarkup getInlineSimpleAnswerKeyboard(String callbackData) {
//        InlineKeyboardMarkup inlineReplyMarkup = new InlineKeyboardMarkup();
//        final List<InlineKeyboardButton> keyboardButtons = new ArrayList<>(2);
//
//        JSONObject jsonYes = new JSONObject();
//        jsonYes.put("text", Answer.YES);
//        jsonYes.put("callback_data", callbackData + 1);
//        keyboardButtons.add(new InlineKeyboardButton(jsonYes));
//
//        JSONObject jsonNo = new JSONObject();
//        jsonNo.put("text", Answer.NO);
//        jsonNo.put("callback_data", callbackData + 0);
//        keyboardButtons.add(new InlineKeyboardButton(jsonNo));
//
//        inlineReplyMarkup.setKeyboard(Collections.singletonList(keyboardButtons));
//        return inlineReplyMarkup;
//    }
	
//	private void sendNextInteraction(String callbackData, SendMessage sendMessage) {
//        String[] callbackDataArray = callbackData.split(SEPARATOR, 2);
//        int questionnaireIndex = Integer.parseInt(callbackDataArray[0]);
//        String[] answers = callbackDataArray[1].split("");
//        int amountOfAnsweredQuestions = answers[0].equals("") ? 0 : answers.length;
//
//        IQuestionnaire questionnaire = availableQuestionnaires.get(questionnaireIndex);
//        if (questionnaire != null) {
//            //store the answer in the questionnaire
//            if (amountOfAnsweredQuestions > 0) {
//                int answerIndex = amountOfAnsweredQuestions - 1;
//                questionnaire.setAnswer(answerIndex, mapAnswer(answers[answerIndex]));
//            }
//            //when the questionnaire is running and the next question should occur
//            if (amountOfAnsweredQuestions != questionnaire.getAmountOfQuestions()) {
//                sendMessage.setText(questionnaire.getQuestion(amountOfAnsweredQuestions).getQuestionText());
//                sendMessage.setReplyMarkup(getInlineSimpleAnswerKeyboard(callbackData));
//            }
//            //when the questionnaire is completed
//            else {
//                sendMessage.setText(questionnaire.getFinalResult() + RESTART_TEXT);
//            }
//        } else {
//            sendMessage.setText(ERROR_TEXT);
//        }
//    }

}
