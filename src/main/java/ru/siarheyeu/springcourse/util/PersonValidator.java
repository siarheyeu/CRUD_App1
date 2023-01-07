package ru.siarheyeu.springcourse.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.siarheyeu.springcourse.models.Person;

public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        //посмотреть, есть ли человек с таким же email-ом в БД
    }
}
