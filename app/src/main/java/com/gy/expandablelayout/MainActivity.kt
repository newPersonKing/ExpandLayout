package com.gy.expandablelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import iammert.com.expandablelib.Section
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import iammert.com.expandablelib.ExpandableLayout
import android.text.Editable
import android.text.TextWatcher
import iammert.com.expandablelib.ExpandCollapseListener





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sectionLinearLayout.setRenderer(object : ExpandableLayout.Renderer<FruitCategory, Fruit> {
            override fun renderParent(view: View, model: FruitCategory, isExpanded: Boolean, parentPosition: Int) {
//                (view.findViewById(R.id.tvParent) as TextView).text = model.name
//                view.findViewById(R.id.arrow).setBackgroundResource(if (isExpanded) R.drawable.arrow_up else R.drawable.arrow_down)
            }

            override fun renderChild(view: View, model: Fruit, parentPosition: Int, childPosition: Int) {
//                (view.findViewById(R.id.tvChild) as TextView).text = model.name
            }
        })


        sectionLinearLayout.addSection(getSection());
        sectionLinearLayout.addSection(getSection());
        sectionLinearLayout.addSection(getSection());
        sectionLinearLayout.addSection(getSection());
        sectionLinearLayout.addSection(getSection());
        sectionLinearLayout.addSection(getSection());
        sectionLinearLayout.addSection(getSection());
        sectionLinearLayout.addSection(getSection());
        sectionLinearLayout.addSection(getSection());
        sectionLinearLayout.addSection(getSection());
        sectionLinearLayout.addSection(getSection());

//        sectionLinearLayout.setExpandListener({ parentIndex, parent, view ->
//
//        } as ExpandCollapseListener.ExpandListener<FruitCategory>)
//
//        sectionLinearLayout.setCollapseListener({ parentIndex, parent, view ->
//
//        } as ExpandCollapseListener.CollapseListener<FruitCategory>)


//        editText.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                sectionLinearLayout.filterChildren { obj -> (obj as Fruit).name.toLowerCase().contains(s.toString().toLowerCase()) }
//            }
//
//            override fun afterTextChanged(s: Editable) {
//
//            }
//        })

        rv_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        rv_list.adapter =RVAdapter(getData())
    }

    fun getData(): kotlin.collections.MutableList<ModelP> {

        var list = mutableListOf<ModelP>()

        for(i in 1..100){
            var modelc = ModelC("name","pass")
            var modelP = ModelP("nameP",modelc)
            list.add(modelP)
        }
        return list
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
