package com.validity.fuzzylogic.converter;

import java.util.Collection;

public abstract class AbstractDataConverter<T, F> implements IDataConverter<T, F> {
    /**
     * This method calls {@link #performConversion} to allow the concrete subclass to perform the data conversion.
     *
     * @param object The object to convert.
     * @return The converted value.
     */
    public T convert(final F object) {
        return performConversion(object);
    }


    /**
     * Converts all of the objects in the incoming collection by calling {@link #convert(Object)} for each.
     */
    public <C extends Collection<T>> C convertAll(final Collection<F> objects, final C targetCollection) {
        for (final F object : objects) {
            targetCollection.add(convert(object));
        }

        return targetCollection;
    }


    /**
     * This method must convert the supplied object to a specific return type.
     *
     * @param object The object to convert.
     * @return The converted value.
     */
    protected abstract T performConversion(final F object);
}
