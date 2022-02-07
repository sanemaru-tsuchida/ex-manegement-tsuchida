package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;
/**
 * @author 土田真丸
 *
 */
@Service
@Transactional
public class AdministratorService {
	@Autowired
	private AdministratorRepository repository;
	
	//** 管理者情報を挿⼊する。 administratorRepository の insert()メソッドを呼ぶ*/
	public void insert(Administrator administrator) {
		repository.insert(administrator);
	}
}

