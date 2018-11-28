package br.edu.utfpr.adapter;

import br.edu.utfpr.model.User;

public class StatusUsuario {
	User u = new User();
	public User on(String name, String email, String tipo){
		return u; 
	}
	public User off(User user){
		return user;
	}
	
}
