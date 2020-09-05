package com.example.mailmanagement.repository;

import com.example.mailmanagement.model.ContactMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContactMailRepository extends JpaRepository<ContactMail, Long> {

    @Transactional
    @Query("update ContactMail contactMail set contactMail.status =:status where contactMail.id =:id")
    void saveMail(@Param("status") int status, @Param("id") long id);
}
