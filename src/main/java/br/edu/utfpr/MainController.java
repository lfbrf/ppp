package br.edu.utfpr;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.model.User;
import br.edu.utfpr.repositories.UserRepository;

@Controller   
@RequestMapping(path="/api") 
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/novousuario", method = RequestMethod.POST)
    public ModelAndView newUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("tipo") String tipo) {    
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setTipoConta(tipo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/api");
		if (!tipo.equals("OURO") && !tipo.equals("PRATA") && !tipo.equals("BRONZE") )
			return modelAndView; 
		userRepository.save(u);	
		return modelAndView;   
    }
	

	@GetMapping(path="")
	public @ResponseBody ModelAndView iniciio(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		Iterable<User> todos = userRepository.findAll();
		model.addAttribute("todos", todos);
		modelAndView.setViewName("inicio");
		return modelAndView;

	}
	
	@RequestMapping(value = "/creditos", method = RequestMethod.POST)
    public ModelAndView creditos(Model model, @RequestParam("id") int id, @RequestParam("valor") double valor) {    

		Iterable<User> todos = userRepository.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/api");
		model.addAttribute("todos", todos);
		User u = userRepository.findById(id).orElse(null);
		if (u != null) {
			Conta umaConta = new Conta(u.getTipoConta(), valor);
			 if (valor> 0) {
				u.setValor(valor + u.getValor());
				userRepository.save(u);
			 }
		}
		return modelAndView;
    }

	
	@RequestMapping(value = "/debitos", method = RequestMethod.POST)
    public ModelAndView debitos(Model model, @RequestParam("id") int id, @RequestParam("valor") double valor) {    

		Iterable<User> todos = userRepository.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/api");
		model.addAttribute("todos", todos);
		User u = userRepository.findById(id).orElse(null);
		if (u != null) {
			Conta umaConta = new Conta(u.getTipoConta(), valor);
			
			 if (u.getValor() - umaConta.calculaContaComDesconto() >= 0)
				u.setValor( u.getValor() - umaConta.calculaContaComDesconto() );
			userRepository.save(u);
			return modelAndView;
		}
		return modelAndView;
    }
	
}
