package com.example.tessthihii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SVdatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="QLTTSV.db";
    // khai báo tên bảng
    private static final String TABLE_NAME="svcntt1";
    // khai báo tên trường
    private static final String ID="MaSV";
    private static final String NAME="Hoten";
    private static final String CLASS="Lop";
    private static final String ADDRESS="DiaChi";
    private static final String PHONE="SDT";

    //Khai bao version
    private static int VERSION = 1;
    private Context context;
    //constructor
    public SVdatabase (Context context)
    {
        super(context,  DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql1="CREATE TABLE "+TABLE_NAME+" ( "+
                ID+" Text primary key, "+
                NAME+" Text, "+
                CLASS+ " Text, "+
                ADDRESS+" Text, "+
                PHONE+" Text )";
        // thực thi tạo bảng
        sqLiteDatabase.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    //3.Thêm mới sinh viên vào CSDL
    public void AddSv(SinhVien sv)
    {
        // gọi CSDL
        SQLiteDatabase db=this.getWritableDatabase();
        // tạo đối tượng values chứa các nội dung của sv
        ContentValues values=new ContentValues();
        values.put(ID,sv.getMaSv());
        values.put(NAME,sv.getHoTen());
        values.put(CLASS,sv.getLop());
        values.put(ADDRESS,sv.getDiaChi());
        values.put(PHONE,sv.getSdt());
        // chèn values vào CSDL
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    //4. Cap nhat CSDL
    public  int UpdateSV(SinhVien sv)
    {
        //goi CSDL
        SQLiteDatabase db = this.getWritableDatabase();
        // tao doi tuong values chua cac noi dung cua sv
        ContentValues values = new ContentValues();
        values.put(NAME, sv.getHoTen());
        values.put(CLASS, sv.getLop());
        values.put(ADDRESS, sv.getDiaChi());
        values.put(PHONE, sv.getSdt());
        int kq = db.update(TABLE_NAME, values, ID +"=?",new String[]{sv.getMaSv()});
        db.close();
        return kq;
    }
    //5. Xoa CSDL thong qua ID
    public int DeleteSV( String id)
    {
        //goi CSDL
        SQLiteDatabase db = this.getWritableDatabase();
        int kq = db.delete(TABLE_NAME, ID + "=?", new String[]{id});
        db.close();
        return kq;
    }
    //6. Lay toan bo thong tin sinh vien trong csdl
    public List<SinhVien> InformationSV(){
        List<SinhVien> listSV=new ArrayList<SinhVien>();
        SQLiteDatabase db=this.getWritableDatabase();
        String sql3="SELECT * FROM "+TABLE_NAME;
        // thực thi
        Cursor cursor = db.rawQuery(sql3, null);
        if(cursor.moveToFirst()){
            do {
                SinhVien sv1=new SinhVien();
                sv1.setMaSv(cursor.getString(0));
                sv1.setHoTen(cursor.getString(1));
                sv1.setLop(cursor.getString(2));
                sv1.setDiaChi(cursor.getString(3));
                sv1.setSdt(cursor.getString(4));
                listSV.add(sv1);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listSV;
    }

}
