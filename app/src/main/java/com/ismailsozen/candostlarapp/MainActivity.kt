package com.ismailsozen.candostlarapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), android.widget.SearchView.OnQueryTextListener {

    var tumDostlar = ArrayList<Dost>()
    lateinit var myAdapter: DostlarRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        veriKaynaginiDoldur()

        myAdapter = DostlarRecyclerViewAdapter(tumDostlar)
        recyViewDostlar.adapter = myAdapter

        var mylayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyViewDostlar.layoutManager = mylayoutManager


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.filtre_menu, menu)

        var aramaItem = menu?.findItem(R.id.app_bar_search)

        var searchView = aramaItem?.actionView as android.widget.SearchView

        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        return false

    }

    override fun onQueryTextChange(newText: String?): Boolean {

        var girilenveri = newText?.toLowerCase()
        var arananlar = ArrayList<Dost>()

        for (dost in tumDostlar) {
            var adi = dost.isim.toLowerCase()

            if (adi.contains(girilenveri.toString())) {
                arananlar.add(dost)

            }
        }

        myAdapter.setFilter(arananlar)

        return true
    }


    private fun veriKaynaginiDoldur() {

        var resimler = arrayOf(
            R.drawable.kedi1,
            R.drawable.kedi2,
            R.drawable.kedi3,
            R.drawable.kopek1,
            R.drawable.kopek2,
            R.drawable.papagan1,
            R.drawable.papagan2,
            R.drawable.papagan3,
            R.drawable.sincap,
            R.drawable.ayi

        )


        var isimler = arrayOf(
            "Kedi 1",
            "Kedi 2",
            "Kedi 3",
            "Köpek 1",
            "Köpek 2",
            "Papağan 1",
            "Papağan 2",
            "Papağan 3",
            "Sincap",
            "Ayı"
        )

        for (i in 0..resimler.size - 1) {
            var eklenecekDost = Dost(isimler[i], resimler[i])
            tumDostlar.add(eklenecekDost)
        }


    }
}





