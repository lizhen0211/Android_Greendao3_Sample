package com.lz.android_greendao3_sample;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Entity 表示这个实体类一会会在数据库中生成对应的表
 * @Entity( // If you have more than one schema, you can tell greenDAO
 * // to which schema an entity belongs (pick any string as a name).
 * schema = "myschema",
 * <p>
 * // Flag to make an entity "active": Active entities have update,
 * // delete, and refresh methods.
 * active = true,
 * <p>
 * // Specifies the name of the table in the database.
 * // By default, the name is based on the entities class name.
 * nameInDb = "AWESOME_USERS",
 * <p>
 * // Define indexes spanning multiple columns here.
 * indexes = {
 * @Index(value = "name DESC", unique = true)
 * },
 * <p>
 * // Flag if the DAO should create the database table (default is true).
 * // Set this to false, if you have multiple entities mapping to one table,
 * // or the table creation is done outside of greenDAO.
 * createInDb = false,
 * <p>
 * // Whether an all properties constructor should be generated.
 * // A no-args constructor is always required.
 * generateConstructors = true,
 * <p>
 * // Whether getters and setters for properties should be generated if missing.
 * generateGettersSetters = true
 * )
 */
@Entity
public class User {

    /**
     * @Id 表示该字段是id
     * <p>
     * The @Id annotation selects a long/ Long property as the entity ID. In database terms, it’s the primary key.
     * The parameter autoincrement is a flag to make the ID value ever increasing (not reusing old values).
     */
    @Id(autoincrement = true)
    private Long id;

    /**
     * @Property 则表示该属性将作为表的一个字段，
     * 其中nameInDb看名字就知道这个属性在数据库中对应的数据名称。
     * @Property lets you define a non-default column name, which the property is mapped to.
     * If absent, greenDAO will use the field name in a SQL-ish
     * fashion (upper case, underscores instead of camel case, for example customName will become CUSTOM_NAME).
     * Note: you currently can only use inline constants to specify a column name
     */
    @Property(nameInDb = "USERNAME")
    private String name;

    /**
     * @NotNull 表示该字段不可以为空
     *
     * @NotNull makes the property a “NOT NULL” column on the database side.
     * Usually it makes sense to mark primitive types (long, int, short, byte) with @NotNull,
     * while having nullable values with wrapper classes (Long, Integer, Short, Byte).
     */
    @NotNull
    private int repos;

    /**
     * @Transient 该注解表示这个属性将不会作为数据表中的一个字段
     *
     * @Transient marks properties to be excluded from persistence.
     * Use those for temporary states, etc.
     * Alternatively, you can also use the transient keyword from Java.
     */
    @Transient
    private int tempUsageCount; // not persisted

    /**
     * @Unique 表示该字段唯一
     *
     * Use @Index at a property to create a database index for the corresponding database column.
     * Use the following parameters to customize
     *
     * name: If you do not like the default name greenDAO generates for the index, you can specify yours here
     * unique: Adds a UNIQUE constraint to the index, forcing all values to be unique.
     */
    @Index(unique = true)
    private String key;

    @Generated(hash = 1349228200)
    public User(Long id, String name, int repos, String key) {
        this.id = id;
        this.name = name;
        this.repos = repos;
        this.key = key;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepos() {
        return this.repos;
    }

    public void setRepos(int repos) {
        this.repos = repos;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    // getters and setters for id and user ...
}
