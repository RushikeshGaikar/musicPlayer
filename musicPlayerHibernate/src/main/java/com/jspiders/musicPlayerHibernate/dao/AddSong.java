package com.jspiders.musicPlayerHibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.musicPlayerHibernate.dto.Songs;

public class AddSong {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("Music");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager  != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			Songs song = new Songs();
			song.setId(2);
			song.setName("Manali Trance");
			song.setMovie_album("The Shaukeens");
			song.setSinger_name("Neha Kakkar");
			song.setDuration(3.36);
			manager.persist(song);
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
}
