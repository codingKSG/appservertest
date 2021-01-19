package com.cos.app.web;

import java.io.BufferedReader;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.app.domain.BoardRepository;
import com.cos.app.domain.Movie;
import com.cos.app.domain.dto.CommonDto;
import com.cos.app.domain.dto.SaveReqDto;
import com.cos.app.domain.dto.UpdateReqDto;

@RestController
public class BoardController {
	private final BoardRepository boardRepository;

	// DI 의존성 주입
	public BoardController(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	// http://localhost:8080/movie
	@GetMapping("/movie")
	public List<Movie> findAll() {
		System.out.println("전체영화 가져오기");

		return boardRepository.findAll();
	}

	// http://localhost:8080/movie/{id}
	@GetMapping("/movie/{id}")
	public Movie findById(@PathVariable int id) {
		System.out.println("영화 1건 가져오기");
		return boardRepository.findById(id);
	}

	// http://localhost:8080/movie
	@PostMapping("/movie")
	public CommonDto<?> save(@Valid @RequestBody SaveReqDto dto, BindingResult bindingResult) {
		System.out.println("영화 등록하기");

		return boardRepository.save(dto, bindingResult);
	}

	// http://localhost:8080/movie/{id}
	@DeleteMapping("/movie/{id}")
	public CommonDto<?> delete(@PathVariable int id) {
		System.out.println("영화 삭제하기");

		return boardRepository.delete(id);
	}

	// http://localhost:8080/movie/{id}
	@PutMapping("/movie/{id}")
	public CommonDto<?> update(@PathVariable int id, @Valid @RequestBody UpdateReqDto dto) {
		System.out.println("영화 수정하기");

		return boardRepository.update(id, dto);
	}
}
