package com.jspiders.musicPlayerHibernate.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.musicPlayerHibernate.dto.Songs;

public class Operations {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpqlString;
	private static Query query;
	private static int result;
	private static Scanner sc = new Scanner(System.in);
	private static Songs song = new Songs();
	
	private static void openConnection() {
		factory =Persistence.createEntityManagerFactory("Music");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		
		
	}
	public static void choseToPlaySong() {
		System.out.println("Playing song please wait....");
		System.out.println("Loading Song List........");
		try {
			
		openConnection();
		transaction.begin();
		
		jpqlString = "from Songs";
		query = manager.createQuery(jpqlString);
		List<Songs> songs = query.getResultList();
		
		for(Songs song : songs) {
			System.out.println(song);
		}
		System.out.println("Enter Which Song you want to Play");
		int id = sc.nextInt();
		Songs song = manager.find(Songs.class, id);
		
		System.out.println(song);
		
		transaction.commit();
		} finally {
		closeConnection();
		}
	}
	
	public static void playAllSongs() {
		
		try {
			openConnection();
			transaction.begin();
			System.out.println("Playing All Songs.....");
			
			jpqlString = "from Songs";
			query = manager.createQuery(jpqlString);
			List<Songs> songs = query.getResultList();
			
			for(Songs song : songs) {
				System.out.println(song);
			}
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
	
	public static void addSongs() {
		try {
			openConnection();
			transaction.begin();
			System.out.println("How Many Songs you want to add");
			int add = sc.nextInt();
			for(int i = 1; i<=add;i++) {
				System.out.println("Enter Id of Song");
				int id = sc.nextInt();
				song.setId(id);
				
				System.out.println("Enter Name of Song");
				String name =sc.next();
				song.setName(name);
				
				System.out.println("Enter Singer Name");
				String singer = sc.next();
				song.setSinger_name(singer);
				
				System.out.println("Enter Movie/Album Name");
				String movie = sc.next();
				song.setMovie_album(movie);
				
				System.out.println("Enter Duration Of Song");
				double length= sc.nextDouble();
				song.setDuration(length);
				
				manager.persist(song);
				
				Songs song1 = manager.find(Songs.class, id);
				System.out.println(song1);
			}
			
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
	
	public static void removeSongs() {
		try {
			openConnection();
			transaction.begin();
			
			jpqlString ="from Songs";
			query = manager.createQuery(jpqlString);
			
			List<Songs> list = query.getResultList();
			for(Songs song : list) {
				System.out.println(song);
			}
			
			System.out.println("Which Id Song you want to Remove.");
			int remove = sc.nextInt();
			
			jpqlString ="delete from Songs where id ="+remove;
			query = manager.createQuery(jpqlString);
			result = query.executeUpdate();
			System.out.println("Query ok,"+ result +"row(s) Affected.");
			
			jpqlString ="from Songs";
			query = manager.createQuery(jpqlString);
			
			List<Songs> list1 = query.getResultList();
			for(Songs song1 : list1) {
				System.out.println(song1);
			}
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
	
	public static void updateSongs() {
		try {
			openConnection();
			transaction.begin();
			
			
			System.out.println("What do you Want to Update \n1.Song Name \n2.Singer Name \n3.Duration \n4.Movie/Album Name");
			System.out.println("Enter Your choise.");
			int update = sc.nextInt();
			
			if(update == 1) {
				System.out.println("Enter New Name");
				String nav =sc.next();
				System.out.println("Enter Id of Song.");
				int up =sc.nextInt();
				jpqlString = "update Songs set name="+"'"+nav+"'"+ "where id="+up;
				
				query = manager.createQuery(jpqlString);
				
				result = query.executeUpdate();
				System.out.println("Query ok,"+result +"row(s) affected.");
			}
				
			if(update == 2) {
				System.out.println("Enter new Singer Name.");
				String sing = sc.next();
				System.out.println("Enter Id of Song.");
				int up1 = sc.nextInt();
				jpqlString ="update Songs set singer_name= "+"'"+sing+"'"+"where id="+up1;
				
				query = manager.createQuery(jpqlString);
				result = query.executeUpdate();
				System.out.println("Query ok,"+result +"row(s) affected.");
				
				}
				
			if(update == 3) {
				System.out.println("Enter New Duration");
				double dur = sc.nextDouble();
				System.out.println("Enter Id of Song.");
				int up3 = sc.nextInt();
				jpqlString = "update Songs set duration="+dur+"where id="+up3;
				
				query = manager.createQuery(jpqlString);
				result = query.executeUpdate();
				System.out.println("Query ok,"+result +"row(s) affected.");

			}
				
			if(update == 4) {
				System.out.println("Enter new Movie/Album Name.");
				String movie= sc.next();
				System.out.println("Enter Id Of Song.");
				int up4 = sc.nextInt();
				jpqlString = "update Songs set movie_album="+"'"+movie+"'"+"where id="+up4;
				
				query = manager.createQuery(jpqlString);
				result = query.executeUpdate();
				System.out.println("Query ok,"+result +"row(s) affected.");
				
			}
				
			else  {
				
			System.out.println("Enter Valid Choice");
			}
			jpqlString ="update Songs ";
            query = manager.createQuery(jpqlString);
			
			List<Songs> list1 = query.getResultList();
			for(Songs song1 : list1) {
				System.out.println(song1);
			}
			
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
}
