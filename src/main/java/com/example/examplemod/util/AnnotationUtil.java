package com.example.examplemod.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class AnnotationUtil {
    public static Set<Field> getFieldInClass(Class<?> _class) {
        return Arrays.stream(_class.getFields()).collect(Collectors.toSet());
    }

    public static Set<Field> getFieldsInClassesWithAnnotation(Set<Class<?>> classesToSearch, Class<? extends Annotation> annotation) {
        final Set<Field> fields = new HashSet<>();
        classesToSearch.forEach(aClass -> {

            for (Field field : aClass.getFields()) {
                if (field.getAnnotation(annotation) != null) {
                    fields.add(field);
                }
            }
        });
        return fields;
    }

    public static Set<Field> getFindFieldsWithAnnotation(Class<?> _class, Class<? extends Annotation> annotationClass) {
        final Set<Field> fields = new HashSet<>();

        for (Field field : _class.getFields()) {
            if (field.getAnnotation(annotationClass) != null) {
                fields.add(field);
            }
        }
        return fields;
    }
}
