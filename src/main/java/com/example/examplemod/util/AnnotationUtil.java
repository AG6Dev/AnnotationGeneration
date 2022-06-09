package com.example.examplemod.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public final class AnnotationUtil {
    public static Set<Field> getFieldInClass(Class<?> _class) {
        return Arrays.stream(_class.getFields()).collect(Collectors.toSet());
    }

    public static Map<Class<?>, Set<Field>> getFieldsInClassesWithAnnotation(Set<Class<?>> classesToSearch, Class<? extends Annotation> annotation) {
        final Map<Class<?>, Set<Field>> classFieldMap = new HashMap<>();

        classesToSearch.forEach(aClass -> {
            final Set<Field> fields = new HashSet<>();

            for(Field field : aClass.getFields()) {
                if(field.getAnnotation(annotation) != null) {
                    fields.add(field);
                }
            }
            classFieldMap.put(aClass, fields);
        });
        return classFieldMap;
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