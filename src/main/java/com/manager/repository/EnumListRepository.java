package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entities.EnumList;


@Repository
public interface EnumListRepository extends CrudRepository<EnumList, Integer>{
	@Query("from EnumList where id =:id")
	public EnumList findById1(@Param("id") int id);

	@Query("from EnumList where typestatus = 'Ts_004' ")
	public List<EnumList> findTypeStatusOfContact();

	@Query("from EnumList where typestatus = 'Ts_003' ")
	public List<EnumList> findTypeStatusOfNews();

	@Query("from EnumList where typestatus = 'Ts_002' ")
	public List<EnumList> findTypeStatusOfTeacher();

	@Query("from EnumList where typestatus = 'Ts_001' ")
	public List<EnumList> findTypeStatusOfCodeTest();

	@Query("from EnumList where typestatus = 'Ts_002' ")
	public List<EnumList> findTypeStatusOfTerm();
}
