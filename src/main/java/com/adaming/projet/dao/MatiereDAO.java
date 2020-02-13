package com.adaming.projet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.projet.entity.Matiere;

@Repository
public class MatiereDAO {
	@Autowired
	private SessionFactory sf;
	

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public void AjoutMatiere(Matiere mat) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(mat);
		sess.getTransaction().commit();
	}

	public void SupprimerMatiere(Matiere mat) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.delete(mat);
		sess.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<Matiere> GetAllMatieres() {
		Session sess = sf.openSession();
		sess.beginTransaction();
		Criteria crit = sess.createCriteria(Matiere.class);
		sess.getTransaction().commit();
		return crit.list();
	}

}
