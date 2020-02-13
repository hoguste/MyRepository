package com.adaming.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.projet.dao.EtudiantDAO;
import com.adaming.projet.entity.Etudiant;

@Controller
@RequestMapping(value="/etudiant")
public class EtudiantController {
	public EtudiantDAO getEtudao() {
		return etudao;
	}

	public void setEtudao(EtudiantDAO etudao) {
		this.etudao = etudao;
	}

	@Autowired
	EtudiantDAO etudao;
	
	@RequestMapping(value="/ajoutetudiant", method=RequestMethod.POST)
	public String AjoutEtudiant(@ModelAttribute("etu") Etudiant etudiant, ModelMap model) {
		etudao.AjoutEtudiant(etudiant);
		GetAllEtudiant(model);
		return "etudiant";
	}
	
	@RequestMapping(value="/supprimeretudiant", method=RequestMethod.POST)
	public String SupprimerEtudiant(@ModelAttribute("etu") Etudiant etudiant, ModelMap model) {
		etudao.SupprimerEtudiant(etudiant);
		GetAllEtudiant(model);
		return "etudiant";
	}
	
	@RequestMapping(value="/listeetudiant", method=RequestMethod.GET)
	public String GetAllEtudiant(ModelMap model) {
		model.addAttribute("lstetu", etudao.GetAllEtudiants());
		return "etudiant";
	}
	
	

}
