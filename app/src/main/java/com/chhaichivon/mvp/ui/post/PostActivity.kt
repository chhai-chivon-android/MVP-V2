package com.chhaichivon.mvp.ui.post;

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import com.chhaichivon.mvp.R


class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this)

        val actionBar = supportActionBar
        val tv = TextView(applicationContext)
        val typeface = Typeface.createFromAsset(assets, "font/Hanuman-Bold.ttf")
        val lp = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        tv.layoutParams = lp
        tv.text = "អត្ថបទ"
        tv.textSize = 25f
        tv.setTextColor(Color.WHITE)
        tv.setTypeface(typeface, Typeface.ITALIC)
        if (actionBar != null) {
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            actionBar.customView = tv
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.post_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == R.id.action_one) {
            Toast.makeText(this, "Item One Clicked", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.action_two) {
            Toast.makeText(this, "Item Two Clicked", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.action_three) {
            Toast.makeText(this, "Item Three Clicked", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}