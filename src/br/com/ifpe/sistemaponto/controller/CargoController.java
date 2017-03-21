package br.com.ifpe.sistemaponto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.sistemaponto.model.Cargo;
import br.com.ifpe.sistemaponto.model.CargoDao;


@Controller
public class CargoController {
	
	@RequestMapping("/exibirIncluirCargo")
	public String exibirIncluirCargo() {

		return "cargo/incluirCargo";
	}

	@RequestMapping("/incluirCargo")
	public String incluirCargo(@Valid Cargo cargo, BindingResult result, Model model) {
				
		if (result.hasErrors()) {
			return "cargo/incluirCargo";
			}
		
		CargoDao dao = new CargoDao();
		dao.salvar(cargo);
		model.addAttribute("msg", "O cargo " + cargo.getDescricao() + " foi incluído com sucesso !");

		return "cargo/incluirCargo";
	}

	@RequestMapping("/listarCargo")
	public String listarCargo(Model model) {

		CargoDao dao = new CargoDao();
		List<Cargo> listaCargo = dao.listar();
		model.addAttribute("listaCargo", listaCargo);

		return "cargo/pesquisarCargo";
	}
	
	@RequestMapping("alterarCargo")
    public String alterarCargo(Cargo cargo, Model model) {

	CargoDao dao = new CargoDao();
	dao.alterar(cargo);
	model.addAttribute("msg", "Cargo alterado com sucesso !");

	return "forward:listarCargo";
    }

	@RequestMapping("removerCargo")
	public String removerCargo(Cargo cargo, Model model) {

		CargoDao dao = new CargoDao();
		dao.remover(cargo);
		model.addAttribute("msg", "Cargo removido com sucesso");

		return "forward:listarCargo";
	}

}
