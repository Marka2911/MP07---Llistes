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
        val nomGuerrer = Random.nextInt(0, Noms.size)
        val etapaGuerrer = Random.nextInt(0, Etapa.size)
        return GuerrersZ(
            id = num,
            nom = "${Noms[nomGuerrer]} ${Etapa[etapaGuerrer]}",
            foto = "https://loremflickr.com/320/240/dbz?lock=$num",
            vida = Random.nextInt(0, 100),
            unitatsDePoder = Random.nextInt(0, 100),
            velocitat = Random.nextInt(0, 100),
            defensa = Random.nextInt(0, 100)
        )
    }
    public fun obtenirDadesGuerrersZ() =
        (1..100)
            .toList()
            .map{ CrearGuerrerZ(it)}
}