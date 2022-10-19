package br.org.serratec.biblioteca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.serratec.biblioteca.domain.Emprestimo;
import br.org.serratec.biblioteca.exception.DataEmprestimoAnteriorException;
import br.org.serratec.biblioteca.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	@Autowired
	EmprestimoRepository emprestimoRepository;

	@Transactional(readOnly = true)
	public List<Emprestimo>findAll() {
		return emprestimoRepository.findAll();
	}

	public Optional<Emprestimo> findById(Long id) {
		return emprestimoRepository.findById(id);
	}

	@Transactional
	public Emprestimo save(@Valid Emprestimo emprestimo) throws DataEmprestimoAnteriorException {
		if (emprestimo.getDataEmprestimo().isBefore(LocalDate.now())) {
			throw new DataEmprestimoAnteriorException();
		}
		return emprestimoRepository.save(emprestimo);
	}

	@Transactional
	public void deleteById(Long id) {
		emprestimoRepository.deleteById(id);
		
	}
	

}
