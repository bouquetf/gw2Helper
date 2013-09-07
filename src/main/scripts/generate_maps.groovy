#! /usr/bin/env groovy

if (args.length != 1) {
    println """Usage :
generate_maps [tp_list.csv]
"""
    System.exit(1)
}



File csv = new File(args[0])
csv.eachLine {
    def elements = it.split(";")
    new File("destination").mkdir();
    if (elements.length == 3) {
        generateMap(elements[0], elements[2])
    }
}

def generateMap(String id, String originName) {
    new File("destination/${id}.jpg") << new File("${originName}.jpg").bytes;

}