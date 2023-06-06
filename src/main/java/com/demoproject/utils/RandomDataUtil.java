package com.demoproject.utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomDataUtil {
	private static final Faker fake =  new Faker();
	public static String getRandomStationName(){
		return fake.weather().description();
	}
	
	public static String getExternalId(){
		return fake.weather().description();
	}
	
	public static double getLongitude(){
		String f = fake.address().longitude();
		double d = Double.parseDouble(f);
		return d;
	}

	public static String getRandomName(){
		String name = fake.name().firstName();
		return name;
	}
	
	public static double getLatitude(){
		String f = fake.address().latitude(); 
		double d = Double.parseDouble(f);
		return d;
	}

	public static double getAltitude(){
		String f = fake.address().latitude();
		double d = Double.parseDouble(f);
		return d;

	}

	public static boolean getBoolean(){
		return new Random().nextBoolean();
	}

}
