/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef AdServerService_H
#define AdServerService_H

#include <thrift/TDispatchProcessor.h>
#include "adserver_types.h"



class AdServerServiceIf {
 public:
  virtual ~AdServerServiceIf() {}
  virtual void ask4Ads(std::vector<std::string> & _return, const ad_info& info) = 0;
};

class AdServerServiceIfFactory {
 public:
  typedef AdServerServiceIf Handler;

  virtual ~AdServerServiceIfFactory() {}

  virtual AdServerServiceIf* getHandler(const ::apache::thrift::TConnectionInfo& connInfo) = 0;
  virtual void releaseHandler(AdServerServiceIf* /* handler */) = 0;
};

class AdServerServiceIfSingletonFactory : virtual public AdServerServiceIfFactory {
 public:
  AdServerServiceIfSingletonFactory(const boost::shared_ptr<AdServerServiceIf>& iface) : iface_(iface) {}
  virtual ~AdServerServiceIfSingletonFactory() {}

  virtual AdServerServiceIf* getHandler(const ::apache::thrift::TConnectionInfo&) {
    return iface_.get();
  }
  virtual void releaseHandler(AdServerServiceIf* /* handler */) {}

 protected:
  boost::shared_ptr<AdServerServiceIf> iface_;
};

class AdServerServiceNull : virtual public AdServerServiceIf {
 public:
  virtual ~AdServerServiceNull() {}
  void ask4Ads(std::vector<std::string> & /* _return */, const ad_info& /* info */) {
    return;
  }
};

typedef struct _AdServerService_ask4Ads_args__isset {
  _AdServerService_ask4Ads_args__isset() : info(false) {}
  bool info :1;
} _AdServerService_ask4Ads_args__isset;

class AdServerService_ask4Ads_args {
 public:

  static const char* ascii_fingerprint; // = "54C947C75B644568246D9C4E0D68B6DB";
  static const uint8_t binary_fingerprint[16]; // = {0x54,0xC9,0x47,0xC7,0x5B,0x64,0x45,0x68,0x24,0x6D,0x9C,0x4E,0x0D,0x68,0xB6,0xDB};

  AdServerService_ask4Ads_args(const AdServerService_ask4Ads_args&);
  AdServerService_ask4Ads_args& operator=(const AdServerService_ask4Ads_args&);
  AdServerService_ask4Ads_args() {
  }

  virtual ~AdServerService_ask4Ads_args() throw();
  ad_info info;

  _AdServerService_ask4Ads_args__isset __isset;

  void __set_info(const ad_info& val);

  bool operator == (const AdServerService_ask4Ads_args & rhs) const
  {
    if (!(info == rhs.info))
      return false;
    return true;
  }
  bool operator != (const AdServerService_ask4Ads_args &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const AdServerService_ask4Ads_args & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  friend std::ostream& operator<<(std::ostream& out, const AdServerService_ask4Ads_args& obj);
};


class AdServerService_ask4Ads_pargs {
 public:

  static const char* ascii_fingerprint; // = "54C947C75B644568246D9C4E0D68B6DB";
  static const uint8_t binary_fingerprint[16]; // = {0x54,0xC9,0x47,0xC7,0x5B,0x64,0x45,0x68,0x24,0x6D,0x9C,0x4E,0x0D,0x68,0xB6,0xDB};


  virtual ~AdServerService_ask4Ads_pargs() throw();
  const ad_info* info;

  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  friend std::ostream& operator<<(std::ostream& out, const AdServerService_ask4Ads_pargs& obj);
};

typedef struct _AdServerService_ask4Ads_result__isset {
  _AdServerService_ask4Ads_result__isset() : success(false) {}
  bool success :1;
} _AdServerService_ask4Ads_result__isset;

class AdServerService_ask4Ads_result {
 public:

  static const char* ascii_fingerprint; // = "C844643081B14EA3A81E57199FB2B504";
  static const uint8_t binary_fingerprint[16]; // = {0xC8,0x44,0x64,0x30,0x81,0xB1,0x4E,0xA3,0xA8,0x1E,0x57,0x19,0x9F,0xB2,0xB5,0x04};

  AdServerService_ask4Ads_result(const AdServerService_ask4Ads_result&);
  AdServerService_ask4Ads_result& operator=(const AdServerService_ask4Ads_result&);
  AdServerService_ask4Ads_result() {
  }

  virtual ~AdServerService_ask4Ads_result() throw();
  std::vector<std::string>  success;

  _AdServerService_ask4Ads_result__isset __isset;

  void __set_success(const std::vector<std::string> & val);

  bool operator == (const AdServerService_ask4Ads_result & rhs) const
  {
    if (!(success == rhs.success))
      return false;
    return true;
  }
  bool operator != (const AdServerService_ask4Ads_result &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const AdServerService_ask4Ads_result & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  friend std::ostream& operator<<(std::ostream& out, const AdServerService_ask4Ads_result& obj);
};

typedef struct _AdServerService_ask4Ads_presult__isset {
  _AdServerService_ask4Ads_presult__isset() : success(false) {}
  bool success :1;
} _AdServerService_ask4Ads_presult__isset;

class AdServerService_ask4Ads_presult {
 public:

