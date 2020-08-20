## General Java Tool For convert numbers to words.

This is a library for convert any number to words. Now supported for Integer Numbers and English, Azerbaijan, Russian (partially - more test cases need to be implemented) languages.

#### How it works

First, we have defined the rules.json file. this file contains rules for several languages (now English, Azerbaijan, Russian languages supported). for many languages, the spelling numbers have similar patterns. We have to define translations of base numbers. (let's call this "basic number rules")

<pre>
<code>
"zero": {
    "en": {
      "0": "zero"
    },
    "ru": {
      "0": "ноль"
    },
    "az": {
      "0": "sıfır"
    }
  },
  "ones" : {
    "en": {
      "1": "one",
      "2": "two",
      "3": "three",
      "4": "four",
      "5": "five",
      "6": "six",
      "7": "seven",
      "8": "eight",
      "9": "nine"
    },
    "ru": {
      "1": "один",
      "2": "два",
      "3": "три",
      "4": "четыре",
      "5": "пять",
      "6": "шесть",
      "7": "семь",
      "8": "восемь",
      "9": "девять"
    },
    "az": {
      "1": "bir",
      "2": "iki",
      "3": "üç",
      "4": "dörd",
      "5": "beş",
      "6": "altı",
      "7": "yeddi",
      "8": "səkkiz",
      "9": "doqquz"
    }
  },
  "tens": {
    "en": {
      "10": "ten",
      "20": "twenty",
      "30": "thirty",
      "40": "forty",
      "50": "fifty",
      "60": "sixty",
      "70": "seventy",
      "80": "eighty",
      "90": "ninety"
    },
    "ru": {
      "10": "десять",
      "20": "двадцать",
      "30": "тридцать",
      "40": "сорок",
      "50": "пятьдесят",
      "60": "шестьдесят",
      "70": "семьдесят",
      "80": "восемьдесят",
      "90": "девяносто"
    },
    "az": {
      "10": "on",
      "20": "iyirmi",
      "30": "otuz",
      "40": "qırx",
      "50": "əlli",
      "60": "altmış",
      "70": "yetmiş",
      "80": "səksən",
      "90": "doxsan"
    }
  }
  </code>
  </pre>
 
 Then, knowing the translation of these numbers, we have to define the rules for 10-99 (tens_rules), 100-999 (hundred_rules), 1000-999_999 (thousand_rules), 1_000_000-999_000_000 (million_rules) and 1_000_000_000-999_000_000_000 (billion_rules). There are some specific symbols for the rules.
 
  <pre># - refering to the  "base number rules" </pre>
  <pre>$ - how to make word (#SPACE$ - means space, $APPEND$ - means no any space)</pre>
  
  
Also, sometimes some numbers don't follow the rules. for example - eleven (11), twelve (12) (for comparison, just say 21,22,31,32,41,42,51,52 :)) or some numbers need to be changed grammatically (for example, 4 is four, but 40 is forty (compare with 6-60, 7-70, etc.)
<pre>
<code>
"tens_rules": {
    "en": {
      "rule": "#tens$SPACE$#ones",
      "exceptions": {
        "11": "eleven",
        "12": "twelve",
        "13": "thirteen",
        "14": "fourteen",
        "15": "fifteen",
        "16": "sixteen",
        "17": "seventeen",
        "18": "eighteen",
        "19": "nineteen"
      }
    },
    "ru": {
      "rule": "#tens$SPACE$#ones",
      "exceptions": {
        "11": "одиннадцать",
        "12": "двенадцать",
        "13": "тринадцать",
        "14": "четырнадцать",
        "15": "пятнадцать",
        "16": "шестнадцать",
        "17": "семнадцать",
        "18": "восемьнадцать",
        "19": "девятнадцать"
      }
    },
    "az": {
      "rule": "#tens$SPACE$#ones"
    }
  },
  "hundreds_rules": {
    "en": {
      "rule": "#ones$SPACE$hundred"
    },
    "ru": {
      "rule": "#ones$CONCAT$сот",
      "exceptions": {
        "100" : "сто",
        "200" : "двести",
        "300" : "триста",
        "400": "четыреста"
      }
    },
    "az": {
      "rule": "#ones$SPACE$yüz",
      "exceptions": {
        "100": "yüz"
      }
    }
  },
  </code>
  and others... "thousands_rules" , "millions_rules", "billions_rules"
  </pre>
....
 examples
 1. given number is 245. - this is will calculated based on hundred_rules.  
    - 245 -> #ones$SPACE$hundred. - #ones - 2, $SPACE - " ", hundred (just a word)
    -  2 from #ones "base number rules" => two hundred
    -  remaining part is 45 (245-200) -> #tens$SPACE$#ones - #tens - 40, SPACE - " ", #ones -5
    -  40 from #tens "base number rules" =>forty
    -  5 from #ones "base number rules" =>fice
    - result: two hundred forty five
  2. given number is 37. -  this is will calculated based on tens_rules
  37 -> #tens$SPACE$#ones - $tens - 30 , $SPACE - " " , #ones - 7
    -  30 from #tens "base number rules" => thirty
    -  7  from #ones "base number rules" => seven
    -  result: thirty seven
  3. given number is 12 - this is will calculated base on tens rules
  12 ->  #tens$SPACE$#ones. -  BUT 12 In the list of exceptions 
    -  result: twelve
      
   
Now only integers are supported, and it also supports searching and converting all POSITIVE numbers from a given string.

Anybody who wants to contribute , WELCOME ! :)
