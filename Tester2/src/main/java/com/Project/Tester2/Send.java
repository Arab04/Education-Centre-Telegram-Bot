package com.Project.Tester2;

import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Send {
	
	private Send() {}
	
	public static Send create() {
		Send s = new Send();
		return s;
	}
	
	// Admin Button1
	public SendMessage admin(Long id, String admin1) {
		SendMessage m = new SendMessage();
		m.setChatId(id);
		m.setText(admin1);
		
		return m;
	}
	
	// Admin Button 2
	public SendMessage admin1(Long id,String admin2) {
		SendMessage m = new SendMessage();
		m.setChatId(id);
		m.setText(admin2);
		return m;
	}
	
	// Centre Location Button
	public SendLocation location(Long id) {
		
		SendLocation location = new SendLocation();
		location.setLatitude((float) 41.308492);
		location.setLongitude((float)69.187570);
		location.setChatId(id);
		
		return location;
	}
	
	// AnswareCallbackQuery of CBQ
	public AnswerCallbackQuery eng(String id,String course,String written) {
		AnswerCallbackQuery q = new AnswerCallbackQuery();
		q.setCallbackQueryId(id);
		q.setText("#"+course+"\n"+written);
		q.setShowAlert(true);
		return q;
	}
	
	// SendMessage to the group
	public SendMessage engS(String text) {
		SendMessage m = new SendMessage();
		m.setChatId((long) -1001289416825L);
		m.setText(text);
		return m;
	}
	

}