  static const char* ascii_fingerprint; // = "C844643081B14EA3A81E57199FB2B504";
  static const uint8_t binary_fingerprint[16]; // = {0xC8,0x44,0x64,0x30,0x81,0xB1,0x4E,0xA3,0xA8,0x1E,0x57,0x19,0x9F,0xB2,0xB5,0x04};


  virtual ~AdServerService_ask4Ads_presult() throw();
  std::vector<std::string> * success;

  _AdServerService_ask4Ads_presult__isset __isset;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);

  friend std::ostream& operator<<(std::ostream& out, const AdServerService_ask4Ads_presult& obj);
};

class AdServerServiceClient : virtual public AdServerServiceIf {
 public:
  AdServerServiceClient(boost::shared_ptr< ::apache::thrift::protocol::TProtocol> prot) {
    setProtocol(prot);
  }
  AdServerServiceClient(boost::shared_ptr< ::apache::thrift::protocol::TProtocol> iprot, boost::shared_ptr< ::apache::thrift::protocol::TProtocol> oprot) {
    setProtocol(iprot,oprot);
  }
 private:
  void setProtocol(boost::shared_ptr< ::apache::thrift::protocol::TProtocol> prot) {
  setProtocol(prot,prot);
  }
  void setProtocol(boost::shared_ptr< ::apache::thrift::protocol::TProtocol> iprot, boost::shared_ptr< ::apache::thrift::protocol::TProtocol> oprot) {
    piprot_=iprot;
    poprot_=oprot;
    iprot_ = iprot.get();
    oprot_ = oprot.get();
  }
 public:
  boost::shared_ptr< ::apache::thrift::protocol::TProtocol> getInputProtocol() {
    return piprot_;
  }
  boost::shared_ptr< ::apache::thrift::protocol::TProtocol> getOutputProtocol() {
    return poprot_;
  }
  void ask4Ads(std::vector<std::string> & _return, const ad_info& info);
  void send_ask4Ads(const ad_info& info);
  void recv_ask4Ads(std::vector<std::string> & _return);
 protected:
  boost::shared_ptr< ::apache::thrift::protocol::TProtocol> piprot_;
  boost::shared_ptr< ::apache::thrift::protocol::TProtocol> poprot_;
  ::apache::thrift::protocol::TProtocol* iprot_;
  ::apache::thrift::protocol::TProtocol* oprot_;
};

class AdServerServiceProcessor : public ::apache::thrift::TDispatchProcessor {
 protected:
  boost::shared_ptr<AdServerServiceIf> iface_;
  virtual bool dispatchCall(::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, const std::string& fname, int32_t seqid, void* callContext);
 private:
  typedef  void (AdServerServiceProcessor::*ProcessFunction)(int32_t, ::apache::thrift::protocol::TProtocol*, ::apache::thrift::protocol::TProtocol*, void*);
  typedef std::map<std::string, ProcessFunction> ProcessMap;
  ProcessMap processMap_;
  void process_ask4Ads(int32_t seqid, ::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, void* callContext);
 public:
  AdServerServiceProcessor(boost::shared_ptr<AdServerServiceIf> iface) :
    iface_(iface) {
    processMap_["ask4Ads"] = &AdServerServiceProcessor::process_ask4Ads;
  }

  virtual ~AdServerServiceProcessor() {}
};

class AdServerServiceProcessorFactory : public ::apache::thrift::TProcessorFactory {
 public:
  AdServerServiceProcessorFactory(const ::boost::shared_ptr< AdServerServiceIfFactory >& handlerFactory) :
      handlerFactory_(handlerFactory) {}

  ::boost::shared_ptr< ::apache::thrift::TProcessor > getProcessor(const ::apache::thrift::TConnectionInfo& connInfo);

 protected:
  ::boost::shared_ptr< AdServerServiceIfFactory > handlerFactory_;
};

class AdServerServiceMultiface : virtual public AdServerServiceIf {
 public:
  AdServerServiceMultiface(std::vector<boost::shared_ptr<AdServerServiceIf> >& ifaces) : ifaces_(ifaces) {
  }
  virtual ~AdServerServiceMultiface() {}
 protected:
  std::vector<boost::shared_ptr<AdServerServiceIf> > ifaces_;
  AdServerServiceMultiface() {}
  void add(boost::shared_ptr<AdServerServiceIf> iface) {
    ifaces_.push_back(iface);
  }
 public:
  void ask4Ads(std::vector<std::string> & _return, const ad_info& info) {
    size_t sz = ifaces_.size();
    size_t i = 0;
    for (; i < (sz - 1); ++i) {
      ifaces_[i]->ask4Ads(_return, info);
    }
    ifaces_[i]->ask4Ads(_return, info);
    return;
  }

};



#endif
