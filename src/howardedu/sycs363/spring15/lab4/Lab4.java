package howardedu.sycs363.spring15.lab4;

public class Lab4 
{
	public static void main(String[] args) {
		

		PhoneDirectory phoneDir1 = new PhoneDirectory();
		String phone_name;
		String phone_number;

		phone_name = "Barack Obama";
		phone_number = phoneDir1.lookup(phone_name);
		System.out.println( phone_name + " : " + phone_number );
		

	} // end main

}// end of Lab 4 class