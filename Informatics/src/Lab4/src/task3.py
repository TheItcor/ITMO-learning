import msgspec
import time

def main():
    start_time = time.time() # замеряем время
    
    # десериализация .json
    with open("lessons.json", "rb") as f:
        json_data = msgspec.json.decode(f.read())

    # сериализация в .bin
    with open("output.bin", "wb") as f:
        f.write(msgspec.msgpack.encode(json_data))

    # десереализация в .yaml
    with open("output.bin", "rb") as f:
        bin_data = msgspec.msgpack.decode(f.read())

    with open("lеsons.yaml", "wb") as f:
        f.write(msgspec.yaml.encode(bin_data))
        
    end_time = time.time()   # конец замерки времени
    print(f"Python + библиотека: Json -> Bin -> Yaml. Прошло: {end_time - start_time:.4f} секунд")


if __name__ == "__main__":
    main()
