package reliabletransferprotocol_tcp_simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author paulo
 */
public class main {

	public static Scanner scanner;
	public static final int LOST_PROBABILITY = 3;				//From 0 to 100
	public static final int CORRUPT_PROBABILITY = 10;			//From 0 to 100
	public static final int NUMBER_OF_PACKETS = 20;
	public static List<Packet> packetList;
	public static ArrayList<String> listOfMessagesToBeSent;
	static Packet lasPacketSent;
	static Sending_A A_side;
	static Receiving_B B_side;
	static boolean startSending;
	static int packetsSent;
	
	
	
	static int delayToStartTimer = 5000;   // delay de 5 seg.
	static int intervalOfEachPacket = 1000;  // intervalo de 1 seg.
	static Timer timer = new Timer();
 
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		
		scanner = new Scanner(System.in);
		A_side = new Sending_A();
		B_side = new Receiving_B();
		packetList = new ArrayList<Packet>();
		listOfMessagesToBeSent = new ArrayList<>();
		packetsSent = 0;
		startSending = false;
		A_side.createPacketsToBeSent();
		startTimer();
		
		
	}
	

	

	private static void startTimer() {
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if(!startSending){
					sendPacket();
				}
				else{
					receivePacket();
					if(packetsSent < packetList.size()){
						sendPacket();
					}else{
						timer.cancel();
					}
				}
				startSending = true;
			}
		}, delayToStartTimer, intervalOfEachPacket);
	}
	
	static private void receivePacket() {
		
	}

	static private void sendPacket() {
		System.out.println("Sending packet number: " + (++packetsSent));
	}
	
	
	
}
