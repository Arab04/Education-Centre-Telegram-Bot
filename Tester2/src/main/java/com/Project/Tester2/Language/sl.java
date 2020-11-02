package com.Project.Tester2.Language;

public class sl {
	
public static Text t = new Text();
	
	public static void setUzb() {
		
		//Info about each course
		String eng = "#Ulashing \n Kurs Nomi: English \n Kurs 1 oylik narxi: 400 ming \n Haftalik Darslar: 1 haftada 3 martta \n O'qituvchi: David Byers";
		String his = "#Ulashing \n Kurs Nomi: History \n Kurs 1 oylik narxi: 400 ming \n Haftalik Darslar: 1 haftada 3 martta \n O'qituvchi: David Byers";
		String math = "#Ulashing \n Kurs Nomi: Mathematics \n Kurs 1 oylik narxi: 400 ming \n Haftalik Darslar: 1 haftada 3 martta \n O'qituvchi: David Byers";
		String bio = "#Ulashing \n Kurs Nomi: Biology \n Kurs 1 oylik narxi: 400 ming \n Haftalik Darslar: 1 haftada 3 martta \n O'qituvchi: David Byers";
		
		//Info about admins
		String admin1 = " Adminstrator:Zebo \nIsh vaqti: 9:00 dan 20:00 \nTelefon raqami: +99899 888-18-28";
		String admin2 = " Adminstrator:Shuhrat \nIsh vaqti: 9:00 dan 20:00 \nTelefon raqami: +99899 866-06-66";
		
		// Request Info about user
		t.setRequestName("Ismingizni kiriting");
		t.setRequestSurname("Familyangizni kiriting");
		t.setRequestNum("Telefon raqamingiz kiriting");
		t.setRequestage("yoshingiz kiriting");
		t.setSuccName("ismingiz o'zgartirildi: ");
		t.setSuccSurname("familyangiz o'zgartirildi: ");
		t.setSuccNum("raqamingiz o'zgartirildi: ");
		t.setWritten("Siz shu kursga yozildingiz \nadministrator siz bn tez orada aloqaga chiqadi");
		t.setSuccLang("Uzbek tiliga ozgardi");
		
		//Menu buttons
		t.setAdmin("Adminstrator");
		t.setBack("Orqaga");
		t.setCourses("Kurslar");
		t.setEnroll("Kursga yozilish");
		t.setLocation("Lokatsiya");
		t.setMainMenu("Bosh Menu");
		t.setPayment("Online Tolov");
		t.setSecondMenu("Kurslar");
		t.setSettings("Sozlamalar");
		t.setInlinePayment("Tolov turlaridan birini tanlang");
		t.setEditName("Ismni o'zgartirish");
		t.setEditSurname("Familyani o'zgartirish");
		t.setEditNumber("Telefon raqamni o'zgartirish");
		t.setChangeLanguage("Tilni o'zgartirish");
		
		//Courses
		t.setBiology("Biologiya");
		t.setEnglish("Ingliz tili");
		t.setHistory("Tarix");
		t.setMath("Matematika");
		
		
		//Subject Describtions
		t.setEngdes(eng);
		t.setHisdes(his);
		t.setMathdes(math);
		t.setBiodes(bio);
		
		//Admin info
		t.setAdmin1(admin1);
		t.setAdmin2(admin2);
		
		//SetLanguage
		t.setSetEnglish("Ingliz Tili");
		t.setSetRussia("Rus Tili");
		t.setSetUzbek("Uzbek Tili");
	}

	
	public static void setEng() {
		//Info about each course
				String eng = "#Share \nName of the course: English \nCost of the course per month: 400 thousand sums \nWeekly lessons: 3 times in a week \n Teacher: David Byers";
				String his = "#Share \nName of the course: History \nCost of the course per month: 400 thousand sums \nWeekly lessons: 3 times in a week \n Teacher: David Byers";
				String math = "#Share \nName of the course: Mathemetics \nCost of the course per month: 400 thousand sums \nWeekly lessons: 3 times in a week \n Teacher: David Byers";
				String bio = "#Share \nName of the course: Biology \nCost of the course per month: 400 thousand sums \nWeekly lessons: 3 times in a week \n Teacher: David Byers";
				
				//Info about admins
				String admin1 = " Adminstrator:Zebo \nWorking hours: from 9:00 till 20:00 \nPhone number: +99899 888-18-28";
				String admin2 = " Adminstrator:Shuhrat \nWorking hours: from 9:00 till 20:00 \nPhone number: +99899 866-06-66";
				
				// Request Info about user
				t.setRequestName("Type your name");
				t.setRequestSurname("Type your surname");
				t.setRequestNum("Type your number");
				t.setRequestage("Type your age");
				t.setSuccName("Name was changed to: ");
				t.setSuccSurname("Surname was changed to: ");
				t.setSuccNum("Number was changed to: ");
				t.setWritten("You have registered for this course \nadminstrator will soon call you back");
				t.setSuccLang("Changed to English");
				
				//Menu buttons
				t.setAdmin("Adminstrators");
				t.setBack("Back");
				t.setCourses("Courses");
				t.setEnroll("Enroll to the course");
				t.setLocation("Location");
				t.setMainMenu("Main Menu");
				t.setPayment("Online payment");
				t.setSecondMenu("Courses");
				t.setSettings("Settings");
				t.setInlinePayment("Choose one of them");
				t.setEditName("Edit Name");
				t.setEditSurname("Edit Surname");
				t.setEditNumber("Edit Number");
				t.setChangeLanguage("Change language");
				
				//Courses
				t.setBiology("Biology");
				t.setEnglish("English language");
				t.setHistory("History");
				t.setMath("Mathemetics");
				
				
				//Subject Describtions
				t.setEngdes(eng);
				t.setHisdes(his);
				t.setMathdes(math);
				t.setBiodes(bio);
				
				//Admin info
				t.setAdmin1(admin1);
				t.setAdmin2(admin2);
				
				//SetLanguage
				t.setSetEnglish("English");
				t.setSetRussia("Russia");
				t.setSetUzbek("Uzbek");
	}
	
