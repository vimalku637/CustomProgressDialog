package com.vk.customprogressdialog

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.mmstq.progressbargifdialog.ProgressBarGIFDialog

class MainActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null
    private var progressBarGIFDialog: ProgressBarGIFDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProgressDialog=findViewById<MaterialButton>(R.id.btnProgressDialog)
        btnProgressDialog.setOnClickListener {
            progressDialog = ProgressDialog(this)
            progressDialog?.show()
            progressDialog?.setContentView(R.layout.progress_dailog)
            progressDialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
        var btnProgressDialog2=findViewById<MaterialButton>(R.id.btnProgressDialog2)
        btnProgressDialog2.setOnClickListener {
            progressBarGIFDialog = ProgressBarGIFDialog.Builder(this)

            progressBarGIFDialog?.setCancelable(false)
                ?.setTitleColor(R.color.purple_200) // Set Title Color (int only)
                ?.setLoadingGif(com.mmstq.progressbargifdialog.R.drawable.loading) // Set Loading Gif
                ?.setDoneGif(com.mmstq.progressbargifdialog.R.drawable.done) // Set Done Gif
                ?.setDoneTitle("Nice Blyat") // Set Done Title
                ?.setLoadingTitle("Loading...") // Set Loading Title
                ?.build()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (progressDialog!!.isShowing) {
            progressDialog?.dismiss()
        }else{
            toast("Dismiss")
            progressBarGIFDialog?.clear()
        }
    }
}