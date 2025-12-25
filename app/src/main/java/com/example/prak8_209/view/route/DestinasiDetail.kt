package com.example.prak8_209.view.route

import com.example.prak8_209.R

object DestinasiDetail : DestinasiNavigasi{
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}