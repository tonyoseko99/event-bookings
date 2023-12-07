package com.tonnyseko.servlet.app.utility;

import javax.persistence.AttributeConverter;

public class EnumConverter<T extends Enum<T>> implements AttributeConverter<T, String> {

    @Override
    public String convertToDatabaseColumn(T enumType) {
        if (enumType == null) {
            return null;
        }
        return enumType.name();
    }

    @Override
    public T convertToEntityAttribute(String s) {
        return null;
    }
}
