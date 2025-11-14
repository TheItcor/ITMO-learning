#include <iostream>
#include <string>
#include <fstream>

/* TODO
* [x] 1. Функция1, принимает Имя.Файла, возращает весь текст в одну строку без n/ 
* [ ] 2. Функция2, принимает однострочный текст и парсит его, делая из него текст бинарника
* [ ] 3. Функция3, принимает однострочный текст и записывает его в бинарник (Нужна ли функция?)
*/

std::string makeString(std::string fileName) {
    /*Функция, достаёт из файла текст и возращает всё в одной строке*/
    std::ifstream in;
    in.open(fileName);
    
    std::string line, allTxt; // allTxt - может не заработать, проверить на тестах
    while (std::getline(in, line)) {
        allTxt += line;
    }


    in.close();
    return allTxt;
}


std::string makeBin(std::string lineTxt) {
    /* Функция, принимает однострочный текст, убирает пробелы, парсит и создаёт текст для бинарника */

    std::string noSpacesTxt, binTxt;
    for (char c: lineTxt) {
        if (c != ' ') noSpacesTxt += c;
    }

    return noSpacesTxt;
}



int main () {
    std::string someTxt;
    someTxt = makeString("lessons.json");


    
    return 0;
}
