#include <iostream>
#include <string>
#include <fstream>


/* TODO
* [x] 1. Функция1, принимает Имя.Файла, возращает весь текст в одну строку без n/ 
* [x] 2. Функция2, принимает текст и убирает пробелы.
* [x] 3. функция3, принимает текст и "парсит" его.
* [x] 4. Функция4, принимает однострочный текст и записывает его в бинарник (Нужна ли функция?)
*/

std::string makeString(const std::string& fileName) {
    /*Функция, достаёт из файла текст и возращает всё в одной строке*/
    std::ifstream in;
    in.open(fileName);
    

    std::string line, allTxt;
    allTxt.reserve(50); // резервируем память для строки условные 100 байт
    while (std::getline(in, line)) {
        allTxt += line;
    }


    in.close();
    return allTxt;
}


std::string removeSpace(const std::string& lineTxt) {
    /* Функция, принимает однострочный текст, убирает пробелы*/
    std::string noSpacesTxt;
    noSpacesTxt.reserve(lineTxt.size() + 100); // Заранее прописываем память для строки

    /* Убираем пробелы */
    std::string binTxt;
    for (char c: lineTxt) {
        if (c != ' ') noSpacesTxt += c;
    }

    return noSpacesTxt;
}


std::string parseJson(const std::string& lineTxt) {
    std::string result;
    result.reserve(lineTxt.size() + 128);
    
    bool inQuotes = false;
    
    for (size_t i = 0; i < lineTxt.size(); i++) {
        char c = lineTxt[i];
        
        if (c == '"') {
            if (!inQuotes) {
                result += "[\""; // начало строки
            } else {
                result += "\"]"; // конец строки
            }
            inQuotes = !inQuotes;
        } else if (!inQuotes) {
            // вне кавычек
            if (c == '{') {
                result += '[';
            } else if (c == '}') {
                result += ']';
            } else {
                result += c;
            }
        } else {
            // внутри кавычек
            result += c;
        }
    }
    
    return result;
}


int main () {
    std::string someTxt, parseTxt;
    someTxt = removeSpace(makeString("lessons.json"));
    parseTxt = parseJson(someTxt);

    std::cout << "input: " << someTxt << std::endl << std::endl;
    std::cout << "output: " << parseTxt << std::endl;
    
    std::ofstream file("output.bin", std::ios::binary); // открываем бинарный файл, в бинарнорм режиме для записи
    file.write(parseTxt.c_str(), parseTxt.size()); // запись в бинарный файл

    file.close();
    
    return 0;
}
