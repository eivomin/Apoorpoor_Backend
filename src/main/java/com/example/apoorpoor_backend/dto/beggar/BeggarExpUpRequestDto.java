package com.example.apoorpoor_backend.dto.beggar;

import com.example.apoorpoor_backend.model.enumType.BadgeType;
import com.example.apoorpoor_backend.model.enumType.ExpType;
import lombok.Getter;

@Getter
public class BeggarExpUpRequestDto {

    private ExpType expType;

    private BadgeType badgeType;
}