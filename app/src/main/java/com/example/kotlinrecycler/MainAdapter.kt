package com.example.kotlinrecycler

import android.app.Dialog
import android.content.Context
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinrecycler.databinding.RowHolderBinding
class MainAdapter(list: ArrayList<Entity>,activity: MainActivity) : RecyclerView.Adapter<MainAdapter.RowHolder>() {
    private var listData: ArrayList<Entity> = ArrayList<Entity>()
    lateinit var binding: RowHolderBinding
    private lateinit var dialog:Dialog
    class RowHolder(var binding:RowHolderBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        binding = RowHolderBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        return RowHolder(binding)
    }
    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.binding.textViewInRowHolder.text= listData[position].name
        holder.itemView.setOnClickListener(View.OnClickListener {
            val text=dialog.findViewById(R.id.textInDialog) as TextView
            val button=dialog.findViewById(R.id.buttonOk) as Button
            text.text=listData[position].text
            button.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        })

    }
    override fun getItemCount(): Int {
        return listData.size
    }
    init {
        listData = list
        dialog= Dialog(activity)
        val width:Int=WindowManager.LayoutParams.WRAP_CONTENT
        val height:Int=WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window?.setLayout(width,height)
        dialog.setContentView(R.layout.dialog_view)
    }

}