package br.com.ifpe.sistemaponto.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.ifpe.sistemaponto.model.Funcionario;
import br.com.ifpe.sistemaponto.model.FuncionarioDao;
import br.com.ifpe.sistemaponto.util.Util;

@Controller
public class FuncionarioController {
	
	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Funcionario funcionario, HttpSession session, Model model) {
	
		FuncionarioDao dao = new FuncionarioDao();
		Funcionario funcionarioLogado = dao.buscarFuncionario(funcionario);
	
		if (funcionarioLogado != null) {
				session.setAttribute("funcionarioLogado", funcionarioLogado);
				return "principal/home";
	}
	
		model.addAttribute("msg", "Não foi encontrado um funcionário com o login e senha informados.");
			return "index";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/exibirIncluirFuncionario")
    public String exibirIncluirFuncionario(Model model) {
		
		return "funcionario/incluirFuncionario";
    }

    @RequestMapping("incluirFuncionario")
    public String incluirFuncionario(@Valid Funcionario funcionario, @RequestParam("file") MultipartFile imagem, BindingResult result, Model model) {
    	if (Util.fazerUploadImagem(imagem)) {
			funcionario.setImagem(Calendar.getInstance().getTime() + " - " + imagem.getOriginalFilename());
		}
    	
    	if (result.hasErrors()) {
			return "forward:listarFuncionario";
			}
    	    	
	FuncionarioDao dao = new FuncionarioDao();
	dao.salvar(funcionario);
	model.addAttribute("msg", "O funcionário " + funcionario.getNome() + " foi inserido com sucesso!");

	return "forward:listarFuncionario";
    }

    @RequestMapping("/listarFuncionario")
    public String listarFuncionario(Model model) {

    FuncionarioDao dao = new FuncionarioDao();
	List<Funcionario> listaFuncionario = dao.listar();
	model.addAttribute("listaFuncionario", listaFuncionario);

	return "funcionario/pesquisarFuncionario";
    }

    @RequestMapping("removerFuncionario")
    public String removerFuncionario(Funcionario funcionario, Model model) {

    FuncionarioDao dao = new FuncionarioDao();
	dao.remover(funcionario);
	model.addAttribute("msg", "Funcionário removido com sucesso!");

	return "forward:listarFuncionario";
    }

    @RequestMapping("exibirAlterarFuncionario")
    public String exibirAlterarFuncionario(Funcionario funcionario, Model model) {

    FuncionarioDao dao = new FuncionarioDao();
	Funcionario funcionarioPreenchido = dao.buscarPorId(funcionario.getId());
	model.addAttribute("funcionario", funcionarioPreenchido);

	return "funcionario/alterarFuncionario";
    }

    @RequestMapping("alterarFuncionario")
    public String alterarFuncionario(Funcionario funcionario, Model model) {

    FuncionarioDao dao = new FuncionarioDao();
	dao.alterar(funcionario);
	model.addAttribute("msg", "Funcionário alterado com sucesso!");

	return "forward:listarFuncionario";
    }
        
}
