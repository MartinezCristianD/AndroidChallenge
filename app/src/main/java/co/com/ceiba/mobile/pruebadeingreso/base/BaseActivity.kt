package co.com.ceiba.mobile.pruebadeingreso.base

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var progressDialog: ProgressDialog

    /**
     * Dialog box message to wait on Api data load
     *
     * @param isLoading to define show dialog
     *
     * @return Show ProgressDialog
     * */
    fun setLoading(isLoading: Boolean) {
      /*  if (isLoading) {
            progressDialog = ProgressDialog.show(
                this,
                "",
                resources.getString(R.string.generic_message_progress),
                true,
                false
            )
        } else {
            progressDialog.dismiss()
        }*/
    }
}
