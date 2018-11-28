package br.edu.utfpr.adapter;

import br.edu.utfpr.adapter.*;
import br.edu.utfpr.model.User;
/*
 * criando o adaptador
 * ele que tem a responsabilidade de chamar o método novo
 */
public class StatusUsuarioAdapter extends StatusUsuario {

	User u = new User();
	public StatusUsuarioAdapter() {

	}

	@Override
	public User on(String name, String email, String tipo) {
		u.setName(name);
		u.setEmail(email);
		u.setTipoConta(tipo);
		u.setStatus(true);
		return u;
	}

	@Override
	public User off(User user) {

		user.setStatus(false);
		return user;
	}

}