package com.example.repository_postgres;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity_postgres.UserPostgres;

@Repository
public class UserPostgresRepository {
	@Autowired
	@PersistenceContext(unitName = "PERSITENCE_UNIT_NAME_POSTGRES")
	private EntityManager entityManager;

	public List<UserPostgres> listUsers() {
		String sql = "Select e from " + UserPostgres.class.getName() + " e ";
		Query query = entityManager.createQuery(sql, UserPostgres.class);
		return query.getResultList();
	}

	public UserPostgres findById(Long id) {
		return this.entityManager.find(UserPostgres.class, id);
	}

	   @Transactional("ds2TransactionManager")
	    public void update(Long id, UserPostgres userPostgres) {
	    
	    	String sql = "update  " + UserPostgres.class.getName() + "   set username =:username , password =:password  where id = :id" ;
	    	Query query  = entityManager.createQuery(sql);
	    	query.setParameter("username", userPostgres.getUsername());
	    	query.setParameter("password", userPostgres.getPassword());
	    	query.setParameter("id", id);
	    	int res = query.executeUpdate();
	    	entityManager.close();
	    	
		}
}
