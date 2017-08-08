# -*- coding: utf-8 -*-
"""
Created on Tue Feb 28 10:24:09 2017

@author: ARDI
"""

import re, math, sys
from Sastrawi.Stemmer.StemmerFactory import StemmerFactory

def normalize(text, stop_words):
    text = [x.lower() for x in text]
    factory = StemmerFactory()
    stemmer = factory.create_stemmer()
    text = [stemmer.stem(sentence) for sentence in text]
    text = [x for x in text if x not in stop_words]
    return text
    
def getWordList(total_text, stop_words):
    all_text = []
    text = [x for x in re.sub("[^0-9a-zA-Z_\s]"," ",open(str(1)+".txt","r").read().replace('\n',' ')).split(' ') if len(x) > 0]
    text = normalize(text, stop_words)
         
    for x in text:
        if x not in all_text:
            all_text.append(x)

    for i in range(2,total_text+1):
        text = [x for x in re.sub("[^0-9a-zA-Z_\s]"," ",open(str(i)+".txt","r").read().replace('\n',' ')).split(' ') if len(x) > 0]
		
        text = normalize(text, stop_words)
  
        for x in text:
            if x not in all_text:
                all_text.append(x)
    return all_text
 
def countIDF(term, total_text, stop_words):
	
    count = [0 for i in range(0,len(term))]
    for i in range(1,total_text+1):
        text = [x for x in re.sub("[^0-9a-zA-Z_\s]"," ",open(str(i)+".txt","r").read().replace('\n',' ')).split(' ') if len(x) > 0]		
        text = normalize(text, stop_words)  
  
        for j in range(0,len(term)):
            if term[j] in text:
                count[j] = count[j] + 1
    result = []
    for i in range(0,len(term)):
        if count[i] > 0:
            result.append(1.0 + math.log(float(total_text)/float(count[i])))
        else:
            result.append(1.0)
    return result


def calculateTFIDF(text,IDF):
    loweredDocument = [x.lower() for x in text]
    TF = []
    for x in wordList:
        TF.append(loweredDocument.count(x.lower()) / float(len(loweredDocument)))
    TF = [float(x) for x in TF]
    
    temp = []
    for i in range(0,len(wordList)):
        temp.append(TF[i]*IDF[i])
    return temp

def cosine_similarity(tfidf1, tfidf2):
	dot_product = 0
	norm1 = 0
	norm2 = 0
	for i in range (0,len(tfidf2)):
		dot_product = dot_product + tfidf1[i]*tfidf2[i]
		norm1 = norm1 + (tfidf1[i]*tfidf1[i])
		norm2 = norm2 + (tfidf2[i]*tfidf2[i])
	norm1 = math.sqrt(norm1)
	norm2 = math.sqrt(norm2)
	return dot_product/(norm1*norm2)

WORD = re.compile(r'\w+')

if (len(sys.argv) < 4):exit()
arguments = sys.argv
number_of_files = int(arguments[1])
file1 = arguments[2]
file2 = arguments[3]

stop_words = open("stopword_list_tala.txt","r").read().split('\n')

wordList = getWordList(number_of_files, stop_words)
IDF = countIDF(wordList,number_of_files,stop_words)
    
text1 = [x for x in re.sub("[^0-9a-zA-Z_\s]"," ",open(file1,"r").read().replace('\n',' ')).split(' ') if len(x) > 0]
text1 = normalize(text1, stop_words)
tfidf1 = calculateTFIDF(text1, IDF)

text2 = [x for x in re.sub("[^0-9a-zA-Z_\s]"," ",open(file2,"r").read().replace('\n',' ')).split(' ') if len(x) > 0]
text2 = normalize(text2, stop_words)
tfidf2 = calculateTFIDF(text2, IDF)
print('Cosine:', cosine_similarity(tfidf1, tfidf2))