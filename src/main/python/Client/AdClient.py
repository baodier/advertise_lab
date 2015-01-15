__author__ = 'liuyq'
#coding=UTF-8
#!/usr/bin/python

import sys

import AdServerService
import ttypes
from ttypes import *
import constants
from constants import *

from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
import datetime
from flup.server.fcgi import WSGIServer
import json

# global constant
oneday = datetime.timedelta(days=1)


"""
生成接口服务客户端对象
"""
class AdClient:

    ip = '127.0.0.1'
    port = "1267"

    def __init__(self, ip, port):
        self.client = self.getclient()
        self.ip = ip
        self.port = port

    def getclient(self):
        transport = TSocket.TSocket(self.ip, self.port)
        transport = TTransport.TBufferedTransport(transport)
        protocol = TBinaryProtocol.TBinaryProtocol(transport)
        client = AdServerService.Client(protocol)
        transport.open()
        return client

    # 获取查询列表
    def ask4Ads(self, info):
        ret = self.client.ask4Ads(info)
        print "ask4Ads: "
        print ret
        return ret


def myapp(environ, start_response):
    ret = environ['QUERY_STRING']
    #os=windows7&browser=chrome&searchword=tianjin
    serverClient = AdClient('127.0.0.1', 1267)
    #print serverClient.ip, serverClient.port


    mp = {}
    info = ad_info()
    sp = ret.strip().split("&")
    for item in sp:
        item_sp = item.strip().split("=")
        if len(item_sp)==2:
            mp[item_sp[0]] = item_sp[1]

    info.browser = mp["browser"]
    info.searchWord = mp["searchword"]
    info.os = mp["os"]

    ret = ""
    lst = serverClient.ask4Ads(info)
    mp = {}
    for count, ele in enumerate(lst):
        mp[count] = ele

    d2 = json.dumps(mp)
    start_response('200 OK', [('Content-Type', 'text/plain')])
    return [d2]#['Hello World!\n']



if __name__  == '__main__':
    #WSGIServer(myapp,bindAddress=('127.0.0.1', 9000)).run()
    #WSGIServer(myapp).run()
    WSGIServer(myapp, multithreaded=True, multiprocess=True, bindAddress=('127.0.0.1', 9000)).run()

