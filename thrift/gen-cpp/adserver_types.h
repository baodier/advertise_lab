/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef adserver_TYPES_H
#define adserver_TYPES_H

#include <iosfwd>

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>

#include <thrift/cxxfunctional.h>




class ad_info;

typedef struct _ad_info__isset {
  _ad_info__isset() : os(false), browser(false), region(false), hour(false), searchWord(false) {}
  bool os :1;
  bool browser :1;
  bool region :1;
  bool hour :1;
  bool searchWord :1;
} _ad_info__isset;

class ad_info {
 public:

  static const char* ascii_fingerprint; // = "C18AD26BF3FFAD5198DC3D25D5D7A521";
  static const uint8_t binary_fingerprint[16]; // = {0xC1,0x8A,0xD2,0x6B,0xF3,0xFF,0xAD,0x51,0x98,0xDC,0x3D,0x25,0xD5,0xD7,0xA5,0x21};

  ad_info(const ad_info&);
  ad_info& operator=(const ad_info&);
  ad_info() : os(), browser(), region(), hour(0), searchWord() {
  }

  virtual ~ad_info() throw();
  std::string os;
  std::string browser;
  std::string region;
  int32_t hour;
  std::string searchWord;

  _ad_info__isset __isset;

  void __set_os(const std::string& val);

  void __set_browser(const std::string& val);

  void __set_region(const std::string& val);

  void __set_hour(const int32_t val);

  void __set_searchWord(const std::string& val);

  bool operator == (const ad_info & rhs) const
  {
    if (!(os == rhs.os))
      return false;
    if (!(browser == rhs.browser))
      return false;
    if (!(region == rhs.region))
      return false;
    if (!(hour == rhs.hour))
      return false;
    if (!(searchWord == rhs.searchWord))
      return false;
    return true;
  }
  bool operator != (const ad_info &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const ad_info & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  friend std::ostream& operator<<(std::ostream& out, const ad_info& obj);
};

void swap(ad_info &a, ad_info &b);



#endif
