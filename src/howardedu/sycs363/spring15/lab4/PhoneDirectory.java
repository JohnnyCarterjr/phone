package howardedu.sycs363.spring15.lab4;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class PhoneDirectory{
	


	//..............  KEY , VALUE
	private  HashMap<String,String> directoryMap = new HashMap<String,String>();

	/*
	public PhoneDirectory(){}
	public PhoneDirectory(String phoneDirectoryFile){}
	public String lookup(String personName){}
	public void addorChangeEntry(String name, String phoneNumber){}
	public void deleteEntry(String name){}
	public void write(){}
	*/


	public 	PhoneDirectory() {
		freadPhoneDirectory("infile.txt");

	}// end PhoneDirectory()

	public PhoneDirectory(String phoneDirectoryFile) {
		directoryMap.put("","");
		freadPhoneDirectory(phoneDirectoryFile);

	}// end PhoneDirectory(String phoneDirectoryFile)


	private void freadPhoneDirectory(String filename)
	{
		try {
				URL file = getClass().getResource(filename);
				//
				Scanner in = new Scanner(new File(file.toURI()));
				//
				String afirstname;
				String alastname;
				String aphonenumber;
				
							
				while( in.hasNext() )  
				{
					afirstname   = in.next();
					alastname    = in.next();
					aphonenumber = in.next();
					//			
					directoryMap.put(afirstname+" "+alastname,aphonenumber);
					//
					System.out.printf("%s %s %s \n" , afirstname, alastname, aphonenumber);
				}
							
					//
					in.close();
					//
					System.out.println("Data from input file loaded !");


				} catch(FileNotFoundException e) {
							
					e.printStackTrace();

				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		

	}// end freadPhoneDirectory(String filename)



	public String lookup(String personName){
			
			
			if( directoryMap.containsKey(personName) ) {// test member exist in PhoneDirectory 

				return directoryMap.get(personName);// return Phone Number 

			} else {
				
				System.out.println("Is not in Phone Directory");
				return "";
				

			}// test
	}// end 



	public void deleteEntry(String name) {
		
		if( directoryMap.containsKey(name) ) { // test member exist in PhoneDirectory 
		
			directoryMap.remove(name);  // remove member
		
		} else {
		
			System.out.println("Is not in Phone Directory" );			
		
		}// test

	}// end deleteEntry(String name) {
		


	public void addorChangeEntry(String name, String phoneNumber){


		if(directoryMap.containsKey(name)){// test member exist in phone Directory 
		
			directoryMap.remove(name);// remove member
			directoryMap.put(name,phoneNumber); // write member
			System.out.println("Changed member information in Phone Directory" );

		} 
		else 
		{

			directoryMap.put(name,phoneNumber); // add new member
			System.out.println("Add new member to Phone Directory" );			
		
		}// test


	}// end addorChangeEntry(String name, String phoneNumber)

	public void write(){
		
		try
		{
			FileWriter fw = new FileWriter("outfile.txt");
			PrintWriter pw = new PrintWriter(fw);

			for(Entry<String, String> kv : directoryMap.entrySet()) {
				pw.println( directoryMap.keySet() + " " + directoryMap.values() ); // write memebers into file 
			}// itr PhoneDirectory Entries

			// close printwriter
			pw.close();

		}// end try
		catch(IOException e)
		{
			e.printStackTrace();
		}// catch

	}// end write()



}// end  PhoneDirectory class

