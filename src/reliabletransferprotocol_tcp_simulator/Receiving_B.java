/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reliabletransferprotocol_tcp_simulator;

/**
 *
 * @author paulo
 */
public class Receiving_B {
	
	Packet packetReceived;
	
	public void B_Input(Packet packetReceived){
		this.packetReceived = packetReceived;
		verifyCheckSum();
	}

	private void verifyCheckSum() {
		int checkSum = checkSumCalculation();
		if(checkSum == packetReceived.getCheckSum()){
			System.out.println("TÁ OK");
		}
		else{
			System.out.println("NÃO TÁ OK");
		}
	}
	
	private int checkSumCalculation() {
		int checkSum = 0;
		for(int i = 0; i < packetReceived.message.length(); i++){
			checkSum += packetReceived.message.charAt(i) - 96;
		}
		return checkSum;
	}
	
}
