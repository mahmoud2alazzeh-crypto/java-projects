package oop;

public class Callingclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			UserAcount obj = new UserAcount(1000, 100, 12345);
			System.out.println("WELCOME TO ARAB BANK ATM MACHINE");
		    obj.startatm();//we call the method by the object we declared in the main
            
	}

}
