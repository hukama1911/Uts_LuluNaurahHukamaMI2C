package com.example.uts_lulu.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_lulu.DetailMakanan
import com.example.uts_lulu.R
import com.example.uts_lulu.RecycleMakan
import com.example.uts_lulu.model.ModelMakanan

class MakananAdapter(val itemList:ArrayList<ModelMakanan>,
                     private val getActivity: RecycleMakan//untuk bisa call intent
    )
    : RecyclerView.Adapter<MakananAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemNama: TextView
        var itemharga : TextView


        init {
            itemImage = itemView.findViewById(R.id.gambar) as ImageView
            itemNama = itemView.findViewById(R.id.nama) as TextView
            itemharga = itemView.findViewById(R.id.harga) as TextView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_makanan,
            parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemImage.setImageResource(itemList[position].image)
        holder.itemNama.setText(itemList[position].judul)
        holder.itemharga.setText(itemList[position].harga)



        // tamvbah intent untuk passing data ke detail
        holder.itemView.setOnClickListener (){
            // deklarasi intent
            val intent = Intent(getActivity, DetailMakanan::class.java)
            //putextra
            intent.putExtra("image", itemList[position].image)
            intent.putExtra("judul", itemList[position].judul)
            intent.putExtra("harga", itemList[position].harga)


            // intent.putextra("judul", itemlist[posituon]. judul)
                //start pindah ke detail
            getActivity.startActivity(intent)
        }
    }
}