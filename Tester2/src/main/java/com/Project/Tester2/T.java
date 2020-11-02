package com.Project.Tester2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Video;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.Project.Tester2.Language.sl;
import com.Project.Tester2.hibernate.Connection;

enum State {
    
	SET_LANGUAGE,NAME_REQUESTED,SURNAME_REQUESTED,AGE_REQUESTED,
	NUMBER_REQUESTED,COMMANDS,EDIT_NAME,EDIT_SURNAME,EDIT_NUMBER,EDIT_LANGUAGE,MAIN_MENU,
	SEND_MESSAGE,SEND_PHOTO,SEND_VIDEO,SEND_DOCUMENT
	
   
}

public class T extends TelegramLongPollingBot {

	private Map<Integer, State> stateregistry = new HashMap<Integer,State>();
	private Enrollment e = new Enrollment();

	
//	//If shut Down will happen it will give ChatID to the stateregistry
	{
		for(Enrollment e:Connection.getData()) {
		this.stateregistry.put(e.getChatId().intValue(), State.MAIN_MENU);
		}
	}
	
	public void onUpdateReceived(Update update) {
	 
	        if (update.hasMessage()) {
	        	
	        	final Message message = update.getMessage();
	        	Integer id = message.getFrom().getId();
	        	Long cid = message.getChatId();
	
	        	if(stateregistry.containsKey(id)) {
	        		switch(stateregistry.get(id)) {
	        		
	        		case SET_LANGUAGE:
	        			switch(message.getText()){
	        			
	        			case"English":
	        				sl.setEng();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getRequestName()));
		        			stateregistry.put(id, State.NAME_REQUESTED);
	        				break;
	        			
	        			case "O'zbek":
	        				sl.setUzb();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getRequestName()));
		        			stateregistry.put(id, State.NAME_REQUESTED);
	        				break;
	        				
	        			case "Русский":
	        				sl.setRus();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getRequestName()));
		        			stateregistry.put(id, State.NAME_REQUESTED);
	        				break;
	        			}
	        			break;
	        		
	        		case NAME_REQUESTED:
	        			e.setName(message.getText());
	        			e.setUserName(message.getChat().getUserName());
	        			executor(new SendMessage().setChatId(cid).setText(sl.t.getRequestSurname()));
	        			stateregistry.put(id, State.SURNAME_REQUESTED);
	        			break;
	        			
	        		case SURNAME_REQUESTED:
	        			e.setSurname(message.getText());
	        			executor(new SendMessage().setChatId(cid).setText(sl.t.getRequestage()));
	        			stateregistry.put(id, State.AGE_REQUESTED);
	        			break;
	        			
	        			
	        		case AGE_REQUESTED:
	        			e.setAge(message.getText());
	        			executor(new SendMessage().setChatId(cid).setText(sl.t.getRequestNum()));
	        			stateregistry.put(id, State.NUMBER_REQUESTED);
	        			break;
	        		
	        		case NUMBER_REQUESTED:
	        			e.setNumber(message.getText());
	        			e.setChatId(cid);
	        			Thread t1 = new Thread(new Runnable() {
					
							@Override
							public void run() {
								Connection.saveData(e);
							}
						});
	  
	        			t1.start();
	        			executor(Menues.create().switchToMainMenu(cid, sl.t.getMainMenu(), sl.t.getMainMenu()));
	        			stateregistry.put(id, State.MAIN_MENU);
	        			break;
	        		
	        		case MAIN_MENU:
	        			executor(Menues.create().mainMenu(cid, sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
	        			stateregistry.put(id, State.COMMANDS);
	        			break;
	        		
	        		case COMMANDS:
	        			
	        			
						if(message.getText().equals(sl.t.getCourses())) {
							executor(Menues.create().secondMenu(cid, sl.t.getSecondMenu(), sl.t.getEnglish(), sl.t.getMath(), sl.t.getHistory(), sl.t.getBiology(), sl.t.getBack()));
						}
						
						else if(message.getText().equals(sl.t.getBack())) {
							executor(Menues.create().mainMenu(cid,sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
						}
						
						else if(message.getText().equals(sl.t.getAdmin())) {
							executor(Send.create().admin(cid, sl.t.getAdmin1()));
							executor(Send.create().admin1(cid,sl.t.getAdmin2()));
						}
						
						else if(message.getText().equals(sl.t.getLocation())) {
							lexecutor(Send.create().location(cid));
						}
						
						else if(message.getText().equals(sl.t.getPayment())) {
							executor(Menues.create().payment(cid, sl.t.getInlinePayment()));
						}
						
						else if(message.getText().equals(sl.t.getSettings())) {
							executor(Menues.create().settings(cid, sl.t.getSettings(), sl.t.getEditName(), sl.t.getEditSurname(), sl.t.getEditNumber(), sl.t.getChangeLanguage(), sl.t.getBack()));
						}
						
						else if(message.getText().equals(sl.t.getEnglish())) {
							executor(Menues.create().eng(cid, sl.t.getEngdes(), sl.t.getEnroll()));
						}
						
						else if(message.getText().equals(sl.t.getBiology())) {
							executor(Menues.create().eng(cid, sl.t.getBiodes(), sl.t.getEnroll()));
						}
						
						else if(message.getText().equals(sl.t.getHistory())) {
							executor(Menues.create().eng(cid, sl.t.getHisdes(), sl.t.getEnroll()));
						}
						
						else if(message.getText().equals(sl.t.getMath())) {
							executor(Menues.create().eng(cid, sl.t.getMathdes(), sl.t.getEnroll()));
						}
							
						else if(message.getText().equals(sl.t.getEditName())) {
							executor(new SendMessage().setChatId(cid).setText(sl.t.getRequestName()));
							stateregistry.put(id, State.EDIT_NAME);
						}
						
						else if(message.getText().equals(sl.t.getEditSurname())) {
							executor(new SendMessage().setChatId(cid).setText(sl.t.getRequestSurname()));
							stateregistry.put(id, State.EDIT_SURNAME);
	        		    }
						
						else if(message.getText().equals(sl.t.getEditNumber())) {
							executor(new SendMessage().setChatId(cid).setText(sl.t.getRequestNum()));
							stateregistry.put(id, State.EDIT_NUMBER);
						}
						
						else if(message.getText().equals(sl.t.getChangeLanguage())) {
							executor(Menues.create().language(cid, sl.t.getInlinePayment(), sl.t.getSetUzbek(), sl.t.getSetRussia(), sl.t.getSetEnglish(), sl.t.getBack()));
							stateregistry.put(id, State.EDIT_LANGUAGE);
						}
						
							     if(message.getText().equals("menu")) {
								executor(new SendMessage().setText("Menu here").setChatId(cid));
								executor(new SendMessage().setChatId(cid).setText("#571 send Message \n#572 send photo \n#573 send file \n#574 send video"));
								}
								
								else if(message.getText().equals("#571")) {
									executor(new SendMessage().setChatId(cid).setText("please send message"));
									stateregistry.put(message.getFrom().getId(), State.SEND_MESSAGE);
								}
								
								else if(message.getText().equals("#572")) {
									executor(new SendMessage().setChatId(cid).setText("please send photo with words please"));
									stateregistry.put(message.getFrom().getId(), State.SEND_PHOTO);
								}
								
								else if(message.getText().equals("#573")) {
									executor(new SendMessage().setChatId(cid).setText("please send file"));
									stateregistry.put(message.getFrom().getId(), State.SEND_DOCUMENT);
								}
								
								else if (message.getText().equals("#574")) {
									executor(new SendMessage().setChatId(cid).setText("please send video"));
									stateregistry.put(message.getFrom().getId(), State.SEND_VIDEO);
								}
						     
	        			break;
	        			
	        		case EDIT_NAME:
	        			e.setName(message.getText());
	        			executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccName()+e.getName()));
	        			stateregistry.put(id, State.COMMANDS);
	        			break;
	        			
	        		case EDIT_SURNAME:
	        			e.setSurname(message.getText());
	        			executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccSurname()+e.getSurname()));
	        			stateregistry.put(id, State.COMMANDS);
	        			break;
	        			
	        		case EDIT_NUMBER:
	        			e.setNumber(message.getText());
	        			executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccNum()+e.getNumber()));
	        			stateregistry.put(id, State.COMMANDS);
	        			break;
	        			
	        		case EDIT_LANGUAGE:
	        			
                       switch(message.getText()){
	        			
	        			case"English":
	        				sl.setEng();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccLang()));
	        				executor(Menues.create().mainMenu(cid, sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
		        			stateregistry.put(id, State.COMMANDS);
	        				break;
	        			
	        			case "Uzbek":
	        				sl.setUzb();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccLang()));
	        				executor(Menues.create().mainMenu(cid, sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
		        			stateregistry.put(id, State.COMMANDS);
	        				break;
	        				
	        			case "Russia":
	        				sl.setRus();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccLang()));
	        				executor(Menues.create().mainMenu(cid, sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
		        			stateregistry.put(id, State.COMMANDS);
	        				break;
	        				
	        			case "Узбекский":
	        				sl.setUzb();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccLang()));
	        				executor(Menues.create().mainMenu(cid, sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
		        			stateregistry.put(id, State.COMMANDS);
	        				break;
	        				
	        			case "Английский":
	        				sl.setEng();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccLang()));
	        				executor(Menues.create().mainMenu(cid, sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
		        			stateregistry.put(id, State.COMMANDS);
	        				break;
	        				
	        			case "Русский":
	        				sl.setRus();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccLang()));
	        				executor(Menues.create().mainMenu(cid, sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
		        			stateregistry.put(id, State.COMMANDS);
	        				break;
	        				
	        			case "Ingliz Tili":
	        				sl.setEng();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccLang()));
	        				executor(Menues.create().mainMenu(cid, sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
		        			stateregistry.put(id, State.COMMANDS);
	        				break;
	        				
	        			case "Rus Tili":
	        				sl.setRus();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccLang()));
	        				executor(Menues.create().mainMenu(cid, sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
		        			stateregistry.put(id, State.COMMANDS);
	        				break;
	        				
	        			case "Uzbek Tili":
	        				sl.setUzb();
	        				executor(new SendMessage().setChatId(cid).setText(sl.t.getSuccLang()));
	        				executor(Menues.create().mainMenu(cid, sl.t.getMainMenu(), sl.t.getCourses(), sl.t.getAdmin(), sl.t.getLocation(), sl.t.getPayment(), sl.t.getSettings()));
		        			stateregistry.put(id, State.COMMANDS);
	        				break;
	        				
	        			case "Back":
	        				executor(Menues.create().settings(cid, sl.t.getSettings(), sl.t.getEditName(), sl.t.getEditSurname(), sl.t.getEditNumber(), sl.t.getChangeLanguage(), sl.t.getBack()));
	        				stateregistry.put(id, State.COMMANDS);
	        				break;
	        				
	        			case "Orqaga":
	        				executor(Menues.create().settings(cid, sl.t.getSettings(), sl.t.getEditName(), sl.t.getEditSurname(), sl.t.getEditNumber(), sl.t.getChangeLanguage(), sl.t.getBack()));
	        				stateregistry.put(id, State.COMMANDS);
	        				break;
	        				
	        			case "Назад":
	        				executor(Menues.create().settings(cid, sl.t.getSettings(), sl.t.getEditName(), sl.t.getEditSurname(), sl.t.getEditNumber(), sl.t.getChangeLanguage(), sl.t.getBack()));
	        				stateregistry.put(id, State.COMMANDS);
	        				break;
	        			}
	        			break;
	        			
	        		case SEND_MESSAGE:
						//Sends message to the bot users
						for(Enrollment en:Connection.getData()) {
							executor(new SendMessage().setText(message.getText()).setChatId(en.getChatId()));
						}
						//Finished process and sends message to the owner of the bot
						executor(new SendMessage().setChatId(cid).setText("message sent to users"));
						stateregistry.put(message.getFrom().getId(), State.COMMANDS);
					break;
					
					case SEND_PHOTO:
						List<PhotoSize> photos = message.getPhoto();
			            // Get file_id
			            String f_id = photos.stream()
			                            .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
			                            .findFirst()
			                            .orElse(null).getFileId();
			            
			            for(Enrollment en:Connection.getData()) {
						SendPhoto photo = new SendPhoto()
								.setPhoto(f_id)
								.setCaption(message.getCaption())
								.setChatId(en.getChatId());
						pexecutor(photo);
			            }
						executor(new SendMessage().setChatId(cid).setText("photo with caption was sent"));
						stateregistry.put(message.getFrom().getId(), State.COMMANDS);
						break;
						
					case SEND_DOCUMENT:
						Document doc = message.getDocument();
						SendDocument d = new SendDocument();
						for(Enrollment en:Connection.getData()) {
						d.setChatId(en.getChatId());
						d.setDocument(doc.getFileId());
						fexecutor(d);
						}
						executor(new SendMessage().setChatId(cid).setText("file was sent was sent"));
						stateregistry.put(message.getFrom().getId(), State.COMMANDS);
						break;
						
					case SEND_VIDEO:
						Video v = message.getVideo();
						SendVideo video = new SendVideo();
						for(Enrollment en:Connection.getData()) {
							
							video.setChatId(en.getChatId());
							video.setVideo(v.getFileId());
							vexecutor(video);
							}
						
						break;
	        		}
	        		return;
	        	}
	        	
	        	else {
	        		executor(Menues.create().language(cid));
	        		stateregistry.put(id, State.SET_LANGUAGE);
	        		
	        	}
	        	
	        }
	        
	        else if(update.hasCallbackQuery()) {
	        	
	        	String call = update.getCallbackQuery().getData();
	        	String id = update.getCallbackQuery().getId();
	        	
	        	switch (call) {
	        	
				case "eng":	
					e.setCourse("English");
					
					String info = " O'quvchi ism sharfi: "+e.getName()+" "+e.getSurname()+"\n"+"Yoshi: "+
							e.getAge()+"\n"+"Kurs Nomi: "+e.getCourse()+"\n"+"Telefon Raqami: "+e.getNumber()+
							"\n"+"Telegramdagi userNamemi: "+e.getUserName();
					
					executor(Send.create().engS(info));
					aexecutor(Send.create().eng(id,sl.t.getEnglish(),sl.t.getWritten()));
					break;
					
				case "his":
					e.setCourse("History");
					
					String info1 = " O'quvchi ism sharfi: "+e.getName()+" "+e.getSurname()+"\n"+"Yoshi: "+
							e.getAge()+"\n"+"Kurs Nomi: "+e.getCourse()+"\n"+"Telefon Raqami: "+e.getNumber()+
							"\n"+"Telegramdagi userNamemi: "+e.getUserName();
					
					executor(Send.create().engS(info1));
					aexecutor(Send.create().eng(id,sl.t.getHistory(),sl.t.getWritten()));
					break;
					
				case "math":
					e.setCourse("Mathematics");
					
					String info2 = " O'quvchi ism sharfi: "+e.getName()+" "+e.getSurname()+"\n"+"Yoshi: "+
							e.getAge()+"\n"+"Kurs Nomi: "+e.getCourse()+"\n"+"Telefon Raqami: "+e.getNumber()+
							"\n"+"Telegramdagi userNamemi: "+e.getUserName();
					
					executor(Send.create().engS(info2));
					aexecutor(Send.create().eng(id,sl.t.getMath(),sl.t.getWritten()));
					break;
				
				case "bio":
					e.setCourse("Biology");
					
					String info3 = " O'quvchi ism sharfi: "+e.getName()+" "+e.getSurname()+"\n"+"Yoshi: "+
							e.getAge()+"\n"+"Kurs Nomi: "+e.getCourse()+"\n"+"Telefon Raqami: "+e.getNumber()+
							"\n"+"Telegramdagi userNamemi: "+e.getUserName();
					
					executor(Send.create().engS(info3));
					aexecutor(Send.create().eng(id,sl.t.getBiology(),sl.t.getWritten()));
					break;

				}
	        	
	        }
	        	
	           
	}
		
		
		

	public String getBotUsername() {
		return "wiki41_bot";
	}

	@Override
	public String getBotToken() {
		return "1375446771:AAHvFvBfEMdMnNtZgwnHyPnHAx1KLbvKKuU";
	}
	
	//Text Sender
	public void executor(SendMessage m) {
		try {
			execute(m);
		}
		catch(TelegramApiException e) {
			e.printStackTrace();
		}
		
	}
	
	//Location Sender
	public void lexecutor(SendLocation l) {
		try {
			execute(l);
		}
		catch(TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	// AnswareCallbackQuery sender
	public void aexecutor(AnswerCallbackQuery an) {
		try {
			execute(an);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	//Photo sender
		public void pexecutor(SendPhoto p) {
			try {
				execute(p);
			}
			catch(TelegramApiException e) {
				e.printStackTrace();
			}
		}
		
		//File sender
		public void fexecutor(SendDocument doc) {
			try {
				execute(doc);
			}
			catch(TelegramApiException e) {
				e.printStackTrace();
			}
		}
		
		//Video Sender
		
		public void vexecutor(SendVideo doc) {
			try {
				execute(doc);
			}
			catch(TelegramApiException e) {
				e.printStackTrace();
			}
		}
}
	


