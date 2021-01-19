package com.cos.app.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import com.cos.app.domain.dto.CommonDto;
import com.cos.app.domain.dto.SaveReqDto;
import com.cos.app.domain.dto.UpdateReqDto;

@Repository
public class BoardRepository {

	public List<Movie> findAll() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1, "어바웃타임", 4.9, java.sql.Timestamp.valueOf("2013-11-03 00:00:00")));
		movies.add(new Movie(2, "러브 액츄얼리", 4.7, java.sql.Timestamp.valueOf("2003-11-28 00:00:00")));
		movies.add(new Movie(3, "라라랜드", 4.9, java.sql.Timestamp.valueOf("2016-08-31 00:00:00")));

		System.out.println("영화 전체 찾기");
		System.out.println(movies);
		return movies;
	}

	public Movie findById(int id) {
		List<Movie> movies = findAll();

		for (Movie movie : movies) {
			if (movie.getId() == id) {
				System.out.println("Movie " + id + "번 영화 찾음");
				return movie;
			}
		}
		System.out.println("찾기 실패");
		return null;
	}

	public CommonDto<?> save(SaveReqDto saveReqDto, BindingResult bindingResult) {
		System.out.println("bindingResult = " + bindingResult.getErrorCount());

		if (bindingResult.hasErrors()) {
			System.out.println("영화를 저장하는데 실패하였습니다.");
			return new CommonDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
		}

		System.out.println("영화를 저장하는데 성공하였습니다.");
		return new CommonDto<String>(HttpStatus.OK.value(), "ok");
	}

	public CommonDto<?> delete(int id) {
		List<Movie> movies = findAll();
		for (Movie movie : movies) {
			if (movie.getId() == id) {
				return new CommonDto<String>(HttpStatus.OK.value(), "ok");
			}
		}
		
		System.out.println("해당하는 영화ID를 가진 영화가 없습니다.");
		return new CommonDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
	}

	public CommonDto<?> update(int id, UpdateReqDto dto) {
		List<Movie> movies = findAll();
		for (Movie movie : movies) {
			if (movie.getId() == id) {
				movie.setTitle(dto.getTitle());
				movie.setRating(dto.getRating());
				
				System.out.println(movie);
				return new CommonDto<String>(HttpStatus.OK.value(), "ok");
			}
		}
		
		System.out.println("해당하는 영화ID를 가진 영화가 없습니다.");
		return new CommonDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
	}
}
