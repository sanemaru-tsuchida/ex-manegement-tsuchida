package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
