package com.example.a22ceb012_phankhachuy

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a22ceb012_phankhachuy.databinding.MainActivityBinding
import com.example.a22ceb012_phankhachuy.ui.theme._22CEB012_PhanKhacHuyTheme
class MainActivity : ComponentActivity() {

    private  lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = MainActivityBinding.inflate(layoutInflater)
        setContentView(view.root)
        registerForContextMenu(view.txtfucntion)
    }
    //Phân hiển thị menu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ){
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(1,1,1,"Tìm số tự nhiên")
        menu?.add(1,2,2,"Tính căn bậc")
        menu?.add(1,3,3,"Quản lý học phần")
        menu?.setHeaderTitle("Chọn chức năng của bạn")
    }
//Phần xử lý click menu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> {GotoFunction1() }
            2 -> {GotoFunction2() }
            3 -> {GotoFunction3() }
        }
        return super.onContextItemSelected(item)
    }


    fun GotoFunction1(){
        val int = Intent(this,Function1::class.java)
        startActivity(int)
    }
    fun GotoFunction2(){
        val int = Intent(this,Function2::class.java)
        startActivity(int)
    }
    fun GotoFunction3(){
        val int = Intent(this,Function3::class.java)
        startActivity(int)
    }
}
