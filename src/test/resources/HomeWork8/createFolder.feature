Feature: create new folder

  Background:
    Given I am authorized

    Scenario:
      Given Я открываю окно создания папки
      When Я ввожу название папки
      And Я нажимаю кнопку добавить папку
      Then Я вижу созданную папку в дереве папок
