package org.usfirst.frc.team662.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ServerSocket;

public class Communicator implements Runnable{
	
	final static String IP = "228.5.6.7";
	final static int PORT = 6789;
	final static int SOCK_PORT = 3456;
	final static String MESSAGE = "RMR 662 rocks client";
	final static String SHAKE = "RMR 662 rocks server";
	final static String COM_SHAKE = "all done";
	
	public Communicator(){
		
	}
	
	public void run(){
		findIp(IP, PORT, MESSAGE, SHAKE); 
		String[] componentNames = new String[Robot.parts.length];
		try {
			ServerSocket sSocket = new ServerSocket(SOCK_PORT);
			
			Socket client = sSocket.accept();
			boolean socketOpen = true;
			BufferedReader messageSender = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter messageOutput = new PrintWriter(client.getOutputStream());
			for(int i = 0; i < componentNames.length; i++){
				componentNames[i] = Robot.parts[i].getClass().getName();
				messageOutput.println(componentNames[i]);
			}
			messageOutput.println(COM_SHAKE);
			while(socketOpen){
				String message = messageSender.readLine();
				if(message.equals("close")){
					sSocket.close();
					messageOutput.close();
					messageSender.close();
					socketOpen = false;
				}
				else{
					for(int i = 0; i < componentNames.length; i++){
						if(componentNames[i].equals(message)){
							Robot.compDisabled[i] = !Robot.compDisabled[i];
						}
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void findIp(String ip, int port, String message, String handshake){
		try {
			boolean foundServer = false;
			
			InetAddress group = InetAddress.getByName(ip);
			MulticastSocket broadcaster = new MulticastSocket(port);
			broadcaster.joinGroup(group);
			DatagramPacket findServer = new DatagramPacket(message.getBytes(), message.length(), group, port);
			while(!foundServer){
				byte[] buf = new byte[1000];
				DatagramPacket recv = new DatagramPacket(buf, buf.length);
				broadcaster.receive(recv);
				String received = new String(buf);
				if(received.equals(handshake)){
					foundServer = true;
					broadcaster.send(findServer);
				}
			}
			broadcaster.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
