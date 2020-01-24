package com.ismailsozen.candostlarapp

import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.tek_satir_layout.view.*

class DostlarRecyclerViewAdapter(tumDostlar:ArrayList<Dost>):RecyclerView.Adapter<DostlarRecyclerViewAdapter.DostViewHolder>() {

    var dostlar=tumDostlar

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DostViewHolder {

        var inflater=LayoutInflater.from(parent?.context)
        var tek_uye=inflater.inflate(R.layout.tek_satir_layout,parent,false)
        return DostViewHolder(tek_uye)

    }

    override fun getItemCount(): Int {

       return dostlar.size
    }

    override fun onBindViewHolder(holder: DostViewHolder?, position: Int) {

        var oanOlusturulanDost=dostlar.get(position)
        holder?.setData(oanOlusturulanDost,position)

    }


    inner class DostViewHolder(tek_uye: View):RecyclerView.ViewHolder(tek_uye) {

        var tekDostBilgisi=tek_uye as CardView

        var dostAd=tekDostBilgisi.txtDostAd
        var dostResim=tekDostBilgisi.imgDostResim


        fun setData(oanOlusturulanDost: Dost, position: Int) {

            dostAd.text=oanOlusturulanDost.isim
            dostResim.setImageResource(oanOlusturulanDost.resim)

            tekDostBilgisi.setOnClickListener { v->


                var intent=Intent(v.context,DetayActivity::class.java)

                intent.putExtra("ad",oanOlusturulanDost.isim)
                intent.putExtra("resim",oanOlusturulanDost.resim)
                v.context.startActivity(intent)


            }

        }



    }

    fun setFilter(aranilanlar:ArrayList<Dost>)
    {
        //sıfırladık listeyi
        dostlar=ArrayList<Dost>()

        //gelen listeyi atadı
        dostlar.addAll(aranilanlar)
        notifyDataSetChanged()

    }




}