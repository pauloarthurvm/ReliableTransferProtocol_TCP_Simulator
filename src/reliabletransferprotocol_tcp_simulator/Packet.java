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
public class Packet {
	int sequenceNumber;
	int acknowledgeNumber;
	int checkSum;
	String message;
	int messageSize;
	char[] payload = new char[20];

	public Packet(int sequenceNumber, int acknowledgeNumber, String message) {
		this.sequenceNumber = sequenceNumber;
		this.acknowledgeNumber = acknowledgeNumber;
		this.message = message;
		checkSumCalculation();
		messageSizeCalculation();
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public int getAcknowledgeNumber() {
		return acknowledgeNumber;
	}

	public String getMessage() {
		return message;
	}

	public int getCheckSum() {
		return checkSum;
	}

	public char[] getPayload() {
		return payload;
	}

	public void setPayload(char[] payload) {
		this.payload = payload;
	}

	public int getMessageSize() {
		return messageSize;
	}

	private void checkSumCalculation() {
		checkSum = 0;
		for(int i = 0; i < message.length(); i++){
			checkSum += message.charAt(i) - 96;
		}
	}
	
	private void messageSizeCalculation() {
		messageSize = 0;
		for(int i = 0; i < message.length(); i++){
			messageSize += message.charAt(i) - 96;
		}
	}

	@Override
	public String toString() {
		return "Packet{" + "sequenceNumber=" + sequenceNumber + ", acknowledgeNumber=" + acknowledgeNumber + ", checkSum=" + checkSum + ", message=" + message + '}';
	}
	
}
