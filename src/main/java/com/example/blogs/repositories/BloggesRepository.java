package com.example.blogs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.blogs.entities.BlogEntity;

@Repository
public interface BloggesRepository extends JpaRepository<BlogEntity, Long> {

	@Query("FROM BlogEntity BG WHERE BG.userEntity.user_id = ?1")
	public List<BlogEntity> findBlogEntitiesByUserEntity(long userEntity);
	
	@Query("FROM BlogEntity BG WHERE BG.categoryEntity.category_id = ?1")
	public List<BlogEntity> getAllAvailableBlogsForCategory(long category_id);
}
