package com.github.jonathan.zollinger.model;

public interface SystemProperties {

    /**
     * Assigns propertyName field.
     *
     * @param propertyName String for this system property name.
     */
    void PropertyName(String propertyName);

    /**
     * Get name given by propertyName field.
     *
     * @return String value for system property name
     */
    String PropertyName();

    /**
     * Assigns value for this system property.
     *
     * @param value String for this system property value field.
     */
    void Value(String value);

    /**
     * Get value for this system property.
     *
     * @return String for this system property value.
     */
    String Value();
}
