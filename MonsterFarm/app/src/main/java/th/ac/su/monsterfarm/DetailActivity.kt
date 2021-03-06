package th.ac.su.monsterfarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")
        val caption = intent.getStringExtra("caption")
        val imageFile = intent.getStringExtra("imageFile")

        tvTitle.setText(title)
        tvCaption.setText(caption)

        val res = resources
        val drawableId:Int =
            res.getIdentifier(imageFile,"drawable",packageName)
        imgView.setImageResource(drawableId)
    }
}