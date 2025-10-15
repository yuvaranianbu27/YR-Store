package com.yuva.yuvaranistore.service.impl;

import java.time.Instant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.yuva.yuvaranistore.dto.ContactRequestDto;
import com.yuva.yuvaranistore.entity.Contact;
import com.yuva.yuvaranistore.repository.ContactRepository;
import com.yuva.yuvaranistore.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
        try {
            Contact contact = transformToEntity(contactRequestDto);
            contact.setCreatedAt(Instant.now());
            contact.setCreatedBy(contactRequestDto.getName());
            contactRepository.save(contact);
            return true;
        } catch (Exception exception) {
            return false;
        }

    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        return contact;
    }
}