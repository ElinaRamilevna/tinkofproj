package ru.tinkoff.edu.java.scrapper.domain.jooq.tables;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function8;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.tinkoff.edu.java.scrapper.domain.jooq.DefaultSchema;
import ru.tinkoff.edu.java.scrapper.domain.jooq.Keys;
import ru.tinkoff.edu.java.scrapper.domain.jooq.tables.records.LinkRecord;

@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Link extends TableImpl<LinkRecord> {

    private static final long serialVersionUID = 1L;

    public static final Link LINK = new Link();

    @Override
    @NotNull
    public Class<LinkRecord> getRecordType() {
        return LinkRecord.class;
    }

    public final TableField<LinkRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    public final TableField<LinkRecord, String> URL = createField(DSL.name("url"), SQLDataType.VARCHAR(1000000000).nullable(false), this, "");

    public final TableField<LinkRecord, LocalDateTime> CHECKED_AT = createField(DSL.name("checked_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    public final TableField<LinkRecord, LocalDateTime> GH_PUSHED_AT = createField(DSL.name("gh_pushed_at"), SQLDataType.LOCALDATETIME(6), this, "");

    public final TableField<LinkRecord, String> GH_DESCRIPTION = createField(DSL.name("gh_description"), SQLDataType.VARCHAR(1000000000), this, "");

    public final TableField<LinkRecord, Integer> GH_FORKS_COUNT = createField(DSL.name("gh_forks_count"), SQLDataType.INTEGER, this, "");

    public final TableField<LinkRecord, Integer> SO_ANSWER_COUNT = createField(DSL.name("so_answer_count"), SQLDataType.INTEGER, this, "");

    public final TableField<LinkRecord, LocalDateTime> SO_LAST_EDIT_DATE = createField(DSL.name("so_last_edit_date"), SQLDataType.LOCALDATETIME(6), this, "");

    private Link(Name alias, Table<LinkRecord> aliased) {
        this(alias, aliased, null);
    }

    private Link(Name alias, Table<LinkRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public Link(String alias) {
        this(DSL.name(alias), LINK);
    }

    public Link(Name alias) {
        this(alias, LINK);
    }

    public Link() {
        this(DSL.name("link"), null);
    }

    public <O extends Record> Link(Table<O> child, ForeignKey<O, LinkRecord> key) {
        super(child, key, LINK);
    }

    @Override
    @NotNull
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    @NotNull
    public Identity<LinkRecord, Long> getIdentity() {
        return (Identity<LinkRecord, Long>) super.getIdentity();
    }

    @Override
    @NotNull
    public UniqueKey<LinkRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_32;
    }

    @Override
    @NotNull
    public List<UniqueKey<LinkRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.CONSTRAINT_32A);
    }

    @Override
    @NotNull
    public Link as(String alias) {
        return new Link(DSL.name(alias), this);
    }

    @Override
    @NotNull
    public Link as(Name alias) {
        return new Link(alias, this);
    }

    @Override
    @NotNull
    public Link as(Table<?> alias) {
        return new Link(alias.getQualifiedName(), this);
    }

    @Override
    @NotNull
    public Link rename(String name) {
        return new Link(DSL.name(name), null);
    }

    @Override
    @NotNull
    public Link rename(Name name) {
        return new Link(name, null);
    }

    @Override
    @NotNull
    public Link rename(Table<?> name) {
        return new Link(name.getQualifiedName(), null);
    }

    @Override
    @NotNull
    public Row8<Long, String, LocalDateTime, LocalDateTime, String, Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    public <U> SelectField<U> mapping(Function8<? super Long, ? super String, ? super LocalDateTime, ? super LocalDateTime, ? super String, ? super Integer, ? super Integer, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    public <U> SelectField<U> mapping(Class<U> toType, Function8<? super Long, ? super String, ? super LocalDateTime, ? super LocalDateTime, ? super String, ? super Integer, ? super Integer, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}