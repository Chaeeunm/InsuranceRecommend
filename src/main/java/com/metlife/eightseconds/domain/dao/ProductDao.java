package com.metlife.eightseconds.domain.dao;

import com.metlife.eightseconds.domain.dto.ProductResponseDto;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Repository
public interface ProductDao {
    ProductResponseDto findByPersonalInfo(int productId);
}
