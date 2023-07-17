package com.estudando.ProjectAPI.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudando.ProjectAPI.controller.PersonController;
import com.estudando.ProjectAPI.converters.ModelMappers;
import com.estudando.ProjectAPI.dto.PersonVO;
import com.estudando.ProjectAPI.model.Person;
import com.estudando.ProjectAPI.repository.PersonRepository;


@Service
public class PersonService {
	
	
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	PersonRepository repository;
	
	
	
	public List<PersonVO> findAll(){
		
		logger.info("Finding all people");

		var vo = ModelMappers.parseListObjects(repository.findAll(), PersonVO.class);
		vo.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getId())).withSelfRel()));
		return vo;
	 
	}
	
	public PersonVO create(PersonVO personVO) {
		logger.info("Create All People ");
		PersonVO ps = new PersonVO();
		ps.setFirst_name(personVO.getFirst_name());
		ps.setLast_name(personVO.getLast_name());
		ps.setAddress(personVO.getAddress());
		ps.setGender(personVO.getGender());
		Person person = repository.save(ModelMappers.parseObject(ps, Person.class));
		var vo = ModelMappers.parseObject(person,PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getId())).withSelfRel());
		return vo;
		
		
	}
	
	public PersonVO findById(Long id) {
		logger.info("Find By Id All People ");
		var vo = ModelMappers.parseObject(repository.findById(id).get(), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo ;
	}
	
	public PersonVO update(PersonVO person) {
		return updatePerson(person);
	}
	
	public PersonVO updatePerson(PersonVO personDestiny) {
		var entity = repository.findById(personDestiny.getId()).get();
		entity.setFirst_name(personDestiny.getFirst_name());
		entity.setLast_name(personDestiny.getLast_name());
		entity.setAddress(personDestiny.getAddress());
		entity.setGender(personDestiny.getGender());
		
		var vo = ModelMappers.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getId())).withSelfRel());
		return vo;
	}
	
	public void delete(long id) {
	 repository.deleteById(id);
	}
	
}
