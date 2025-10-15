package com.yuva.yuvaranistore.service;

import com.yuva.yuvaranistore.dto.ContactRequestDto;

public interface IContactService {

	boolean saveContact(
			ContactRequestDto contactRequestDto);
}