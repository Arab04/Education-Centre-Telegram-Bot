package com.Project.Tester2;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Menues {
	
	private Menues() {}
	
	public static Menues create() {
		Menues m = new Menues();
		return m;
	}
	
	
	//Main Menu
	public SendMessage mainMenu(Long id,String mainm,String courses,String admin,String location,String payment,String settings) {
		SendMessage m = KButton.create(id)
				.setText(mainm)
				.row()
				.button(courses)
				.button(admin)
				.endRow()
				.row()
				.button(location)
				.button(payment)
				.endRow()
				.row()
				.button(settings)
				.endRow()
				.build();
		return m;
	}
	
	//Courses
	public SendMessage secondMenu(Long id,String secondm,String eng,String math,String his,String bio,String back) {
		SendMessage m = KButton.create(id)
				.setText(secondm)
				.row()
				.button(eng)
				.button(math)
				.endRow()
				.row()
				.button(his)
				.button(bio)
				.endRow()
				.row()
				.button(back)
				.endRow()
				.build();
		return m;
	}
	
	
	//Language menu
	public SendMessage language(Long id) {
		SendMessage m = KButton.create(id)
				.setText("Welcome")
				.row()
				.button("O'zbek")
				.endRow()
				.row()
				.button("Русский")
				.endRow()
				.row()
				.button("English")
				.endRow()
				.build();
		return m;
	}
	
	//Language menu
		public SendMessage language(Long id,String text,String uzbek,String russia,String english,String back) {
			SendMessage m = KButton.create(id)
					.setText(text)
					.row()
					.button(uzbek)
					.endRow()
					.row()
					.button(russia)
					.endRow()
					.row()
					.button(english)
					.endRow()
					.row()
					.button(back)
					.endRow()
					.build();
			return m;
		}
	
	//Settings Menu
	public SendMessage settings(Long id,String settings,String editName,String editSurname,String editNumber,String changeLanguage,String back) {
		SendMessage m = KButton.create(id)
				.setText(settings)
				.row()
				.button(editName)
				.button(editSurname)
				.endRow()
				.row()
				.button(editNumber)
				.button(changeLanguage)
				.endRow()
				.row()
				.button(back)
				.endRow()
				.build();
		return m;
				
	}
	
	//Switching to main menu after getting info from user
	public SendMessage switchToMainMenu(Long id,String textmainm,String mainmenu ) {
		SendMessage m = KButton.create(id)
				.setText(textmainm)
				.row()
				.button(mainmenu)
				.endRow()
				.build();
		return m;
	}
	
	//Payment Inline menu
	public SendMessage payment(Long id,String text) {
		SendMessage m = Inline.create(id)
				.setText(text)
				.row()
				.lbutton("PayMe", "https://payme.uz/home/transfer")
				.endRow()
				.row()
				.lbutton("Click", "https://click.uz/ru/perevod-s-karti-na-kartu")
				.endRow()
				.build();
		return m;
		
	}
	
	public SendMessage bio(Long id,String text,String enroll) {
		SendMessage m = Inline.create(id)
				.setText(text)
				.row()
				.button(enroll, "bio")
				.endRow()
				.build();
		return m;
	}
	
	public SendMessage eng(Long id,String text,String enroll) {
		SendMessage m = Inline.create(id)
				.setText(text)
				.row()
				.button(enroll, "eng")
				.endRow()
				.build();
		return m;
	}
	
	public SendMessage his(Long id,String text,String enroll) {
		SendMessage m = Inline.create(id)
				.setText(text)
				.row()
				.button(enroll, "his")
				.endRow()
				.build();
		return m;
	}
	
	public SendMessage math(Long id,String text,String enroll) {
		SendMessage m = Inline.create(id)
				.setText(text)
				.row()
				.button(enroll, "math")
				.endRow()
				.build();
		return m;
	}
}
