/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reliabletransferprotocol_tcp_simulator;

import java.util.ArrayList;
import java.util.Random;
import static reliabletransferprotocol_tcp_simulator.main.*;

/**
 *
 * @author paulo
 */
public class Sending_A {
	
	int lastSequenceNumberSent = 0;
	ArrayList<String> listOfMessagesToBeSent;

	public int getLastSequenceNumberSent() {
		return lastSequenceNumberSent;
	}

	public void setLastSequenceNumberSent(int lastSequenceNumberSent) {
		this.lastSequenceNumberSent = lastSequenceNumberSent;
	}
	
	
	public void A_output(String message){
		
	}

	static String createMessage(){
		//Creates a message of same random char with a random size
		Random random = new Random();
		int randomCharNumber = random.nextInt(25) + 97;			//Alphabet with 25 letters and char 'a' is 97
		int randomMessageSize = random.nextInt(10) + 11;		//Message with min 11 and max 20 chars
		String message = "";
		for(int i = 0; i < randomMessageSize; i++){
			message = message + (char)randomCharNumber;
		}
		return message;
	}
	
	void createPacketsToBeSent() {
		for (int i = 0; i < NUMBER_OF_PACKETS; i++){
			packetList.add(new Packet(A_side.getLastSequenceNumberSent(), 0, createMessage()));
			A_side.setLastSequenceNumberSent(A_side.getLastSequenceNumberSent() + packetList.get(packetList.size() - 1).getMessageSize());
			System.out.println(packetList.get(i).toString());
		}
	}
	
}
