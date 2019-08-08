package com.gy.expandablelayout

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import iammert.com.expandablelib.ExpandableLayout
import iammert.com.expandablelib.Section
import kotlinx.android.synthetic.main.activity_main.*

class RVAdapter(val modelPs: MutableList<ModelP>) : androidx.recyclerview.widget.RecyclerView.Adapter<RVAdapter.RVViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RVViewHolder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.layout_item,p0,false)
        return RVViewHolder(view)
    }

    override fun getItemCount(): Int = modelPs.size

    override fun onBindViewHolder(p0: RVViewHolder, p1: Int) {
        p0.bindView(modelPs[p1])
    }


    class RVViewHolder(val view:View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view){

        fun bindView(modelP: ModelP){
            var expandView = view.findViewById<ExpandableLayout>(R.id.expand)
            var section = Section<ModelP,ModelC>()
            section.expanded = true

            section.parent = modelP
            section.children.add(modelP.child)
            section.children.add(modelP.child)

            expandView.setRenderer(object : ExpandableLayout.Renderer<ModelP, ModelC> {
                override fun renderParent(view: View, model: ModelP, isExpanded: Boolean, parentPosition: Int) {
//                (view.findViewById(R.id.tvParent) as TextView).text = model.name
//                view.findViewById(R.id.arrow).setBackgroundResource(if (isExpanded) R.drawable.arrow_up else R.drawable.arrow_down)
                }

                override fun renderChild(view: View, model: ModelC, parentPosition: Int, childPosition: Int) {
//                (view.findViewById(R.id.tvChild) as TextView).text = model.name
                }
            })

            expandView.addSection(section)
        }
        var parents = arrayOf("Fruits", "Nice Fruits", "Cool Fruits", "Perfect Fruits", "Frozen Fruits", "Warm Fruits")
        fun getSection(): Section<FruitCategory, Fruit> {
            val section = Section<FruitCategory, Fruit>()
            val fruitCategory = FruitCategory(parents[(Math.random() * parents.size).toInt()])
            val fruit1 = Fruit("Apple")
            val fruit2 = Fruit("Orange")
            val fruit3 = Fruit("Banana")
            val fruit4 = Fruit("Grape")
            val fruit5 = Fruit("Strawberry")
            val fruit6 = Fruit("Cherry")

            section.parent = fruitCategory
            section.children.add(fruit1)
            section.children.add(fruit2)
            section.children.add(fruit3)
            section.children.add(fruit4)
            section.children.add(fruit5)
            section.children.add(fruit6)
            section.expanded = true
            return section
        }
    }

}