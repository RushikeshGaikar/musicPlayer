package com.jspiders.musicPlayerHibernate.dao;

import java.util.Scanner;

public class MainMenu {

	static Scanner sc = new Scanner(System.in);
	static boolean loop = true;

	 Operations operations = new Operations();

	public static void main(String[] args) {
		MainMenu menu = new MainMenu();

		while (loop) {
			MainMenu.musicPlayer();
		}
	}

	public static void musicPlayer() {

		System.out.println("Select options :\n1.Play Songs \n2. Add Song or Remove Song \n3. Update Song \n4.Exit");
		System.out.println("-----------------------------------------------------------");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println(" Choose Your Option : \n1. choose to play \n2. Play All \n3. Go Back");
			int choice1 = sc.nextInt();
			switch (choice1) {
			case 1:
				Operations.choseToPlaySong();
				
				break;
			case 2:

				Operations.playAllSongs();
				break;

			case 3:
				System.out.println("Going Back Wait......");
				MainMenu.musicPlayer();
				break;

			default:
				System.out.println("Enter valid choice");
				break;
			}
			
			break;

		case 2:
			System.out.println("Choose Option to Add/Remove Song : \n1.Add Song \n2. Remove Song \n3. Go Back");
			int choose2 =sc.nextInt();
			switch (choose2) {
			case 1:
				Operations.addSongs();
				
				break;
			case 2:
				Operations.removeSongs();
				
				break;
				
			case 3:
				System.out.println("Going Back Wait.....");
				
				break;

			default:
				System.out.println("Pease Enter Valid Choice");
				break;
			}
			break;

		case 3:
			System.out.println("What do you want to Update in Song :\n1. i.Update Song Name \n ii.Singer Name \n iii.Movie Name \n iv.Song Duration \n2.Go Back");
			int choose3 = sc.nextInt();
			switch (choose3) {
			case 1:
				Operations.updateSongs();
				
				break;
			case 2:
				System.out.println("Going Back......");

			default:
				System.out.println("Please Enter Valid Option.");
				break;
			}
			break;

		case 4:
			System.out.println("Please Wait.......Existing.");
			loop =false;
			
		}
	}
}
