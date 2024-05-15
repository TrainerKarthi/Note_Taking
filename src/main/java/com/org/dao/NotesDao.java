package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dto.Notes;
import com.org.dto.User;

public class NotesDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Notes fetchNotesById(int notesId) {
		return em.find(Notes.class, notesId);
	}

	public boolean deleteNotesById(int id) {
		Notes notes = em.find(Notes.class, id);
		if (notes != null) {

			User user = notes.getUser();

			List<Notes> list = user.getNoteses();

			for (Notes note : list) {
				if (note.getId() == notes.getId()) {
					list.remove(note);
					break;
				}
			}

			et.begin();
			em.merge(user);
			em.remove(notes);
			et.commit();

			return true;
		}
		return false;
	}
	
	

}
