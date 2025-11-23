#include <iostream>
#include <string>
#include <fstream>

/* TODO
* [x] 1. Функция1, принимает Имя.Файла, возращает весь текст в одну строку без n/ 
* [x] 2. Функция2, принимает текст и убирает пробелы.
* [ ] 3. функция3, принимает текст и "парсит" его.
* [ ] 4. Функция4, принимает однострочный текст и записывает его в бинарник (Нужна ли функция?)
*/

std::string makeString(const std::string& fileName) {
    /*Функция, достаёт из файла текст и возращает всё в одной строке*/
    std::ifstream in;
    in.open(fileName);
    

    std::string line, allTxt;
    while (std::getline(in, line)) {
        allTxt += line;
    }


    in.close();
    return allTxt;
}


std::string removeSpace(const std::string& lineTxt) {
    /* Функция, принимает однострочный текст, убирает пробелы*/

    /* Убираем пробелы */
    std::string noSpacesTxt, binTxt;
    for (char c: lineTxt) {
        if (c != ' ') noSpacesTxt += c;
    }

    return noSpacesTxt;
}


std::string parseJson(const std::string& lineTxt) {
    /* Парсим json в [] */
    std::string result;
    result.reserve(lineTxt.size() + 100); // Заранее прописываем память для строки
    
    bool after_colon = false;

    for (char c : lineTxt) {
        if (c == ':') {
            // Открываем значение
            result += ":["; 
            after_colon = true;
            continue;
        }

        if (after_colon && (c == ',' || c == '}')) {
            // Закрывает значение
            result += ']';
            after_colon = false;
        }

        if (c == '{') result += '[';
        else if (c == '}' && !after_colon) result += ']';
        else if (c != ',' || !after_colon) result += c; 
    }

    return result;
}



int main () {
    std::string someTxt, parseTxt;
    someTxt = removeSpace(makeString("test.json"));
    parseTxt = parseJson(someTxt);

    std::cout << parseTxt;
    
    
    return 0;
}
