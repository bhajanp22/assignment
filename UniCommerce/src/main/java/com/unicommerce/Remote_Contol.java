package com.unicommerce;

public interface Remote_Contol {
public static final int channel = 0;
void start();
void stop();
void setChannel(int newchannel);
void increaseChannel ();
void mute();
void setFavourite();
void increaseVolume();
void decreaseVolume();
void decreaseChannel();
void listAllChannel();
}
