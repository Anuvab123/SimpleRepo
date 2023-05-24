package com.geekster.H2fun.repository;

import com.geekster.H2fun.models.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<Users,Integer> {
   public List<Users> findByName(String name);

   public List<Users> findByAgeGreaterThan(Integer age);

   public List<Users> findByNameOrAgeGreaterThan(String name, Integer age);

   public List<Users> findByNameAndAgeGreaterThan(String name, Integer age);

   //make our own query
   @Query(value="select * from Users order by user_age asc", nativeQuery = true)
   public List<Users> findUsersOrderByAgeAsc();
}
