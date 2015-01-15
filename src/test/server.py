__author__ = 'liuyq'
#!/usr/bin/env python
# -*- coding: utf-8 -*-
import flup.server.fcgi as flups
import time

def application(environ, start_response):
    ret = ""
    try:
        uri = environ['PATH_INFO']
        if uri[-1] == "/":
            uri = uri[:-1]
        if uri == "":
            ret = str(environ)
        elif uri == "/sleep":
            time.sleep(5)
            ret = "sleep: 5 secends"
        else:
            ret = uri
    except Exception, e:
        ret = str(e)
    status = '200 OK'
    response_headers = [('Content-type','text/plain')]
    start_response(status, response_headers)
    return [ret]

if __name__ == "__main__":
    #flups.WSGIServer(application, multithreaded=True, multiprocess=False, bindAddress=('127.0.0.1', 5678)).run()
    flups.WSGIServer(application).run()