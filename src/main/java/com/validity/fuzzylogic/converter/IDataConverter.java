package com.validity.fuzzylogic.converter;

import java.util.Collection;

public interface IDataConverter<T, F> {
    /**
     * Converts the supplied object to an object of the target specific type of this converter.
     *
     * @param object The object to convert.
     * @return An object of the specific return type
     */
    T convert(F object);


    /**
     * Converts all of the objects in the supplied collection to the target type of this converter. All converted objects
     * are placed in the supplied collection, which is returned to the caller.
     *
     * @param objects          The objects to be converted.
     * @param targetCollection The target collection to house the converted objects.
     * @return The target collection supplied, populated with converted objects.
     */
    <C extends Collection<T>> C convertAll(Collection<F> objects, C targetCollection);
}
