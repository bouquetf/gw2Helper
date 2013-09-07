#! /usr/bin/env groovy
// Generates a json file from CSV file.

if (args.length != 1) {
    println """Usage :
    generate_maps [tp_list.csv]
"""
    System.exit(1)
}

File csv = new File(args[0])
Json json = new Json();
csv.eachLine {
    def elements = it.split(";")

    if ((elements.length == 4) && (elements[3]=="1")) {
        json.addEvent(elements[0])
    }
}
json.finish()

class Json {
    int nb = 0
    String output

    def Json() {
        output = '['
    }

    def finish() {
        output += ']'
    }

    def addEvent(String id) {
        if (nb > 0) {
            output += ',\n'
        }
        output += "{\"id\":\"$id\"}"
        nb+=1
    }

}
