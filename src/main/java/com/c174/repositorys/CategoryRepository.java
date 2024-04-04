package com.c174.repositorys;

import com.c174.models.category.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional <CategoryEntity> findByName(String name);
    Boolean existsByName(String name);
}
