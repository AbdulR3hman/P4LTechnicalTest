package com.pay4later.serialization.extras;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 15:16
 * Class:       com.pay4later.serialization.extras.UnderScoreToCamelStrategyNaming
 */
public class UnderScoreToCamelStrategyNaming extends PropertyNamingStrategy {

    @Override
    public String nameForField(MapperConfig
                                       config,
                               AnnotatedField field, String defaultName) {
        return convert(defaultName);

    }

    @Override
    public String nameForGetterMethod(MapperConfig
                                              config,
                                      AnnotatedMethod method, String defaultName) {
        return convert(defaultName);
    }

    @Override
    public String nameForSetterMethod(MapperConfig
                                              config,
                                      AnnotatedMethod method, String defaultName) {
        String a = convert(defaultName);
        return a;
    }

    public String convert(String defaultName) {
        char[] arr = defaultName.toCharArray();
        StringBuilder nameToReturn = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '_') {
                nameToReturn.append(Character.toUpperCase(arr[i + 1]));
                i++;
            } else {
                nameToReturn.append(arr[i]);
            }
        }
        return nameToReturn.toString();
    }


}
