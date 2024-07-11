package project;

import java.util.* ;
import java.text.ParseException;
import java.text.SimpleDateFormat ;
public class Main{
static int[]available=new int[6];
static String ticketN[][]=new String[100][3];
static double ticketF[][] = new double [100][3];
static int ticketI[][] = new int [100][3];
static double pay[] = new double[20];
static double change[] = new double[20];
static int z=0,to=0;
static String search,again;
public static void main(String []args) {
	Scanner s=new Scanner(System.in);
	int un,pw,ch,re=1;
	String nx="y";
	Reservation rs=new Reservation();
		System.out.println("Enter the User name->");
	un=s.nextInt();
	System.out.println("Enter the Password->");
	pw=s.nextInt();
	if(un==1 && pw==1) {
		for(int i=0;i<6;i++) {
			available[i]=20;
		}
		
		while(nx.equalsIgnoreCase("y")) {
			rs.Start();
			ch=s.nextInt();
		switch(ch){
			case 1:
				rs.Destination();
				System.out.println("Do you want another transasction[Y/N]");
				nx=s.next();
				if(nx.equalsIgnoreCase("y")){
					rs.Start();
				}
				else if(nx.equalsIgnoreCase("n")) {
					nx="n";
				}
				break;
			case 2:
				
				rs.Destination();
				
				rs.Passengers();
				System.out.println("Do you want another transasction[Y/N]");
				nx=s.next();
				if(nx.equalsIgnoreCase("y")){
					rs.Start();
				}
				else if(nx.equalsIgnoreCase("n")) {
					nx="n";
				}
				break;
			case 3:
				rs.Billing();
				System.out.println("Do you want another transasction[Y/N]");
				nx=s.next();
				if(nx.equalsIgnoreCase("y")){
					rs.Start();
				}
				else if(nx.equalsIgnoreCase("n")) {
					nx="n";
				}
				break;
			case 4:
				rs.view();
				System.out.println("Do you want another transasction[Y/N]");
				nx=s.next();
				if(nx.equalsIgnoreCase("y")){
					rs.Start();
				}
				else if(nx.equalsIgnoreCase("n")) {
					nx="n";
				}
				break;
			case 5:
				System.out.println("Thank You!");
				nx="n";
				break;
		}
	}
}
	
	
}
}
