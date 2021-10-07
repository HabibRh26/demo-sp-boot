package com.example.test;

import com.example.test.Coder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoderRepo extends JpaRepository<Coder, Integer> {
    List<Coder> findBypName(String pName);

    @Query("from Coder where pLang = ?1")
    List<Coder> findByLang(String pLang);
}
