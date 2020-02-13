package com.adaming.projet;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adaming.projet.dao.EtudiantDAO;
import com.adaming.projet.entity.Etudiant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src//test//resources//root-context.xml"})
public class TestDAOEtudiant {
	@Autowired
	private EtudiantDAO etudao;
	
	Etudiant etu;
	

	public EtudiantDAO getEtudao() {
		return etudao;
	}

	public void setEtudao(EtudiantDAO etudao) {
		this.etudao = etudao;
	}
	
	@Before
	public void setUp() {
		etu = new Etudiant();
		etu.setIdEtudiant(11);
		etu.setNomEtudiant("schalck");
		etu.setPrenomEtudiant("nicolas");
		System.out.println("Début du test d'EtudiantDAO");
		
	}
	

	@Test
	public void TestAjoutEtudiant() {
		etudao.AjoutEtudiant(etu);
		Etudiant etd = etudao.GetByIdEtudiant(11);
		assertEquals(etu, etd);
		
	}
	
	@After
	public void tearDown() {
		System.out.println("Fin du test");
	}
	
	

}
