class InputManager {
    companion object{
        fun entradaTeclado():PlayList{
            println("Ingrese nombre de la playlist>")
            val nombrePlayList = readln().toString()
            println("Ingrese nombre del artista>")
            val artistaPrincipal = readln().toString()
            val playList: PlayList = PlayList(nombrePlayList, artistaPrincipal);
            println("Desea ingresar canciones a la playlist>")
            var respuesta = readln().toString()
            while (respuesta == "yes"){
                insertarCancion(playList)
                println("Desea ingresar canciones a la playlist>")
                respuesta = readln().toString()
            }
            return playList
        }


        fun crud(playList: PlayList):Unit{
            var respuesta = "yes"
                while (respuesta == "yes"){
                    println("Ingrese el numero de acuerdo a que operaciones desea realizar\n" +
                            "1.insertar nueva cancion\n" +
                            "2.imprimir mis canciones\n" +
                            "3.actualizar nombre de la cancion\n" +
                            "4.borrar cancion\n")
                    when(readln().toString()){
                        "1"-> insertarCancion(playList)
                        "2"-> println(playList.imprimirCanciones())
                        "3"-> actualizarNombreCancion(playList)
                        "4"-> playList.eliminarCancion(encontrarIndiceCancion(playList))

                    }
                    BaseDatosManager.guardarPlaylist(playList)
                    println("Desea otra operacion CRUD?")
                    respuesta = readln().toString()
                }

        }
        fun insertarCancion(playList: PlayList){
            println("Ingrese nombre de la cancion>")
            val nombreCancion = readln().toString()
            println("Ingrese duracion de la cancion>")
            val duracion = readln().toDouble()
            println("Ingrese el artista de la cancion>")
            val artista = readln().toString()
            println("Ingrese el album>")
            val album = readln().toString()
            playList.crearCancion(Cancion(nombreCancion,duracion,null,artista,album))
        }
        fun actualizarNombreCancion(playList: PlayList){
            val indiceCancion = encontrarIndiceCancion(playList)
            println("Ingrese el nuevo nombre de la cancion>")
            val nuevoNombre = readln().toString()
            playList.actualizarNombreCancion(indiceCancion, nuevoNombre)
        }
        fun encontrarIndiceCancion(playList: PlayList):Int{
            println("Ingrese nombre de la cancion>")
            val nombreCancion = readln().toString()
            val cancionesEncontradas = playList.playList.filter { it.nombreCancion == nombreCancion }
            return playList.playList.indexOf(cancionesEncontradas[0]!!)
        }
    }
}