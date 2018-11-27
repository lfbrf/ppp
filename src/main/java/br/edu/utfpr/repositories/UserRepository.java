//Interface do repositorio, que extende ao CrudRepository
package br.edu.utfpr.repositories;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {

}