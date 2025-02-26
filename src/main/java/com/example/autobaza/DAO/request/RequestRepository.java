package com.example.autobaza.DAO.request;

import com.example.autobaza.model.Request;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Request, Long> {
    Request findRequestById(Long id);

}
