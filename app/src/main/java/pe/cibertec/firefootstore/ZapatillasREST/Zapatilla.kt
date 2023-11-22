package pe.cibertec.firefootstore.ZapatillasREST

data class Zapatilla(
    val id: Int,
    val nombre: String,
    val marca: String,
    val imagen: String,
    val descripcion: String,
    val precio: String
)