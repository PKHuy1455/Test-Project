package com.example.a22ceb012_phankhachuy

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView.OnQueryTextListener

class Function3 : AppCompatActivity() {
    lateinit var db: SQLiteDatabase
    lateinit var rs: Cursor
    lateinit var adapter: SimpleCursorAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function3)
        var Lview = findViewById<ListView>(R.id.Lview)

        var txtID = findViewById<EditText>(R.id.edtId)
        var txtName = findViewById<EditText>(R.id.edtname)
        var txtTC = findViewById<EditText>(R.id.edtTC)
        var txtHK = findViewById<EditText>(R.id.edtHK)

        var btn_Load = findViewById<Button>(R.id.btnLoad)
        var btn_Add = findViewById<Button>(R.id.btnAdd)
        var btn_Edit = findViewById<Button>(R.id.btnEdit)
        var btn_Dele = findViewById<Button>(R.id.btnDele)

        var ConnectDB = ConetionDB(applicationContext)
        db = ConnectDB.readableDatabase  //Set chế độ đọc database
        rs = db.rawQuery("SELECT ID AS _id, NAME, TC, HK FROM HOCPHAN LIMIT 20", null)
//        //tương tác lệnh trong database
//        //sql: String chuỗi câu lệnh sql
//        // String[] selectionArgs: chọn lọc với điều kiện mảng.
//
//
        adapter = SimpleCursorAdapter(
               applicationContext,android.R.layout.simple_list_item_2,rs,
               arrayOf("_id","NAME","TC","HK"), intArrayOf(android.R.id.text1,android.R.id.text2),0
           )
//       //simple_list_item_2: layout có sẵn trong android
//       //rs: Con trỏ
//       //Đối số thứ 4 truyền vào 1 mảng trong mảng là những cột muốn lấy dữ liệu
//
        Lview.adapter = adapter
//        //Thiết lập event lắng nghe cho button Hiển thị
        btn_Load.setOnClickListener {

             Lview.visibility = View.VISIBLE //hiển thị Listview vì trước đó có ẩn đi
            adapter.notifyDataSetChanged()    //thông báo Listview đã thay đổi dữ liệu để nó có thể cập nhật lại
        //ghi click vào SearchView thì nó sẽ ra thông báo trên thanh (!) rs.count: điếm và trả về số lượng hàng hiện đang có trong database

        }
        //Thêm chức năng  buttons thêm
        btn_Add.setOnClickListener {
            var cv = ContentValues()   //hàm chèn dữ liệu
            cv.put("NAME", txtName.text.toString())
            cv.put("TC", txtTC.text.toString())
            cv.put("HK", txtHK.text.toString())
            //Đẩy(put) dữ liệu vào database; tham số 1: tên cột, tham số 2: giá trị truyền vào
            db.insert("HOCPHAN",null,cv)  //Hàm chèn dữ liệu
            rs.requery() //reset lại database

            adapter.notifyDataSetChanged() //Update ngay lập tức trên ListView

            var ad = AlertDialog.Builder(this)
            ad.setTitle("Add Record")
            ad.setMessage("Add thành công ")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener({
                    dialog, which ->  txtName.setText("")
                txtHK.setText("")
                txtID.setText("")
                txtHK.setText("")
                txtID.requestFocus()
            }))
            ad.show()

        }

        //Chức năng button update
        btn_Edit.setOnClickListener {
            var cv = ContentValues()   //hàm chèn dữ liệu
            cv.put("NAME", txtName.text.toString())
            cv.put("TC", txtTC.text.toString())
            cv.put("HK", txtHK.text.toString())
            //Đẩy(put) dữ liệu vào database; tham số 1: tên cột, tham số 2: giá trị truyền vào
            db.update("HOCPHAN",cv,"ID = ?", arrayOf(rs.getString(0)))  //Hàm chèn dữ liệu
            rs.requery() //reset lại database

            adapter.notifyDataSetChanged() //Update ngay lập tức trên ListView

            var ad = AlertDialog.Builder(this)
            ad.setTitle("Update Record")
            ad.setMessage("Add thành công ")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener({
                    dialog, which ->  txtName.setText("")
                txtHK.setText("")
                txtID.setText("")
                txtHK.setText("")
                txtID.requestFocus()
            }))
            ad.show()
        }
        //Chức nắng button Delete
        btn_Dele.setOnClickListener {
            db.delete("HOCPHAN","ID = ?", arrayOf(rs.getString(0)))
            rs.requery()
            var ad = AlertDialog.Builder(this)
            ad.setTitle("Delete Record")
            ad.setMessage("Delete thành công ")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener({
                    dialog, which ->  txtName.setText("")
                txtHK.setText("")
                txtID.setText("")
                txtHK.setText("")
                txtID.requestFocus()
            }))
            ad.show()
        }
    }
}