package com.example.repository_mysql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity_mysql.UserMySQL;

@Repository
public class UserMySQLRepository  {
	    @Autowired
	    @PersistenceContext( unitName= "PERSITENCE_UNIT_NAME_MYSQL")
	    private EntityManager entityManager;
	 
	    public List<UserMySQL> listUsers() {
	        String sql = "Select e from " + UserMySQL.class.getName() + " e ";
	        Query query = entityManager.createQuery(sql, UserMySQL.class);
	        return query.getResultList();
	    }
	 
	    public UserMySQL findById(Long id) {
	    	
	        return this.entityManager.find(UserMySQL.class, id);
	    }
	   
	    @Transactional("ds1TransactionManager")
	
	    public void update(Long id, UserMySQL userMySQL) {
	    
	    	String sql = "update  " + UserMySQL.class.getName() + "   set username =:username , password =:password  where id = :id" ;
	    	Query query  = entityManager.createQuery(sql);
	    	query.setParameter("username", userMySQL.getUsername());
	    	query.setParameter("password", userMySQL.getPassword());
	    	query.setParameter("id", id);
	    	int res = query.executeUpdate();
    	
	    	entityManager.close();
	    	
		}
	    
}
