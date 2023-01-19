import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class BaseDatosManager {
 companion object{
     fun guardarPlaylist(playList: PlayList){
         val file = File("src\\main\\resources\\${playList.nombrePlayList}_${playList.artistaPrincipal}.csv")
         val text = playList.crearCSVCanciones()

         file.writeText(text, Charsets.UTF_8)
     }
     fun leerArchivo(nombreArchivo: String): PlayList{
         val nombres = nombreArchivo.split("_")
         var nuevaPlaylist: PlayList = PlayList(nombres[0],nombres[1])
         val file = File("src\\main\\resources\\${nombreArchivo}.csv")
         val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
         reader.lines().forEach{
             val cancion: List<String> = it.split(";")
             val duracion = cancion[1].replace(",",".")
             val nuevaCancion = Cancion(cancion[0],duracion.toDouble(),null,cancion[2],cancion[3])
             nuevaPlaylist.crearCancion(nuevaCancion)
         }
         return nuevaPlaylist
     }
 }



}