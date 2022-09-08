package com.nttdata.repository;

import com.nttdata.entities.InformationPersonal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationPersonalRepository extends CrudRepository<InformationPersonal, Integer> {
    List<InformationPersonal> findByIdNumberAndTypeNumber(Integer id, String typeNumber);
}
