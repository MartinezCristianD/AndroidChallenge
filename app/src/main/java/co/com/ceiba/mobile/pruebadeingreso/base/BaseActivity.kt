package co.com.ceiba.mobile.pruebadeingreso.base

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import co.com.ceiba.mobile.pruebadeingreso.R

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var progressDialog: ProgressDialog

    fun setLoading(isLoading: Boolean) {
        if (isLoading) {
            progressDialog = ProgressDialog.show(
                this,
                "",
                resources.getString(R.string.generic_message_progress),
                true,
                false
            )
        } else {
            progressDialog.dismiss()
        }
    }

}
