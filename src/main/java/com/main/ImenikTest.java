package com.main;

import java.util.Scanner;

public class ImenikTest {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	try {
		int unos= 0;

		while (unos!= 3) {
	System.out.println("............................................");
	System.out.println("Unesite broj koji zelite: ");
	System.out.println("1.Za registraciju korisnika.");
	System.out.println("2.Imenik.");
	System.out.println("3.Izlaz.");
	unos = input.nextInt();
	switch(unos){
	
	case 1:
	System.out.println("Registracija: ");
    AppAdmin.main(args);
    break;
    
	case 2: 
	//  
	System.out.println("...........................................");
	AppStudent.main(args);
    break;
	
	case 3:
		System.out.println("Exit");
		break;
	}}

} catch (Exception e) {

System.out.println(">>Unesite odgovarajuci broj - integer!<<");
System.out.println(">>Pokusajte ponovo.!<<");
System.out.println(">>Exit<<");
}
}
}
	