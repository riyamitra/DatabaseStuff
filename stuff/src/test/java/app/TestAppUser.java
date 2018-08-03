package app;

import java.util.Calendar;
import java.util.Date;

import org.bson.types.ObjectId;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import appdao.AppUserDao;

public class TestAppUser {
	public static void main(String args[]) {
		Faker faker = new Faker();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -faker.number().numberBetween(10, 20));
		Date dateBefore30Days = cal.getTime();
		cal.add(Calendar.DATE, -faker.number().numberBetween(20, 50));
		Date dateBefore40Days = cal.getTime();
		Gson gson = new Gson();
		AppUser appUser = new AppUser(faker.name().lastName(), faker.internet().emailAddress(), dateBefore30Days, dateBefore40Days);
		
		AppUserDao appUserDao = new AppUserDao();
		//System.out.println(gson.toJson(appUserDao.find("password", "Cole"))); ;
		
		//appUserDao.insertAppUser(appUser);
		//appUserDao.find("password", "Jones");
		//appUserDao.readUser(appUser);
		appUserDao.deleteUser("_id", new ObjectId("5b61663497bf321960482288"));
		//appUserDao.updateUser("password","email", "Jones", "302sdf52f4s5");
		//appUserDao.readUser("password", "Jones");
	}
}
