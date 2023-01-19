
fun main() {
    //Crear PlayList
    var playList: PlayList = PlayList("","")
    println("Ingrese:\n" +
            "1. Entrada de teclado\n" +
            "2. Lectura de Archivo CSV")
    var respuesta = readln().toString()
    when(respuesta){
        "1"-> playList = InputManager.entradaTeclado()
        "2"-> playList = CSVManager.leerCSV()
    }
    InputManager.crud(playList)


}

