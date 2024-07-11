package project;

import java.util.*;
import java.util.Scanner;
public class Reservation extends Main {
	Scanner s=new Scanner(System.in);
	
	void Start() {
		System.out.println("--------------------------------------------");
		System.out.println("-- BUS RESERVATION AND TICKETING SYSTEM   --");
		System.out.println("--------------------------------------------");
		System.out.println("--  1  Destination                     --");
		System.out.println("--  2  Passengers                      --");
		System.out.println("--  3  Billing                         --");
		System.out.println("--  4  View                            --");
		System.out.println("--  5  Exit                            --");
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------\n");
		System.out.println("Enter Choice->");
	}
	 void Destination() {

		System.out.println("-----------------------------------------");
		System.out.println("--   DESTINATION     FARE    SEAT  --");
		System.out.println("-----------------------------------------");
		System.out.println("-- 1.)SALEM         50rs      "+available[1]+" --");
		System.out.println("-- 2.)RASIPURAM     60rs      "+available[2]+" --");
		System.out.println("-- 3.)CHENNAI       80rs      "+available[3]+" --");
		System.out.println("-- 4.)ERODE         50rs      "+available[4]+" --");
		System.out.println("-- 5.)COIMBATORE    90rs      "+available[5]+" --");
		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");
		System.out.println("Diff abled, STUDENT, & SENIOR CITIZEN with 20% DISCOUNT!!!\n");	
	}
	void Passengers() {
		int print=1;
		if(available[1]<=0 ||available[2]<=0 ||available[3]<=0 ||available[4]<=0 ||available[5]<=0) {
			System.out.println("The Seats are filled !!!!");
		}
		else {
			int re=1;
			while(re==1) {
				System.out.println("Enter Passengers name->");
				ticketN[z][0]=s.next();
				re=0;
				for(int i=0;i<z;i++) {
					if(ticketN[i][0].equalsIgnoreCase(ticketN[z][0])){
						System.out.println("Passengers name is already booked");
						re=1;
					}
				}
			
			}
			re=1;
			while(re==1) {
				System.out.print("ENTER DESTINATION [number]: ");
				to = s.nextInt();
				if(to<1 || to>5){
					System.out.println("Invalid Input!");
					re=1;
				}
				for(int i=1; i<=5; i++){
					if(to==i){
						if(available[to]==0){
							System.out.println("Sorry, We don't have available seat!");
							re=1;
						}
						re=0;
					}
				}
			}
			String dest[] = { " ", "SALEM", "RASIPURAM", "CHENNAI", "ERODE", "COIMBATORE"};
			double fare[] = { 0,50,60,80,50,90};
			ticketN[z][1] = dest[to];
			ticketF[z][0] = fare[to];
			re=1;
			while(re==1){
			s.nextLine();
			System.out.print("Enter no of Passengers-> ");
			ticketI[z][0] = s.nextInt();

				for(int p=1; p<=5; p++){
					if(to==p){
						print=1;
						available[to] = available[to]-ticketI[z][0];
						
						if(available[to]<0){
							System.out.print("Sorry, We don't have seat available for " +ticketI[z][0] +" person\n");
							available[to] = available[to]+ticketI[z][0];
							System.out.print("We only have " +available[to] +" seat available\n");
							re=1;
							print=0;
						}
						else{
							re=0;
						}
					}
				}

			}
			re=1;
			while(re==1){
				System.out.print("HOW MANY PASSENGERS HAVE DISCOUNT?-> ");
				ticketI[z][1] =s.nextInt();
			
				if(ticketI[z][1]>ticketI[z][0]){
					
					System.out.println("Invalid Input!");
					System.out.println("No. of Passengers are only " +ticketI[z][0] +"!");
				re=1;
				}
				else{
					break;
				}
			}
			if(print==1){
				System.out.println("---------------------------------------------------");
				System.out.println("--                     DETAILS                   --");
				System.out.println("---------------------------------------------------");
				System.out.println("PASSENGER'S NAME               -> " + ticketN[z][0]);
				System.out.println("PASSENGER'S DESTINATION        -> " + ticketN[z][1]);
				System.out.println("FARE PRICE                     -> " + ticketF[z][0]);
				System.out.println("NO. OF PASSENGERS              -> " + ticketI[z][0]);
				System.out.println("NO. OF PASSENGERS WITH DISCOUNT-> " + ticketI[z][1]);
				System.out.println("---------------------------------------------------");
				System.out.println("---------------------------------------------------");
				ticketN[z][2]="0";
				double discount=(ticketF[z][0]-(ticketF[z][0]*0.2))*ticketI[z][1];
				ticketF[z][2]= ((ticketI[z][0]-ticketI[z][1])*ticketF[z][0])+discount;
				re=0;
			}
			z++;
		}
	}
	void Billing(){
		int re=1;
		while(re==1) {
			System.out.println("Enter the user name->");	
			search =s.next();
			int s1=1;
			for(int i=0;i<z;i++) {
			if(search.equalsIgnoreCase(ticketN[i][0])) {
				System.out.println("-----------------------------------------");
				System.out.println("--              DETAILS                --");
				System.out.println("-----------------------------------------");
				System.out.println("PASSENGER'S NAME: " + ticketN[i][0]);
				System.out.println("PASSENGER'S DESTINATION : " + ticketN[i][1]);
				System.out.println("FARE PRICE:" + ticketF[i][0]);
				System.out.println("NO. OF PASSENGERS: " + ticketI[i][0]);
				System.out.println("NO. OF PASSENGERS WITH DISCOUNT: " + ticketI[i][1]);
				System.out.println("-----------------------------------------");
				System.out.println("-----------------------------------------");
				s1=0;
				re=0;
				
				if(ticketN[i][2].equals("x")) {
					System.out.println("Already paid!!!");
					re=0;
				}
				else {
					ticketN[i][2]="x";
					re=1;
					while(re==1) {
						System.out.println("Passengers total fare->"+ticketF[i][2]);
						System.out.println("Enter ammount to pay->");
						pay[i]=Double.parseDouble(s.next());
						change[i]=pay[i]-ticketF[i][2];
						if(change[i]<0){
							System.out.println("not a valid ammount!!!");
							re=1;
						}
						else{
							System.out.println("CHANGE->  "+change[i]);
							System.out.println("");
							re=0;
						}
					}
				}
			}
			}
			if(s1==1) {
				System.out.println("Passenger name is not found->");
				int q=1;
				while(q==1) {
					System.out.print("Do you wish to continue with this transaction!!! [Y/N]-> ");
					again=s.next();
					if(again.equalsIgnoreCase("y")){
						q=0;
					}
					else if (again.equalsIgnoreCase("n")){
						q=0;
						re=0;
						
					}
					else{
						System.out.println("Invalid input!!!");
					}
				}
			}
		}
	}
	void view() {
		int sx=1;
		while(sx<=3) {
			System.out.println("Enter the passengers name->");
			search=s.next();
			int s1=1;
			for(int i=0;i<=z;i++) {
				if(search.equalsIgnoreCase(ticketN[i][0])) {
					System.out.println("-----------------------------------------");
					System.out.println("--              DETAILS                --");
					System.out.println("-----------------------------------------");
					System.out.println("PASSENGER'S NAME-> " + ticketN[i][0]);
					System.out.println("PASSENGER'S DESTINATION -> " + ticketN[i][1]);
					System.out.println("FARE PRICE-> " + ticketF[i][0]);
					System.out.println("NO. OF PASSENGERS-> " + ticketI[i][0]);
					System.out.println("NO. OF PASSENGERS WITH DISCOUNT-> " + ticketI[i][1]);
					System.out.println("TOTAL FARE PRICE-> " + ticketF[i][2]);
					if(ticketN[i][2].equals("x")){
						System.out.println("PAY->  " +pay[i]);
						System.out.println("CHANGE->  " +change[i]);
						System.out.println("STATUS-> PAID");
					}
					else{
						System.out.println("STATUS: NOT PAID");
					}
					System.out.println("-----------------------------------------");
					System.out.println("-----------------------------------------");
					s1=0;
				    sx=4;
				}
			}
			if(s1==1) {
				System.out.println("Passengers name not found!!!");
				sx++;
			}
			
		}
	}
}
