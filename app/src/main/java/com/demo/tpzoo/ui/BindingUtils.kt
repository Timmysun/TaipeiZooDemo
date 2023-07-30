package com.demo.tpzoo.ui

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.demo.tpzoo.R

@BindingAdapter("loadImageIcon", "crop")
fun loadImageIcon(layout: RelativeLayout, url: String, crop: Boolean) {
    val progress = layout.findViewById<ProgressBar>(R.id.pb_progressbar)
    progress.visibility = View.VISIBLE
    Glide.with(layout.context)
        .load(url)
        .addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progress.visibility = View.GONE
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progress.visibility = View.GONE
                return false
            }
        })
        .apply { if (crop) circleCrop() }
        .into(layout.findViewById(R.id.iv_avatar))

}