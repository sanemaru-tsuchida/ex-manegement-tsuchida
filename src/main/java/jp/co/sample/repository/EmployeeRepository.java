package jp.co.sample.repository;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

/**
 * @author 土田真丸
 *
 */
@Repository
public class EmployeeRepository {
	
	/** テンプレート作成　*/

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/** RowMapper作成*/

	private static final RowMapper<Employee> Employee_ROW_MAPPER = (rs,i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setHierDate(rs.getTimestamp("hire_date"));
		employee.setGender(rs.getString("gender"));
		employee.setImage(rs.getString("image"));
		employee.setZipCode(rs.getString("zip_code"));
		employee.setAddress(rs.getString("address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setMailAddress(rs.getString("mail_address"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDependentsCount(rs.getInt("dependents_count"));
		
		return employee;
	};
	
	//** 従業員⼀覧情報を⼊社⽇順(降順)で取得する*/
	public List<Employee> findAll(){
		String sql = "SELECT id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count FROM employees ORDER BY hire_date DESC";
		List<Employee> employeeList = template.query(sql, Employee_ROW_MAPPER);
		
		if(employeeList.size() == 0) {
			return null;
		}
		return employeeList;
	}
	//**主キーから従業員情報を取得する*/
	public Employee load(Integer id) {
		String spl ="SELECT id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count FROM employees WHERE id=:id";
		SqlParameterSource pram = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(spl, pram, Employee_ROW_MAPPER);
		return employee;
	}
	//**従業員情報を変更する*/
	public void update(Employee employee) {

		SqlParameterSource param =new BeanPropertySqlParameterSource(employee);
		
		if(employee.getId()==null) {
			String sql = "INSERT INTO employees(id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count) VALUES (:name,:image,:gender,:hireDate,:mailAddress,:zipCode,:address,:telephone,:salary,:characteristics,:dependentsCount)";
			KeyHolder keyHandler = new GeneratedKeyHolder();
			String[] keyNanber = {"id"};
			template.update(sql, param, keyHandler, keyNanber);
			employee.setId(keyHandler.getKey().intValue());
			System.out.println("idが無かったため追加しました。");
			
 		}else {
			String sql = "UPDATE employees SET name=:name,image=:image,gender=:gender,hire_date=:hierDate,mail_address=:mailAddress,zip_code=:zipCode,address=:address,telephone=:telephone,salary=:salary,characteristics=:characteristics,dependents_count=:dependentsCount WHERE id=:id"; 
			template.update(sql, param);
		}
		
	}
	
}
