class CSVManager {
    companion object{
        fun leerCSV():PlayList{
            println("Ingrese el nombre del CSV")
            var nombreCSV = readln().toString()
            val playlist = BaseDatosManager.leerArchivo(nombreCSV)
            return playlist
        }
    }
}