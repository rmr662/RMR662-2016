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
	final static String MESSAGE = "RMR 662 rocks client";
	final static String SHAKE = "RMR 662 rocks server";
	
	public Communicator(){
		
	}
	
	public void run(){
		InetAddress server = findIp(IP, PORT, MESSAGE, SHAKE); 
		String[] componentNames = new String[Robot.parts.length];
		try {
			ServerSocket sSocket = new ServerSocket(PORT);
			
			Socket client = sSocket.accept();
			boolean socketOpen = false;
			InputStreamReader inStream = new InputStreamReader(client.getInputStream());
			BufferedReader messageSender = new BufferedReader(inStream);
			PrintWriter messageOutput = new PrintWriter(client.getOutputStream());
			for(Component comp : Robot.parts){
				messageOutput.println(comp.getClass().getCanonicalName());
			}
			while(socketOpen){
				String message = messageSender.readLine();
				if(message.equals("close")){
					sSocket.close();
					inStream.close();
					messageOutput.close();
					messageSender.close();
				}
				else{
					for(int i = 0; i < componentNames.length; i++){
						if(componentNames[i].equals(message)){
							Robot.compDisabled
						}
					}
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public InetAddress findIp(String ip, int port, String message, String handshake){
		InetAddress address = null;
		try {
			boolean foundServer = false;
			
			InetAddress group = InetAddress.getByName(ip);
			MulticastSocket broadcaster = new MulticastSocket(port);
			broadcaster.joinGroup(group);
			DatagramPacket findServer = new DatagramPacket(message.getBytes(), message.length(), group, port);
			while(!foundServer){
				broadcaster.send(findServer);
				byte[] buf = new byte[1000];
				DatagramPacket recv = new DatagramPacket(buf, buf.length);
				String received = new String(buf);
				broadcaster.receive(recv);
				address = recv.getAddress();
				if(received.equals(handshake)){
					foundServer = true;
					
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
		
		return address;
	}
}
