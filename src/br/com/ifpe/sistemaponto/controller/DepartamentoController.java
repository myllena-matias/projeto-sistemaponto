package br.com.ifpe.sistemaponto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.sistemaponto.model.Departamento;
import br.com.ifpe.sistemaponto.model.DepartamentoDao;

@Controller
public class DepartamentoController {

		@RequestMapping("/exibirIncluirDepartamento")
		public String exibirIncluirDepartamento() {

			return "departamento/incluirDepartamento";
		}

		@RequestMapping("/incluirDepartamento")
		public String incluirDepartamento(@Valid Departamento departamento, BindingResult result, Model model) {
					
			if (result.hasErrors()) {
				return "departamento/incluirDepartamento";
				}
			
			DepartamentoDao dao = new DepartamentoDao();
			dao.salvar(departamento);
			model.addAttribute("msg", "O departamento " + departamento.getDescricao() + " foi incluído com sucesso !");

			return "departamento/incluirDepartamento";
		}

		@RequestMapping("/listarDepartamento")
		public String listarDepartamento(Model model) {

			DepartamentoDao dao = new DepartamentoDao();
			List<Departamento> listaDepartamento = dao.listar();
			model.addAttribute("listaDepartamento", listaDepartamento);

			return "departamento/pesquisarDepartamento";
		}
		
		@RequestMapping("alterarDepartamento")
	    public String alterarDepartamento(Departamento departamento, Model model) {

		DepartamentoDao dao = new DepartamentoDao();
		dao.alterar(departamento);
		model.addAttribute("msg", "Departamento alterado com sucesso !");

		return "forward:listarDepartamento";
	    }

		@RequestMapping("removerDepartamento")
		public String removerDepartamento(Departamento departamento, Model model) {

			DepartamentoDao dao = new DepartamentoDao();
			dao.remover(departamento);
			model.addAttribute("msg", "Departamento removido com sucesso");

			return "forward:listarDepartamento";
		}
		
	}
