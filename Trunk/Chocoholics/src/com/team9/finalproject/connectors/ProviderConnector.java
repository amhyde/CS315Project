package com.team9.finalproject.connectors;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import com.team9.finalproject.DataManager;
import com.team9.finalproject.dataMembers.Member;

public class ProviderConnector implements ConnectorInterface{

	private DataManager dm;
	Scanner scan;
	
	public ProviderConnector()
	{
		scan = new Scanner(System.in);
		display(startScreen());
		dm = loadDataManager();
		commandLoop();
	}
	private String startScreen() {
		String s = "";
		s+=""+                                                                                             
				"              ,,                                    ,,                 ,,    ,,                  "+"\n"+
				"  .g8W0Wbgd `7MM                                  `7MM               `7MM    db                  "+"\n"+ 
				".dP`     `M   MM                                    MM                 MM                        "+"\n"+
				"M`           MMpMMMb.  ,pW-Wq.   ,p6-bo   ,pW-Wq.  MMpMMMb.  ,pW-Wq.  MM  `7MM  ,p6-bo  ,pP-Ybd  "+"\n"+
				"MM            MM    MM 6W     Wb 6M`  OO  6W     Wb MM    MM 6W     Wb MM    MM 6M`  OO  8I   `` "+"\n"+
				"MM.           MM    MM 8M     M8 8M       8M     M8 MM    MM 8M     M8 MM    MM 8M       `YMMMa. "+"\n"+
				" Mb.     ,    MM    MM YA.   ,A9 YM.      YA.   ,A9 MM    MM YA.   ,A9 MM    MM YM.      L.   I8 "+"\n"+
				"   =bmmmd`  .JMML  JMML. Ybmd9    YMbmd     Ybmd9 .JMML  JMML. Ybmd9 .JMML..JMML.YMbmd   M9mmmP` "+"\n";
                                                                                                                                                                                     
		s+="*************************************\n"
		  +"**** WELCOME PROVIDER ***************\n"
		  +"*************************************\n"
		  +"**** CHOCOHOLICS DATAMANAGER 1.0 ****\n"
		  +"**** A NEW PARADIGM IN CHOCOLATE ****\n"
		  +"*************************************\n"
		  +"**** COMMANDS ***********************\n"
		  +"**** H == HELP - Shows this list*****\n"
		  +"**** B == BILL - Bill for service****\n"
		  +"**** V == VALIDATE - Check Member****\n"
		  +"**** D == DIRECTORY - Shows Directory\n"
		  +"*************************************\n"
		  +"*************************************\n";
		
		  
		return s;
	}
	@Override
	public DataManager loadDataManager() {
		try
	      {
	         FileInputStream fileIn = new FileInputStream("/ChocoDataBase/ChocoData.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         DataManager temp = (DataManager) in.readObject();
	         in.close();
	         fileIn.close();
	         return temp;
	      }catch(IOException i)
	      {
	         //i.printStackTrace();
	         return new DataManager();
	      }catch(ClassNotFoundException c)
	      {
	         
	         //c.printStackTrace();
	         return new DataManager();
	      }
		
	}

	@Override
	public String commandLoop() {
		
		while(true)
		{
			display("Next Command?");
			String command = scan.next();
			switch(command.toUpperCase().charAt(0))
			{
				case 'H':
					display(help());
					break;
				case 'B':
					display("Enter Member ID to bill");
					String memberId = scan.next();
					String status = dm.validateMember(memberId);
					if(!(status.toLowerCase()).equals("active"))
					{
						display("Member Error: "+ status);
						break;
					}
					display("Enter your provider Number");
					String provId = scan.next();
					if(dm.findProvider(provId) == -1)
					{
						display("Provider number invalid");
						break;
					}
			}
			
		}
	}
	public String help()
	{
		String s = "**** COMMANDS ***********************\n"
				  +"**** H == HELP - Shows this list*****\n"
				  +"**** B == BILL - Bill for service****\n"
				  +"**** V == VALIDATE - Check Member****\n"
				  +"**** D == DIRECTORY - Shows Directory\n"
				  +"*************************************\n"
				  +"*************************************\n"; 
		return(s);
	}
	public String bill()
	{
		display("Enter Member ID to bill");
		String memberId = scan.next();
		String status = dm.validateMember(memberId);
		if(!(status.toLowerCase()).equals("active"))
		{
			return("Member Error: "+ status);
			
		}
		display("Enter your provider Number");
		String provId = scan.next();
		if(dm.findProvider(provId) == -1)
		{
			return("Provider number invalid");
		}
		display("Enter Service Code");
		String serviceCode = scan.next();
		return null;
		
	}

	@Override
	public String quit() {
		return dm.save()+"\nExiting";
	}

	@Override
	/**
	 * Since this is a Console Display,
	 * This method is just println();
	 * If we later make a GUI,
	 * This method would write info to
	 * the screen
	 * 
	 * @param output String to be displayed
	 */
	public String display(String output) {
		System.out.println(output);
		return null;
	}

}
