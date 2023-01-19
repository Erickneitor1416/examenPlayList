import java.util.Date

class PlayList (
    //definicion de atributos para el constructor primario
    val nombrePlayList: String,
    val artistaPrincipal: String,
    val fechaUltimaActualizacion: Date,
    var numeroDeCanciones: Int,
    val playList: ArrayList<Cancion>
    )
{
   init {
       // inicializa los atributos de la clase
       this.nombrePlayList
       this.artistaPrincipal
       this.fechaUltimaActualizacion
       this.numeroDeCanciones = this.playList.size
       this.playList
   }
    constructor(
        nombrePlayList: String,
        artistaPrincipal: String
    ) : this(
        nombrePlayList,artistaPrincipal,Date(),0,ArrayList<Cancion>()
    )

    //CRUD PlayList
    fun crearCancion(nuevaCancion: Cancion): Boolean{
        this.playList.add(nuevaCancion)
        actualizarNumeroDeCanciones()
        return this.playList.any{ it == nuevaCancion }
    }
    fun imprimirCanciones():String{
        var salida: String = "Tus canciones son:\n"
        this.playList.forEachIndexed{index, cancion ->
            salida += "${index+1}.${cancion.nombreCancion}\n"
        }
        return salida
    }
    fun actualizarNombreCancion(indexCancion: Int,nuevoNombre: String):Boolean{
        return if (this.playList.size > indexCancion){
            this.playList[indexCancion].nombreCancion = nuevoNombre
            true
        }else{
            false
        }

    }
    fun eliminarCancion(indexCancion: Int){
        this.playList.removeAt(indexCancion)
    }
    fun crearCSVCanciones():String{
        var salida: String = ""
        this.playList.forEachIndexed{index, cancion ->
            salida += "${cancion}\n"
        }
        return salida
    }


    fun actualizarNumeroDeCanciones(){
        this.numeroDeCanciones = this.playList.size
    }


    override fun toString(): String {
        return "PlayList: '$nombrePlayList'\n" +
                "Artista principal: $artistaPrincipal\n" +
                "Ultima modificación: $fechaUltimaActualizacion\n" +
                "Numero de canciones: $numeroDeCanciones\n" +
                "${imprimirCanciones()}"
    }


}