/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reliabletransferprotocol_tcp_simulator;

import java.util.Random;
import static reliabletransferprotocol_tcp_simulator.main.*;

/**
 *
 * @author paulo
 */
public abstract class Medium {
	
	Random random = new Random();
	
	void corruptPacket(Packet packet){
		if(random.nextInt(100) <= CORRUPT_PROBABILITY){
			packet.message.replace(packet.message.charAt(0), (char)(packet.message.charAt(0)+1));
		}
	}
	
	void lostPacket(){
		
	}
	
}
