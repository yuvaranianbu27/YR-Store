package com.yuva.yuvaranistore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yuva.yuvaranistore.entity.Contact;

public interface ContactRepository extends
		JpaRepository<Contact, Long> {
}