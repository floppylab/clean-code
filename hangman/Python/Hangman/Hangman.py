import sys
from random import randint
import os

F = open("resources/words.in")

words = F.readlines()

for i in range(len(words)):
    length = len(words[i])
    words[i] = words[i][0: length - 1]

wantPlay = True

while wantPlay:
    word = words[randint(0, len(words))].upper()


