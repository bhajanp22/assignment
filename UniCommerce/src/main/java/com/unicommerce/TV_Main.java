package com.unicommerce;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TV_Main {
	public static void main(String[] args) {

		Remote_Contol rmt = new TV_Remote();
		rmt.switchOnOff();
		rmt.decreaseChannel();
		rmt.decreaseVolume();
		rmt.increaseChannel();
		rmt.increaseVolume();
		rmt.listAllChannel();
		rmt.mute();
		rmt.setChannel(204);
		rmt.setFavourite();

	}


}