	public static void setRus() {
		//Info about each course
		String eng = " #Share Название курса: Английский \nСтоимость курса в месяц: 400 тыс. \nСум Еженедельные занятия: 3 раза в неделю \nПреподаватель: Дэвид Байерс";
		String his = " #Share Название курса: История  \nСтоимость курса в месяц: 400 тыс. \nСум Еженедельные занятия: 3 раза в неделю \nПреподаватель: Дэвид Байерс";
		String math = " #Share Название курса: Математика \nСтоимость курса в месяц: 400 тыс. \nСум Еженедельные занятия: 3 раза в неделю \nПреподаватель: Дэвид Байерс";
		String bio = " #Share Название курса: Биология \nСтоимость курса в месяц: 400 тыс. \nСум Еженедельные занятия: 3 раза в неделю \nПреподаватель: Дэвид Байерс";
		
		//Info about admins
		String admin1 = "Администратор: Zebo \nВремя работы: с 9:00 до 20:00 \nТелефон: +99899 888-18-28";
		String admin2 = "Администратор: Шухрат \nВремя работы: с 9:00 до 20:00 \nТелефон: +99899 866-06-66";
		
		// Request Info about user
		t.setRequestName("Введите свое имя");
		t.setRequestSurname("Введите вашу фамилию");
		t.setRequestNum("Введите свой номер");
		t.setRequestage("Введите свой возраст");
		t.setSuccName("Имя было изменено на: ");
		t.setSuccSurname("Фамилия была изменена на: ");
		t.setSuccNum("Номер был изменен на: ");
		t.setWritten("Вы зарегистрировались на этот курс \nадминистратор скоро перезвонит вам");
		t.setSuccLang("изменен на русский");
		
		//Menu buttons
		t.setAdmin("Администраторы");
		t.setBack("Назад");
		t.setCourses("Курсы");
		t.setEnroll("Записаться на курс");
		t.setLocation("Место расположения");
		t.setMainMenu("Главное меню");
		t.setPayment("Онлайн платеж");
		t.setSecondMenu("Курсы");
		t.setSettings("Настройки");
		t.setInlinePayment("Выберите один из них");
		t.setEditName("Изменить имя");
		t.setEditSurname("Изменить фамилию");
		t.setEditNumber("Изменить номер");
		t.setChangeLanguage("Изменить язык");
		
		//Courses
		t.setBiology("Биология");
		t.setEnglish("Английский язык");
		t.setHistory("История");
		t.setMath("Математика");
		
		
		//Subject Describtions
		t.setEngdes(eng);
		t.setHisdes(his);
		t.setMathdes(math);
		t.setBiodes(bio);
		
		//Admin info
		t.setAdmin1(admin1);
		t.setAdmin2(admin2);
		
		//SetLanguage
				t.setSetEnglish("Английский");
				t.setSetRussia("Русский");
				t.setSetUzbek("Узбекский");
	}
}
