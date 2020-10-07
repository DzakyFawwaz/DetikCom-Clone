package com.example.viewsapp.data

data class News(var title: String, var desc: String, var photo: String)

object NewsModel {
    val newslist = listOf<News>(
        News("Pasar ramai dikunjungi warga meskipun wabah covid 19 belum dinyatakan usai",
            "detikcom | 1 Jam yang lalu",
            "https://akcdn.detik.net.id/community/media/visual/2020/07/14/foto-hana-hanifah-datuk-haris-molana-detikcom-1_169.jpeg?w=700&q=90"),

        News("Kapal Nelayan menyalurkan bansos masyarakat Sulawesi",
            "detikcom | 1 Jam yang lalu",
            "https://cdn2.tstatic.net/jabar/foto/bank/images/update-data-kasus-virus-corona-di-indonesia-rabu-15-juli-2020.jpg"),

        News("Macet mulai terjadi di wilayah jalur pemudik semarang",
            "detikcom | 2 jam yang lalu",
            "https://cdn1.katadata.co.id/media/images/thumb/2020/02/17/2020_02_17-11_36_10_215269ab5a61c5583ee46619fb3e492c_960x640_thumb.jpg"),

        News("Jelang new normal jakarta macet lagi",
            "detikcom | 3 jam yang lalu",
            "https://images-tm.tempo.co/all/2020/07/16/747957/747957_720.jpg"),

        News("Dukung indonesia perangi covid-19, sampoerna donasi ventilator dan APD Full Set",
            "detikcom | 4 jam yang lalu",
            "https://cdn.statically.io/img/padangkita.com/wp-content/uploads/2020/06/harimau-solok-750x437.jpg"),

        News("Saat risma jelaskan soal penanganan corona pada kepala BNpB dan Menkes",
            "detikcom | 5 jam yang lalu",
            "https://cdn.statically.io/img/padangkita.com/wp-content/uploads/2020/02/ilustrasi-nias-Padangkita.com_-750x469.jpg"),

        News("Banjir keritik ke trump yang kerahkan militer usai demo george floyd",
            "detikcom | 6 jam yang lalu",
            "https://cdn.statically.io/img/padangkita.com/wp-content/uploads/2020/07/c5160064-ee6a-4f45-9fe0-08001e71-1.webp"),

        News("Mengapa aksi demo damai kasus george floyd bisa berubah jadi kerusuhan?",
            "detikcom | 8 jam yang lalu",
            "https://cdn.statically.io/img/padangkita.com/wp-content/uploads/2017/04/danau-singkarak.jpg"),

        News("2 opsi bagi calon jemaah haji yang tidak jadi berangkat tahun ini",
            "detikcom | 1 menit yang lalu",
            "https://cdn.statically.io/img/padangkita.com/f=auto/wp-content/uploads/2020/07/9e644c5c-1ec3-4ff9-aea2-2b0dae30cc5d.jpg")

    )
}