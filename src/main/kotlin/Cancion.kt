import java.util.*
import kotlin.collections.ArrayList

class Cancion(
    //definicion de atributos para el constructor primario
    var nombreCancion: String,
    protected val duracionCancion: Double,
    protected val esBanda: Boolean?,
    protected val artista: String,
    protected val albumOrigen: String
)
{
    init {
        this.nombreCancion
        this.duracionCancion
        this.esBanda
        this.artista
        this.albumOrigen
    }

    override fun toString(): String {
        return "$nombreCancion;$duracionCancion;$artista;$albumOrigen"
    }

}