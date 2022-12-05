package it.macgood.mathanapp.domain.usecase

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import it.macgood.mathanapp.common.Constants
import java.lang.Exception


class GetImage {

    operator fun invoke(id: String, image: ImageView, text: TextView){
        Picasso.get()
            .load(Constants.CLOUD_STORAGE_URL + id + ".png")
            .into(image, object: Callback{
                override fun onSuccess() {
                    text.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    Log.d("TAG", "onError: ")
                }
            })
    }
}