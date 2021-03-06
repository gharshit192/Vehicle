/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package model;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Vehicle extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 989990914321086863L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Vehicle\",\"namespace\":\"model\",\"fields\":[{\"name\":\"uuid\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"registrationNumber\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"modelNo\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"chassisType\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"associatedDriverUUID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"eventType\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String uuid;
  @Deprecated public java.lang.String registrationNumber;
  @Deprecated public java.lang.String modelNo;
  @Deprecated public java.lang.String chassisType;
  @Deprecated public java.lang.String associatedDriverUUID;
  @Deprecated public java.lang.String eventType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Vehicle() {}

  /**
   * All-args constructor.
   * @param uuid The new value for uuid
   * @param registrationNumber The new value for registrationNumber
   * @param modelNo The new value for modelNo
   * @param chassisType The new value for chassisType
   * @param associatedDriverUUID The new value for associatedDriverUUID
   * @param eventType The new value for eventType
   */
  public Vehicle(java.lang.String uuid, java.lang.String registrationNumber, java.lang.String modelNo, java.lang.String chassisType, java.lang.String associatedDriverUUID, java.lang.String eventType) {
    this.uuid = uuid;
    this.registrationNumber = registrationNumber;
    this.modelNo = modelNo;
    this.chassisType = chassisType;
    this.associatedDriverUUID = associatedDriverUUID;
    this.eventType = eventType;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return uuid;
    case 1: return registrationNumber;
    case 2: return modelNo;
    case 3: return chassisType;
    case 4: return associatedDriverUUID;
    case 5: return eventType;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: uuid = (java.lang.String)value$; break;
    case 1: registrationNumber = (java.lang.String)value$; break;
    case 2: modelNo = (java.lang.String)value$; break;
    case 3: chassisType = (java.lang.String)value$; break;
    case 4: associatedDriverUUID = (java.lang.String)value$; break;
    case 5: eventType = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'uuid' field.
   * @return The value of the 'uuid' field.
   */
  public java.lang.String getUuid() {
    return uuid;
  }

  /**
   * Sets the value of the 'uuid' field.
   * @param value the value to set.
   */
  public void setUuid(java.lang.String value) {
    this.uuid = value;
  }

  /**
   * Gets the value of the 'registrationNumber' field.
   * @return The value of the 'registrationNumber' field.
   */
  public java.lang.String getRegistrationNumber() {
    return registrationNumber;
  }

  /**
   * Sets the value of the 'registrationNumber' field.
   * @param value the value to set.
   */
  public void setRegistrationNumber(java.lang.String value) {
    this.registrationNumber = value;
  }

  /**
   * Gets the value of the 'modelNo' field.
   * @return The value of the 'modelNo' field.
   */
  public java.lang.String getModelNo() {
    return modelNo;
  }

  /**
   * Sets the value of the 'modelNo' field.
   * @param value the value to set.
   */
  public void setModelNo(java.lang.String value) {
    this.modelNo = value;
  }

  /**
   * Gets the value of the 'chassisType' field.
   * @return The value of the 'chassisType' field.
   */
  public java.lang.String getChassisType() {
    return chassisType;
  }

  /**
   * Sets the value of the 'chassisType' field.
   * @param value the value to set.
   */
  public void setChassisType(java.lang.String value) {
    this.chassisType = value;
  }

  /**
   * Gets the value of the 'associatedDriverUUID' field.
   * @return The value of the 'associatedDriverUUID' field.
   */
  public java.lang.String getAssociatedDriverUUID() {
    return associatedDriverUUID;
  }

  /**
   * Sets the value of the 'associatedDriverUUID' field.
   * @param value the value to set.
   */
  public void setAssociatedDriverUUID(java.lang.String value) {
    this.associatedDriverUUID = value;
  }

  /**
   * Gets the value of the 'eventType' field.
   * @return The value of the 'eventType' field.
   */
  public java.lang.String getEventType() {
    return eventType;
  }

  /**
   * Sets the value of the 'eventType' field.
   * @param value the value to set.
   */
  public void setEventType(java.lang.String value) {
    this.eventType = value;
  }

  /**
   * Creates a new Vehicle RecordBuilder.
   * @return A new Vehicle RecordBuilder
   */
  public static model.Vehicle.Builder newBuilder() {
    return new model.Vehicle.Builder();
  }

  /**
   * Creates a new Vehicle RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Vehicle RecordBuilder
   */
  public static model.Vehicle.Builder newBuilder(model.Vehicle.Builder other) {
    return new model.Vehicle.Builder(other);
  }

  /**
   * Creates a new Vehicle RecordBuilder by copying an existing Vehicle instance.
   * @param other The existing instance to copy.
   * @return A new Vehicle RecordBuilder
   */
  public static model.Vehicle.Builder newBuilder(model.Vehicle other) {
    return new model.Vehicle.Builder(other);
  }

  /**
   * RecordBuilder for Vehicle instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Vehicle>
    implements org.apache.avro.data.RecordBuilder<Vehicle> {

    private java.lang.String uuid;
    private java.lang.String registrationNumber;
    private java.lang.String modelNo;
    private java.lang.String chassisType;
    private java.lang.String associatedDriverUUID;
    private java.lang.String eventType;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(model.Vehicle.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.uuid)) {
        this.uuid = data().deepCopy(fields()[0].schema(), other.uuid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.registrationNumber)) {
        this.registrationNumber = data().deepCopy(fields()[1].schema(), other.registrationNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.modelNo)) {
        this.modelNo = data().deepCopy(fields()[2].schema(), other.modelNo);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.chassisType)) {
        this.chassisType = data().deepCopy(fields()[3].schema(), other.chassisType);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.associatedDriverUUID)) {
        this.associatedDriverUUID = data().deepCopy(fields()[4].schema(), other.associatedDriverUUID);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.eventType)) {
        this.eventType = data().deepCopy(fields()[5].schema(), other.eventType);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Vehicle instance
     * @param other The existing instance to copy.
     */
    private Builder(model.Vehicle other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.uuid)) {
        this.uuid = data().deepCopy(fields()[0].schema(), other.uuid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.registrationNumber)) {
        this.registrationNumber = data().deepCopy(fields()[1].schema(), other.registrationNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.modelNo)) {
        this.modelNo = data().deepCopy(fields()[2].schema(), other.modelNo);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.chassisType)) {
        this.chassisType = data().deepCopy(fields()[3].schema(), other.chassisType);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.associatedDriverUUID)) {
        this.associatedDriverUUID = data().deepCopy(fields()[4].schema(), other.associatedDriverUUID);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.eventType)) {
        this.eventType = data().deepCopy(fields()[5].schema(), other.eventType);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'uuid' field.
      * @return The value.
      */
    public java.lang.String getUuid() {
      return uuid;
    }

    /**
      * Sets the value of the 'uuid' field.
      * @param value The value of 'uuid'.
      * @return This builder.
      */
    public model.Vehicle.Builder setUuid(java.lang.String value) {
      validate(fields()[0], value);
      this.uuid = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'uuid' field has been set.
      * @return True if the 'uuid' field has been set, false otherwise.
      */
    public boolean hasUuid() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'uuid' field.
      * @return This builder.
      */
    public model.Vehicle.Builder clearUuid() {
      uuid = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'registrationNumber' field.
      * @return The value.
      */
    public java.lang.String getRegistrationNumber() {
      return registrationNumber;
    }

    /**
      * Sets the value of the 'registrationNumber' field.
      * @param value The value of 'registrationNumber'.
      * @return This builder.
      */
    public model.Vehicle.Builder setRegistrationNumber(java.lang.String value) {
      validate(fields()[1], value);
      this.registrationNumber = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'registrationNumber' field has been set.
      * @return True if the 'registrationNumber' field has been set, false otherwise.
      */
    public boolean hasRegistrationNumber() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'registrationNumber' field.
      * @return This builder.
      */
    public model.Vehicle.Builder clearRegistrationNumber() {
      registrationNumber = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'modelNo' field.
      * @return The value.
      */
    public java.lang.String getModelNo() {
      return modelNo;
    }

    /**
      * Sets the value of the 'modelNo' field.
      * @param value The value of 'modelNo'.
      * @return This builder.
      */
    public model.Vehicle.Builder setModelNo(java.lang.String value) {
      validate(fields()[2], value);
      this.modelNo = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'modelNo' field has been set.
      * @return True if the 'modelNo' field has been set, false otherwise.
      */
    public boolean hasModelNo() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'modelNo' field.
      * @return This builder.
      */
    public model.Vehicle.Builder clearModelNo() {
      modelNo = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'chassisType' field.
      * @return The value.
      */
    public java.lang.String getChassisType() {
      return chassisType;
    }

    /**
      * Sets the value of the 'chassisType' field.
      * @param value The value of 'chassisType'.
      * @return This builder.
      */
    public model.Vehicle.Builder setChassisType(java.lang.String value) {
      validate(fields()[3], value);
      this.chassisType = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'chassisType' field has been set.
      * @return True if the 'chassisType' field has been set, false otherwise.
      */
    public boolean hasChassisType() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'chassisType' field.
      * @return This builder.
      */
    public model.Vehicle.Builder clearChassisType() {
      chassisType = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'associatedDriverUUID' field.
      * @return The value.
      */
    public java.lang.String getAssociatedDriverUUID() {
      return associatedDriverUUID;
    }

    /**
      * Sets the value of the 'associatedDriverUUID' field.
      * @param value The value of 'associatedDriverUUID'.
      * @return This builder.
      */
    public model.Vehicle.Builder setAssociatedDriverUUID(java.lang.String value) {
      validate(fields()[4], value);
      this.associatedDriverUUID = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'associatedDriverUUID' field has been set.
      * @return True if the 'associatedDriverUUID' field has been set, false otherwise.
      */
    public boolean hasAssociatedDriverUUID() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'associatedDriverUUID' field.
      * @return This builder.
      */
    public model.Vehicle.Builder clearAssociatedDriverUUID() {
      associatedDriverUUID = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'eventType' field.
      * @return The value.
      */
    public java.lang.String getEventType() {
      return eventType;
    }

    /**
      * Sets the value of the 'eventType' field.
      * @param value The value of 'eventType'.
      * @return This builder.
      */
    public model.Vehicle.Builder setEventType(java.lang.String value) {
      validate(fields()[5], value);
      this.eventType = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'eventType' field has been set.
      * @return True if the 'eventType' field has been set, false otherwise.
      */
    public boolean hasEventType() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'eventType' field.
      * @return This builder.
      */
    public model.Vehicle.Builder clearEventType() {
      eventType = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public Vehicle build() {
      try {
        Vehicle record = new Vehicle();
        record.uuid = fieldSetFlags()[0] ? this.uuid : (java.lang.String) defaultValue(fields()[0]);
        record.registrationNumber = fieldSetFlags()[1] ? this.registrationNumber : (java.lang.String) defaultValue(fields()[1]);
        record.modelNo = fieldSetFlags()[2] ? this.modelNo : (java.lang.String) defaultValue(fields()[2]);
        record.chassisType = fieldSetFlags()[3] ? this.chassisType : (java.lang.String) defaultValue(fields()[3]);
        record.associatedDriverUUID = fieldSetFlags()[4] ? this.associatedDriverUUID : (java.lang.String) defaultValue(fields()[4]);
        record.eventType = fieldSetFlags()[5] ? this.eventType : (java.lang.String) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
