package org.jfpa.cache;

import org.jfpa.manager.SeparatorType;
import org.jfpa.type.RecordType;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Matteo Trotta
 * Copyright © 2011 Matteo Trotta
 * Date: 01/10/11
 */
public class CachedRecord {
    private SeparatorType separatorType;
    private Map<Field, CachedColumn> mapColumns;
    private RecordType recordType;
    private boolean validator;

    public CachedRecord(final Map<Field, CachedColumn> mapColumns) {
        this.mapColumns = mapColumns;
    }

    public final void setPositional(final int[] lengths) {
        this.separatorType = SeparatorType.POSITIONAL;
        this.recordType = new RecordType(lengths);
    }

    public final void setDelimited(final String delimiter, final int columns, final int[] lengths) {
        this.separatorType = SeparatorType.DELIMITED;
        this.recordType = new RecordType(delimiter, columns, lengths);
    }

    public final SeparatorType getSeparatorType() {
        return separatorType;
    }

    public final Map<Field, CachedColumn> getMapColumns() {
        return mapColumns;
    }

    public final RecordType getRecordType() {
        return recordType;
    }

    public final boolean isValidator() {
        return validator;
    }

    public final void setValidator(final boolean validator) {
        this.validator = validator;
    }
}
