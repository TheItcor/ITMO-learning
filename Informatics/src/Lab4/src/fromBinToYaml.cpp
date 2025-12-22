#include <iostream>
#include <string>
#include <fstream>
#include <ctime>



std::string readBin(const std::string& fileName) {
    std::ifstream file(fileName, std::ios::binary);
    if (!file.is_open()) {
        return "ОШИБКА ЧТЕНИЯ";
    }
        
    std::string result;
    std::getline(file, result);

    return result;
}


std::string binParseToYaml(const std::string& input) {
    std::string yaml;
    int indent = 0;
    bool inDay = false;
    bool inLesson = false;
    
    for (size_t i = 0; i < input.size(); i++) {
        char c = input[i];
        
        // Пропускаем внешние скобки
        if ((i == 0 && c == '[') || (i == input.size() - 1 && c == ']')) {
            continue;
        }
        
        if (c == '[' && i + 5 < input.size() && input.substr(i, 5) == "[[" && 
            (input[i + 5] == 'M' || input[i + 5] == 'S' || input[i + 5] == 'T' || 
             input[i + 5] == 'W' || input[i + 5] == 'F')) {
            i++; // Пропускаем второй '['
            yaml += std::string(indent, ' ') + "- ";
            inDay = true;
            indent += 2;
        } else if (c == '[' && i + 1 < input.size() && input[i + 1] == '"') {
            // Ключ или значение в кавычках
            size_t end = input.find("\"]", i);
            if (end != std::string::npos) {
                std::string content = input.substr(i + 2, end - i - 2);
                i = end + 1; // Переходим к закрывающей скобке
                
                if (input[i + 1] == ':') {
                    yaml += std::string(indent, ' ') + content + ":";
                    if (content == "lesson") {
                        inLesson = true;
                        yaml += '\n' + std::string(indent, ' ') + "  - ";
                        indent += 2;
                    } else {
                        yaml += " ";
                    }
                } else if (input[i + 1] == ',' || input[i + 1] == ']') {
                    // Это значение
                    yaml += "\"" + content + "\"";
                    if (content == "lesson") {
                        yaml += '\n';
                    }
                }
            }
        } else if (c == ']' && inDay) {
            inDay = false;
            indent -= 2;
            if (i + 1 < input.size() && input[i + 1] == ',') {
                yaml += '\n';
            }
        } else if (c == ']' && inLesson) {
            inLesson = false;
            indent -= 2;
            yaml += '\n';
        } else if (c == ',') {
            // Разделитель элементов
            if (inLesson) {
                yaml += '\n' + std::string(indent, ' ') + "  - ";
            }
        }
    }
    
    return yaml;
}


int main() {
    // замеряем время   
    std::clock_t start = std::clock(); 
    
    std::string fileName = "output.bin";
    std::string lessonsYaml = binParseToYaml(readBin(fileName));
    

    // записываем отформатированные данные в .yaml
    std::ofstream file("lеssons.yaml");
    if (file) {
        file << lessonsYaml;
    }
    
    
    
    // окончание замера времени
    std::clock_t end = std::clock();
    double duration = double(end - start) / CLOCKS_PER_SEC;
    std::cout << "С++: Bin -> Yaml. Прошло: " << duration << " секунд" << std::endl;

    return 0;
}

