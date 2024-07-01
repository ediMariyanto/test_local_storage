package com.edi_mariyanto.test_local_storage.model

class MahasiswaModel(string: String, string1: String, string2: String) {
    private var nama: String? = null
    private var kelas: String? = null
    private var mtKul: String? = null


    // creating getter and setter methods
    fun getCourseName(): String? {
        return nama
    }

    fun setCourseName(courseName: String?) {
        this.nama = courseName
    }

    fun getCourseDuration(): String? {
        return kelas
    }

    fun setCourseDuration(courseDuration: String?) {
        this.kelas = courseDuration
    }

    fun getCourseTracks(): String? {
        return mtKul
    }

    fun setCourseTracks(courseTracks: String?) {
        this.mtKul = courseTracks
    }

    override fun toString(): String {
        return "MahasiswaModel(nama=$nama, kelas=$kelas, mtKul=$mtKul)"
    }


}