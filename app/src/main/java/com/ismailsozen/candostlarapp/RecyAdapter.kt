package com.ismailsozen.candostlarapp

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.tek_satir_layout.view.*

class RecyAdapter(listemiz:ArrayList<Dost>):RecyclerView.Adapter<RecyAdapter.RecyViewHolder>() {

    var dostlar=listemiz

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyViewHolder {



        var inflater=LayoutInflater.from(parent?.context)
        var tekuye=inflater.inflate(R.layout.tek_satir_layout,parent,false)
        return RecyViewHolder(tekuye)



    }

    override fun getItemCount(): Int {

        return dostlar.size

    }

    override fun onBindViewHolder(holder: RecyViewHolder?, position: Int) {

        var oanliste=dostlar.get(position)
        holder?.setData(oanliste,position)


    }


    class RecyViewHolder(tekuye: View):RecyclerView.ViewHolder(tekuye){

        var tekBilgi= tekuye as CardView
        var dostAd=tekBilgi.txtDostAd
        var dostResim=tekBilgi.imgDostResim



        fun setData(oanliste: Dost, position: Int) {

            dostAd.text=oanliste.isim
            dostResim.setImageResource(oanliste.resim)

        }


    }

}