package com.unicommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TV_Remote implements Remote_Contol{

	int channel = 0;
	int volume = 0;
	int lastChannel = 250;
	int firstChannel = 1;
	boolean onstatus = false;
	boolean mute = false;
	ArrayList<Integer> favourite = new ArrayList<Integer>(100);	
	int lowestVolumentlevel = 0;
	int highestVolumentlevel = 100;
    Map<String, Integer> allChannels = new HashMap<>();


	@Override
	public void switchOnOff() {
		// TODO Auto-generated method stub
		onstatus =!onstatus;
	}


	@Override
	public void setChannel(int newchannel) {
		// TODO Auto-generated method stub
		channel = newchannel;
		System.out.println("Inside New Channel" + channel);
	}
	@Override
	public void increaseChannel() {

		if (onstatus && channel < lastChannel)
			channel++;
		else if (onstatus && channel == lastChannel)
			channel = firstChannel;
		// TODO Auto-generated method stub
		System.out.println("Inside Increase Channel");

	}

	@Override
	public void decreaseChannel() {
		// TODO Auto-generated method stub
		if (onstatus && channel > firstChannel)
			channel++;
		else if (onstatus && channel == firstChannel)
			channel = lastChannel;
		System.out.println("decrease Channel");
	}

	@Override
	public void mute() {
		// TODO Auto-generated method stub
		mute=!mute;
		System.out.println("TV is in Mute state");
	}

	
	
	@Override
	public void setFavourite() {
		favourite.add(channel);
				
		// TODO Auto-generated method stub
		System.out.println("List of favourite channel" +favourite);
	}

	@Override
	public void increaseVolume() {
		// TODO Auto-generated method stub
	 if (volume<highestVolumentlevel)
		 volume++;
	 	System.out.println("Increase volume");
	}

	@Override
	public void decreaseVolume() {
		// TODO Auto-generated method stub
		if (volume > lowestVolumentlevel )
			volume--;
		System.out.println("decrease Volume");

	}

	@Override
	public void listAllChannel() {
		// TODO Auto-generated method stub
		System.out.println("List All Channel" +allChannels);

	}
		
}
