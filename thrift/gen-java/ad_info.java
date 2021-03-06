/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2014-12-16")
public class ad_info implements org.apache.thrift.TBase<ad_info, ad_info._Fields>, java.io.Serializable, Cloneable, Comparable<ad_info> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ad_info");

  private static final org.apache.thrift.protocol.TField OS_FIELD_DESC = new org.apache.thrift.protocol.TField("os", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField BROWSER_FIELD_DESC = new org.apache.thrift.protocol.TField("browser", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField REGION_FIELD_DESC = new org.apache.thrift.protocol.TField("region", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField HOUR_FIELD_DESC = new org.apache.thrift.protocol.TField("hour", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField SEARCH_WORD_FIELD_DESC = new org.apache.thrift.protocol.TField("searchWord", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ad_infoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ad_infoTupleSchemeFactory());
  }

  public String os; // required
  public String browser; // required
  public String region; // required
  public int hour; // required
  public String searchWord; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OS((short)1, "os"),
    BROWSER((short)2, "browser"),
    REGION((short)3, "region"),
    HOUR((short)4, "hour"),
    SEARCH_WORD((short)5, "searchWord");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // OS
          return OS;
        case 2: // BROWSER
          return BROWSER;
        case 3: // REGION
          return REGION;
        case 4: // HOUR
          return HOUR;
        case 5: // SEARCH_WORD
          return SEARCH_WORD;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __HOUR_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OS, new org.apache.thrift.meta_data.FieldMetaData("os", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BROWSER, new org.apache.thrift.meta_data.FieldMetaData("browser", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REGION, new org.apache.thrift.meta_data.FieldMetaData("region", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HOUR, new org.apache.thrift.meta_data.FieldMetaData("hour", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SEARCH_WORD, new org.apache.thrift.meta_data.FieldMetaData("searchWord", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ad_info.class, metaDataMap);
  }

  public ad_info() {
  }

  public ad_info(
    String os,
    String browser,
    String region,
    int hour,
    String searchWord)
  {
    this();
    this.os = os;
    this.browser = browser;
    this.region = region;
    this.hour = hour;
    setHourIsSet(true);
    this.searchWord = searchWord;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ad_info(ad_info other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetOs()) {
      this.os = other.os;
    }
    if (other.isSetBrowser()) {
      this.browser = other.browser;
    }
    if (other.isSetRegion()) {
      this.region = other.region;
    }
    this.hour = other.hour;
    if (other.isSetSearchWord()) {
      this.searchWord = other.searchWord;
    }
  }

  public ad_info deepCopy() {
    return new ad_info(this);
  }

  @Override
  public void clear() {
    this.os = null;
    this.browser = null;
    this.region = null;
    setHourIsSet(false);
    this.hour = 0;
    this.searchWord = null;
  }

  public String getOs() {
    return this.os;
  }

  public ad_info setOs(String os) {
    this.os = os;
    return this;
  }

  public void unsetOs() {
    this.os = null;
  }

  /** Returns true if field os is set (has been assigned a value) and false otherwise */
  public boolean isSetOs() {
    return this.os != null;
  }

  public void setOsIsSet(boolean value) {
    if (!value) {
      this.os = null;
    }
  }

  public String getBrowser() {
    return this.browser;
  }

  public ad_info setBrowser(String browser) {
    this.browser = browser;
    return this;
  }

  public void unsetBrowser() {
    this.browser = null;
  }

  /** Returns true if field browser is set (has been assigned a value) and false otherwise */
  public boolean isSetBrowser() {
    return this.browser != null;
  }

  public void setBrowserIsSet(boolean value) {
    if (!value) {
      this.browser = null;
    }
  }

  public String getRegion() {
    return this.region;
  }

  public ad_info setRegion(String region) {
    this.region = region;
    return this;
  }

  public void unsetRegion() {
    this.region = null;
  }

  /** Returns true if field region is set (has been assigned a value) and false otherwise */
  public boolean isSetRegion() {
    return this.region != null;
  }

  public void setRegionIsSet(boolean value) {
    if (!value) {
      this.region = null;
    }
  }

  public int getHour() {
    return this.hour;
  }

  public ad_info setHour(int hour) {
    this.hour = hour;
    setHourIsSet(true);
    return this;
  }

  public void unsetHour() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __HOUR_ISSET_ID);
  }

  /** Returns true if field hour is set (has been assigned a value) and false otherwise */
  public boolean isSetHour() {
    return EncodingUtils.testBit(__isset_bitfield, __HOUR_ISSET_ID);
  }

  public void setHourIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __HOUR_ISSET_ID, value);
  }

  public String getSearchWord() {
    return this.searchWord;
  }

  public ad_info setSearchWord(String searchWord) {
    this.searchWord = searchWord;
    return this;
  }

  public void unsetSearchWord() {
    this.searchWord = null;
  }

  /** Returns true if field searchWord is set (has been assigned a value) and false otherwise */
  public boolean isSetSearchWord() {
    return this.searchWord != null;
  }

  public void setSearchWordIsSet(boolean value) {
    if (!value) {
      this.searchWord = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case OS:
      if (value == null) {
        unsetOs();
      } else {
        setOs((String)value);
      }
      break;

    case BROWSER:
      if (value == null) {
        unsetBrowser();
      } else {
        setBrowser((String)value);
      }
      break;

    case REGION:
      if (value == null) {
        unsetRegion();
      } else {
        setRegion((String)value);
      }
      break;

    case HOUR:
      if (value == null) {
        unsetHour();
      } else {
        setHour((Integer)value);
      }
      break;

    case SEARCH_WORD:
      if (value == null) {
        unsetSearchWord();
      } else {
        setSearchWord((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OS:
      return getOs();

    case BROWSER:
      return getBrowser();

    case REGION:
      return getRegion();

    case HOUR:
      return Integer.valueOf(getHour());

    case SEARCH_WORD:
      return getSearchWord();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case OS:
      return isSetOs();
    case BROWSER:
      return isSetBrowser();
    case REGION:
      return isSetRegion();
    case HOUR:
      return isSetHour();
    case SEARCH_WORD:
      return isSetSearchWord();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ad_info)
      return this.equals((ad_info)that);
    return false;
  }

  public boolean equals(ad_info that) {
    if (that == null)
      return false;

    boolean this_present_os = true && this.isSetOs();
    boolean that_present_os = true && that.isSetOs();
    if (this_present_os || that_present_os) {
      if (!(this_present_os && that_present_os))
        return false;
      if (!this.os.equals(that.os))
        return false;
    }

    boolean this_present_browser = true && this.isSetBrowser();
    boolean that_present_browser = true && that.isSetBrowser();
    if (this_present_browser || that_present_browser) {
      if (!(this_present_browser && that_present_browser))
        return false;
      if (!this.browser.equals(that.browser))
        return false;
    }

    boolean this_present_region = true && this.isSetRegion();
    boolean that_present_region = true && that.isSetRegion();
    if (this_present_region || that_present_region) {
      if (!(this_present_region && that_present_region))
        return false;
      if (!this.region.equals(that.region))
        return false;
    }

    boolean this_present_hour = true;
    boolean that_present_hour = true;
    if (this_present_hour || that_present_hour) {
      if (!(this_present_hour && that_present_hour))
        return false;
      if (this.hour != that.hour)
        return false;
    }

    boolean this_present_searchWord = true && this.isSetSearchWord();
    boolean that_present_searchWord = true && that.isSetSearchWord();
    if (this_present_searchWord || that_present_searchWord) {
      if (!(this_present_searchWord && that_present_searchWord))
        return false;
      if (!this.searchWord.equals(that.searchWord))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_os = true && (isSetOs());
    list.add(present_os);
    if (present_os)
      list.add(os);

    boolean present_browser = true && (isSetBrowser());
    list.add(present_browser);
    if (present_browser)
      list.add(browser);

    boolean present_region = true && (isSetRegion());
    list.add(present_region);
    if (present_region)
      list.add(region);

    boolean present_hour = true;
    list.add(present_hour);
    if (present_hour)
      list.add(hour);

    boolean present_searchWord = true && (isSetSearchWord());
    list.add(present_searchWord);
    if (present_searchWord)
      list.add(searchWord);

    return list.hashCode();
  }

  @Override
  public int compareTo(ad_info other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetOs()).compareTo(other.isSetOs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.os, other.os);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBrowser()).compareTo(other.isSetBrowser());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBrowser()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.browser, other.browser);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRegion()).compareTo(other.isSetRegion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRegion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.region, other.region);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHour()).compareTo(other.isSetHour());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHour()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hour, other.hour);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSearchWord()).compareTo(other.isSetSearchWord());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSearchWord()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.searchWord, other.searchWord);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ad_info(");
    boolean first = true;

    sb.append("os:");
    if (this.os == null) {
      sb.append("null");
    } else {
      sb.append(this.os);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("browser:");
    if (this.browser == null) {
      sb.append("null");
    } else {
      sb.append(this.browser);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("region:");
    if (this.region == null) {
      sb.append("null");
    } else {
      sb.append(this.region);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("hour:");
    sb.append(this.hour);
    first = false;
    if (!first) sb.append(", ");
    sb.append("searchWord:");
    if (this.searchWord == null) {
      sb.append("null");
    } else {
      sb.append(this.searchWord);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ad_infoStandardSchemeFactory implements SchemeFactory {
    public ad_infoStandardScheme getScheme() {
      return new ad_infoStandardScheme();
    }
  }

  private static class ad_infoStandardScheme extends StandardScheme<ad_info> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ad_info struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.os = iprot.readString();
              struct.setOsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BROWSER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.browser = iprot.readString();
              struct.setBrowserIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // REGION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.region = iprot.readString();
              struct.setRegionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // HOUR
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.hour = iprot.readI32();
              struct.setHourIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // SEARCH_WORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.searchWord = iprot.readString();
              struct.setSearchWordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ad_info struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.os != null) {
        oprot.writeFieldBegin(OS_FIELD_DESC);
        oprot.writeString(struct.os);
        oprot.writeFieldEnd();
      }
      if (struct.browser != null) {
        oprot.writeFieldBegin(BROWSER_FIELD_DESC);
        oprot.writeString(struct.browser);
        oprot.writeFieldEnd();
      }
      if (struct.region != null) {
        oprot.writeFieldBegin(REGION_FIELD_DESC);
        oprot.writeString(struct.region);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(HOUR_FIELD_DESC);
      oprot.writeI32(struct.hour);
      oprot.writeFieldEnd();
      if (struct.searchWord != null) {
        oprot.writeFieldBegin(SEARCH_WORD_FIELD_DESC);
        oprot.writeString(struct.searchWord);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ad_infoTupleSchemeFactory implements SchemeFactory {
    public ad_infoTupleScheme getScheme() {
      return new ad_infoTupleScheme();
    }
  }

  private static class ad_infoTupleScheme extends TupleScheme<ad_info> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ad_info struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetOs()) {
        optionals.set(0);
      }
      if (struct.isSetBrowser()) {
        optionals.set(1);
      }
      if (struct.isSetRegion()) {
        optionals.set(2);
      }
      if (struct.isSetHour()) {
        optionals.set(3);
      }
      if (struct.isSetSearchWord()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetOs()) {
        oprot.writeString(struct.os);
      }
      if (struct.isSetBrowser()) {
        oprot.writeString(struct.browser);
      }
      if (struct.isSetRegion()) {
        oprot.writeString(struct.region);
      }
      if (struct.isSetHour()) {
        oprot.writeI32(struct.hour);
      }
      if (struct.isSetSearchWord()) {
        oprot.writeString(struct.searchWord);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ad_info struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.os = iprot.readString();
        struct.setOsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.browser = iprot.readString();
        struct.setBrowserIsSet(true);
      }
      if (incoming.get(2)) {
        struct.region = iprot.readString();
        struct.setRegionIsSet(true);
      }
      if (incoming.get(3)) {
        struct.hour = iprot.readI32();
        struct.setHourIsSet(true);
      }
      if (incoming.get(4)) {
        struct.searchWord = iprot.readString();
        struct.setSearchWordIsSet(true);
      }
    }
  }

}

