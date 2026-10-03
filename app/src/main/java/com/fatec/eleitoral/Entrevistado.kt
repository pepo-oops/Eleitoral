package com.fatec.eleitoral

import java.time.LocalDateTime

data class Entrevistado(
    val name: String,
    val num: String,
    val candidato: String?,
    val problemas: ArrayList<String>?,
    val resp: String?,
    val data: LocalDateTime,
    val local: String?
)