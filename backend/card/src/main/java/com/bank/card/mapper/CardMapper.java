package com.bank.card.mapper;

import com.bank.card.dto.CardDto;
import com.bank.card.entity.Card;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMapper {
    @Mapping(target = "expirationDate", source = "cardDto.expirationDate", dateFormat = "MM/yy")
    Card toCard(CardDto cardDto);

    @InheritInverseConfiguration
    @Mapping(target = "expirationDate", source = "card.expirationDate", dateFormat = "MM/yy")
    CardDto fromCard(Card card);
}
