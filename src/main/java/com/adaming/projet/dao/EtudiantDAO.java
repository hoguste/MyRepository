package com.adaming.projet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.projet.entity.Etudiant;

@Repository
public class EtudiantDAO {
	@Autowired
	private SessionFactory sf;
	

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public void AjoutEtudiant(Etudiant etu) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(etu);
		sess.getTransaction().commit();
	}

	public void SupprimerEtudiant(Etudiant etu) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.delete(etu);
		sess.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Etudiant> GetAllEtudiants() {
		Session sess = sf.openSession();
		sess.beginTransaction();
		Criteria crit = sess.createCriteria(Etudiant.class);
		sess.getTransaction().commit();
		return crit.list();
	}
	
	public Etudiant GetByIdEtudiant(long id) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		Etudiant etd = (Etudiant) sess.get(Etudiant.class, id);
		sess.getTransaction().commit();
		return etd;
		
	}

}
