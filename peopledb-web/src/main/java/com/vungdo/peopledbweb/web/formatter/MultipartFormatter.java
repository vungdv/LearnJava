package com.vungdo.peopledbweb.web.formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;

@Component
public class MultipartFormatter implements Formatter<MultipartFile> {
    @Override
    public MultipartFile parse(String text, Locale locale) {
        return null;
    }

    @Override
    public String print(MultipartFile object, Locale locale) {
        return object.getOriginalFilename();
    }
}
