package com.Project.Tester2;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApiContextInitializer.init();
		TelegramBotsApi api = new TelegramBotsApi();
		try {
		api.registerBot(new T());
		}
		catch(TelegramApiRequestException e) {
			e.printStackTrace();
		}
		
		System.out.println("started working");
				
    }
    
}
