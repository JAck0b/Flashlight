package com.example.jakub.myapplication;

import java.util.LinkedList;
import java.util.List;

/*
This class represents entered word.
 */
class Word {
  /*
  Original message.
   */
  private String message;
  /*
  Translated message.
   */
  private List<Integer> integerList;

  Word (String message) {
    this.message = message.toLowerCase();
    integerList = new LinkedList<>();
    decipher();
  }

  /*
   * Morse Code
   * 0 - point
   * 1 - hyphen
   * 2 - end of word
   */
  private void decipher() {
    int length = message.length();
    for (int i = 0; i < length; i++) {
      switch (message.charAt(i)) {
        case 'a':
          integerList.add(0);
          integerList.add(1);
          break;
        case 'b':
          integerList.add(1);
          integerList.add(0);
          integerList.add(0);
          integerList.add(0);
          break;
        case 'c':
          integerList.add(1);
          integerList.add(0);
          integerList.add(1);
          integerList.add(0);
          break;
        case 'd':
          integerList.add(1);
          integerList.add(0);
          integerList.add(0);
          break;
        case 'e':
          integerList.add(0);
          break;
        case 'f':
          integerList.add(0);
          integerList.add(0);
          integerList.add(1);
          integerList.add(0);
          break;
        case 'g':
          integerList.add(1);
          integerList.add(1);
          integerList.add(0);
          break;
        case 'h':
          integerList.add(0);
          integerList.add(0);
          integerList.add(0);
          integerList.add(0);
          break;
        case 'i':
          integerList.add(0);
          integerList.add(0);
          break;
        case 'j':
          integerList.add(0);
          integerList.add(1);
          integerList.add(1);
          integerList.add(1);
          break;
        case 'k':
          integerList.add(1);
          integerList.add(0);
          integerList.add(1);
          break;
        case 'l':
          integerList.add(0);
          integerList.add(1);
          integerList.add(0);
          integerList.add(0);
          break;
        case 'm':
          integerList.add(1);
          integerList.add(1);
          break;
        case 'n':
          integerList.add(1);
          integerList.add(0);
          break;
        case 'o':
          integerList.add(1);
          integerList.add(1);
          integerList.add(1);
          break;
        case 'p':
          integerList.add(0);
          integerList.add(1);
          integerList.add(1);
          integerList.add(0);
          break;
        case 'q':
          integerList.add(1);
          integerList.add(1);
          integerList.add(0);
          integerList.add(1);
          break;
        case 'r':
          integerList.add(0);
          integerList.add(1);
          integerList.add(0);
          break;
        case 's':
          integerList.add(0);
          integerList.add(0);
          integerList.add(0);
          break;
        case 't':
          integerList.add(1);
          break;
        case 'u':
          integerList.add(0);
          integerList.add(0);
          integerList.add(1);
          break;
        case 'v':
          integerList.add(0);
          integerList.add(0);
          integerList.add(0);
          integerList.add(1);
          break;
        case 'w':
          integerList.add(0);
          integerList.add(1);
          integerList.add(1);
          break;
        case 'x':
          integerList.add(1);
          integerList.add(0);
          integerList.add(0);
          integerList.add(1);
          break;
        case 'y':
          integerList.add(1);
          integerList.add(0);
          integerList.add(1);
          integerList.add(1);
          break;
        case 'z':
          integerList.add(1);
          integerList.add(1);
          integerList.add(0);
          integerList.add(0);
          break;
      }
      integerList.add(2);
    }
  }

  List<Integer> getIntegerList() {
    return integerList;
  }

  /*
  This method check if word contains only letters.
   */
  static boolean checkWord(String message) {
    return message.matches("[a-zA-Z]+");
  }
}