# -*- coding:utf-8 -*-
import re
import json
import requests
import sys
from bs4 import BeautifulSoup

#得到最新的URL
def setOne():
    url = "http://weixin.sogou.com/weixin?type=1&s_from=input&query=nxstjt&ie=utf8&_sug_=n&_sug_type_="
    headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36'}
    result = requests.get(url,headers=headers)
    soup = BeautifulSoup(result.text)
    divtxt = soup.find("p",attrs={'class':'tit'})
    divtxt = str(divtxt)
    webpage_regex = re.compile('<a[^>]+href=["\'](.*?)["\']', re.IGNORECASE)
    txt = webpage_regex.findall(divtxt)[0]
    txt = txt.replace("&amp;","&",3)
    return txt


#得到JSON
def setTwo(thenewurl):
    headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36'}
    html = requests.get(thenewurl,headers=headers)
    soup = BeautifulSoup(html.text)
    listScript = soup.find_all('script')
    listScript = listScript[len(listScript)-2]
    singleScript = str(listScript);
    beginIndex = singleScript.find('var msgList = ')
    endIndex =  singleScript.find('seajs.use("sougou/profile.js");')
    singleScript = singleScript[beginIndex:endIndex]
    beginIndex = singleScript.find('{')
    endIndex = singleScript.find('};')
    singleScript = singleScript[beginIndex:endIndex]
    singleScript = singleScript + "}"
    output = open('data.txt', 'w')
    output.write(singleScript)
    output.close()

#得到单个页面的内容
def setThree():
    openread = open("data.txt",'r')
    pythonJSON = json.loads(openread.read())    
    openread.close()

    for single in pythonJSON["list"]:     # 第一个实例
        txt = single["app_msg_ext_info"]["content_url"]
        txt = txt.replace("&amp;","&",3)
        r = requests.get('https://mp.weixin.qq.com'+txt)
        fileId = single['app_msg_ext_info']['fileid']
        fileId = str(fileId)
        soup = BeautifulSoup(r.text)
        title = soup.find('h2',attrs={'class':'rich_media_title'})
        content = soup.find('div',attrs={'class':'rich_media_content'})
        output = open(fileId+'.title', 'w')
        output.write(str(title))
        output.close()
        output = open(fileId+'.content', 'w')
        output.write(str(content))
        output.close()
        webpage_regex = re.compile('<p><img[^>]+data-src=["\'](.*?)["\']', re.IGNORECASE)
        txt = webpage_regex.findall(r.text)
        output = open(fileId+'.img', 'wb')
        output.write(json.dumps(txt))
        output.close()
        saveSingleImg(single["app_msg_ext_info"]["cover"],fileId)
        saveImg(txt,fileId)
        if single["app_msg_ext_info"]["is_multi"]==1:
            for child in single["app_msg_ext_info"]["multi_app_msg_item_list"]:
                txt = child["content_url"]
                txt = txt.replace("&amp;","&",3)
                r = requests.get('https://mp.weixin.qq.com'+txt)
                fileId = str(child["fileid"])
                soup = BeautifulSoup(r.text)
                title = soup.find('h2',attrs={'class':'rich_media_title'})
                content = soup.find('div',attrs={'class':'rich_media_content'})
                output = open(fileId+'.title', 'w')
                output.write(str(title))
                output.close()
                output = open(fileId+'.content', 'w')
                output.write(str(content))
                output.close()
                webpage_regex = re.compile('<p><img[^>]+data-src=["\'](.*?)["\']', re.IGNORECASE)
                txt = webpage_regex.findall(r.text)
                output = open(fileId+'.img', 'wb')
                output.write(json.dumps(txt))
                output.close()
                saveSingleImg(child["cover"],fileId)
                saveImg(txt,fileId)

def saveSingleImg(url,fileName):
    starIndex = url.find("wx_fmt=")
    endFileName = url[starIndex:]
    endFileName = endFileName.replace("wx_fmt=",".")
    fileName = fileName +"_title"+endFileName
    print fileName
    html = requests.get(url)
    with open(fileName,"wb") as f:
        f.write(html.content)
    

def saveImg(JSONObj,fileNameArge):
    index = 0
    fileName = ""
    for singleInstance in JSONObj:
        print singleInstance
        if len(singleInstance)>0 and singleInstance.startswith("http"):
            if singleInstance.endswith("png"):
                fileName = fileNameArge + "_" +str(index)+".png" 
            elif singleInstance.endswith("jpg"):
                fileName = fileNameArge + "_" +str(index)+".jpg"
            elif singleInstance.endswith("jpeg"):
                fileName = fileNameArge + "_" +str(index)+".jpeg"

            if len(fileName)>0:    
                html = requests.get(singleInstance)
                with open(fileName,"wb") as f:
                    f.write(html.content)
        index+=1    



if __name__ == '__main__':
    reload(sys)
    sys.setdefaultencoding('utf-8')
    txt = setOne()
    setTwo(txt)
    setThree()

    #saveSingleImg('http://mmbiz.qpic.cn/mmbiz_jpg/DSJPib46lLR4VLyrDjIWvEu3I1u3XZvIsxXtIZicgzyovpz2MroNwMWHicDvEficPVAeawHoNibzzZ0TBJl2RxRbsicA/0?wx_fmt=jpeg',23242341343)
    
