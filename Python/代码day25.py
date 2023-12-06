#!/usr/bin/python 
# -*- coding: utf-8 -*-
import requests
from lxml import html
def spider_zhihudaily():
    url = "http://daily.zhihu.com/"
        headers = {"user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36 Edg/104.0.1293.70"}
        response = requests.get(url, headers = headers)
        url_data = response.text#获取响应体文本数据
        selector = html.fromstring(url_data)#选择器