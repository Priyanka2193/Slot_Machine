package com.priyanka.slotmachine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_slotmachine.*

class SlotMachineActivity:AppCompatActivity()
{
    data class slotItem(val drawable: Int,val Name: String )

    private val fruits: List<slotItem> = listOf(
    slotItem(R.drawable.lemon,  "lemon"),
    slotItem(R.drawable.grapes, "grapes"),
    slotItem(R.drawable.cherries, "cherries"),
    slotItem(R.drawable.dollarsign,"dollarsign"),
    slotItem(R.drawable.number7, "number7")
    )

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slotmachine)


        spin_button.setOnClickListener {
            shuffleitems()
        }
    }


    private fun shuffleitems() {
        val firstItem : slotItem = fruits.random()
        val secondItem :slotItem = fruits.random()
        val thirdItem :slotItem = fruits.random()

        val namesarray= arrayOf<String>(firstItem.Name, secondItem.Name, thirdItem.Name)
       val rounds= getpoints(namesarray)

        cherries_image_view.setImageResource(firstItem.drawable)
        body_image_view.setImageResource(secondItem.drawable)
        footer_image_view.setImageResource(thirdItem.drawable)

        text_view.text=rounds.toString()




    }
    private fun getpoints(args: Array<String>) : Int  {

        val firstcount=args.filter{item-> item == args[0]}.count()
        val Secondcount=args.filter{item-> item == args[1]}.count()
        val thirdcount=args.filter{item-> item == args[2]}.count()

        val pointsarray= arrayOf(firstcount,Secondcount,thirdcount)

        var points: Int =0

        pointsarray.forEach{point->
            if(point==2) points=2
            if(point==3) points=5

        }

        return points
    }
}