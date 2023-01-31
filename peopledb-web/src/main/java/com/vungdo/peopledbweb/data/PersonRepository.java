package com.vungdo.peopledbweb.data;

import com.vungdo.peopledbweb.biz.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>, PagingAndSortingRepository<Person, Long>{
    @Query("select p.photoFileName from Person p where p.id in :ids and p.photoFileName is not null")
    Iterable<String> findFileNamesByIds(@Param("ids") Iterable<Long> ids);
}
