package com.example.characters.dades

import com.example.characters.Model.GuerrersZ
import kotlin.random.Random

object repositoryFake{
    private val Noms = listOf(
        "Goku",
        "Vegeta",
        "Gohan",
        "Goten",
        "Trunks",
        "Krilin",
        "Yamcha",
        "Cor petit",
        "Tenshinhan",
        "Chaozu",
        "Yajirobe",
    )

    private  val Etapa = listOf(
        "Z - Inici",
        "Z - Mitj",
        "Z - Final",
        "Original",
        "Super - Inici",
        "Super - Mitj",
        "Super - Final",
        "Saga de Moro",
        "Saga de Granola",
        "Saga Super Hero"
    )
    private fun CrearGuerrerZ( num : Int) : GuerrersZ{
        val nomBD = Random.nextInt(0, Noms.size)
        val etapaBD = Random.nextInt(0, Etapa.size)
        return GuerrersZ(
            id = num,
            nom = "${Noms[nomBD]} ${Etapa[etapaBD]}",
            foto = "https://loremflickr.com/320/240/dbz?lock=$num",
            ki = Random.nextInt(0, 100),
            unitatsDePoder = Random.nextInt(0, 100),
            energia = Random.nextInt(0, 100),
            transformacions = Random.nextInt(0, 4),
            esEvil = Random.nextBoolean()
        )
    }
    public fun obtenirDadesGuerrersZ() =
        (1..100)
            .toList()
            .map{ CrearGuerrerZ(it)}
}