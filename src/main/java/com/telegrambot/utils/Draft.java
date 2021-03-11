package com.telegrambot.utils;
//import org.telegram.telegrambots.api.methods.send.SendMessage;
//import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
//import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
//import org.telegram.telegrambots.exceptions.TelegramApiException;
//
//String message_text = update.getMessage().getText();
//			long chat_id = update.getMessage().getChatId();
//			String user_fname = update.getMessage().getFrom().getFirstName();
//			
//			switch (message_text) {
//			case "/start":			
//				;
//
//				// Choice's buttons called
//				parts.setButtons(sendMsg(chat_id,"Hi " + user_fname
//						+ ", I'm Tony. "
//						+ "Please choose one of two options below. Or type /contact to leave contact information"));
//
//				try {
//					execute(reply_message);
//				} catch (TelegramApiException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				break;
//			case "Online Assembly Member (Beta)":
//				SendMessage apply_admin = new SendMessage().setChatId(chat_id)
//						.setReplyMarkup(new ReplyKeyboardRemove());
//				parts.applyAdmin(apply_admin);
//				try {
//					execute(apply_admin);
//				} catch (TelegramApiException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				break;
//			case "Join Mundo Lingo Groups":
//				SendMessage join_group = new SendMessage().setChatId(chat_id).setReplyMarkup(new ReplyKeyboardRemove());
//				parts.joinChannel(join_group);
//				try {
//					execute(join_group);
//				} catch (TelegramApiException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				break;
//
//			case "/contact":
//				SendMessage contact_message = new SendMessage().setChatId(chat_id).setText("Choose one of those below:")
//						.setReplyMarkup(new ReplyKeyboardRemove());
//				parts.contactButtons(contact_message);
//				try {
//					execute(contact_message);
//				} catch (TelegramApiException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				break;
//			default:
//				// code block
//				SendMessage d_message = new SendMessage().setChatId(chat_id).setText("Choose one of those below:")
//						.setReplyMarkup(new ReplyKeyboardRemove());
//				try {
//					execute(d_message);
//				} catch (TelegramApiException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		} else if (update.getMessage().hasLocation()) {
//			SendMessage location = new SendMessage();
//			long chat_id = update.getMessage().getChatId();
//			location.setChatId(chat_id).setText(update.getMessage().getLocation().toString());
//
//			try {
//				execute(location);
//			} catch (TelegramApiException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		else if (update.hasCallbackQuery())
//
//		{
//
//			// Get callback data
//			String call_data = update.getCallbackQuery().getData();
//			long message_id = update.getCallbackQuery().getMessage().getMessageId();
//			long chat_id = update.getCallbackQuery().getMessage().getChatId();
//
//			String answer = "";
//			SendMessage reply = new SendMessage().setChatId(chat_id);
//			EditMessageText new_message;
//			switch (call_data) {
//			case "input_name":
//				answer = "Applied successfully: Ambassador";
//				reply.setText(answer);
//				try {
//					execute(reply);
//				} catch (TelegramApiException e) {
//					e.printStackTrace();
//				}
//				break;
//			case "input_":
//				answer = "Applied successfully: Greeter";
//				reply.setText(answer);
//				try {
//					execute(reply);
//				} catch (TelegramApiException e) {
//					e.printStackTrace();
//				}
//				break;
//			default:
//				answer = "Invalid choice! Try again";
//				new_message = new EditMessageText().setChatId(chat_id).setMessageId((int) message_id).setText(answer);
//				try {
//					execute(new_message);
//				} catch (TelegramApiException e) {
//					e.printStackTrace();
//				}
//			}
//
//		} else
//
//		{
//			// to do
//		}