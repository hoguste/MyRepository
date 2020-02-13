package com.adaming.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.projet.dao.MatiereDAO;
import com.adaming.projet.entity.Matiere;

@Controller
@RequestMapping(value = "/matiere")
public class MatiereController {
	@Autowired
	MatiereDAO matdao;

	@RequestMapping(value = "/ajoutmatiere", method = RequestMethod.POST)
	public String AjoutMatiere(@ModelAttribute("mat") Matiere matiere, ModelMap model) {
		matdao.AjoutMatiere(matiere);
		GetAllMatieres(model);
		return "matiere";
	}

	@RequestMapping(value = "/supprimermatiere", method = RequestMethod.POST)
	public String SupprimerMatiere(@ModelAttribute("mat") Matiere matiere, ModelMap model) {
		matdao.SupprimerMatiere(matiere);
		GetAllMatieres(model);
		return "matiere";
	}

	@RequestMapping(value = "/listematiere", method = RequestMethod.GET)
	public String GetAllMatieres(ModelMap model) {
		model.addAttribute("lstmat", matdao.GetAllMatieres());
		return "matiere";
	}

	public MatiereDAO getMatdao() {
		return matdao;
	}

	public void setMatdao(MatiereDAO matdao) {
		this.matdao = matdao;
	}

}
