package com.yuva.yuvaranistore.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yuva.yuvaranistore.dto.ContactRequestDto;
import com.yuva.yuvaranistore.service.IContactService;

@RestController
@RequestMapping("api/v1/contacts")

public class ContactController {
    public ContactController(IContactService iContactService) {
        this.iContactService = iContactService;
    }

    private final IContactService iContactService;
    @PostMapping
    public String saveContact(@RequestBody ContactRequestDto contactRequestDto) {
        boolean isSaved = iContactService.saveContact(contactRequestDto);
        if (isSaved) {
            return "Request processed successfully";
        } else {
            return "An error occurred. Please try again or contact Dev team";
        }
    }



}
