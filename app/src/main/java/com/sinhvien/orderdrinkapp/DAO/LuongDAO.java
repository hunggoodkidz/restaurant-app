package com.sinhvien.orderdrinkapp.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.sinhvien.orderdrinkapp.DTO.LuongDTO;
import com.sinhvien.orderdrinkapp.Database.CreateDatabase;

import java.util.ArrayList;
import java.util.List;

public class LuongDAO {
    SQLiteDatabase database;
    public LuongDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }

    public boolean SetLuong(LuongDTO luongDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put("LUONGTHUONG",luongDTO.getLuongThuong());
        contentValues.put("LUONGPHAT",luongDTO.getLuongPhat());
        contentValues.put("SOGIO",luongDTO.getSoGio());
        contentValues.put("NGAYTHANG",luongDTO.getNgayThang());
        contentValues.put("MANV",luongDTO.getMaNhanvien());

        long ktra = database.insert("LUONG",null,contentValues);
        return ktra != 0;
    }

    public List<LuongDTO> getAll(){
        List<LuongDTO> arrayList = new ArrayList<LuongDTO>();
        String query = "SELECT * FROM LUONG";
        @SuppressLint("Recycle") Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LuongDTO luongDTO = new LuongDTO();

            luongDTO.setMaLuong(cursor.getInt(cursor.getColumnIndex("MALUONG")));
            luongDTO.setLuongThuong(cursor.getInt(cursor.getColumnIndex("LUONGTHUONG")));
            luongDTO.setLuongPhat(cursor.getInt(cursor.getColumnIndex("LUONGPHAT")));
            luongDTO.setSoGio(cursor.getInt(cursor.getColumnIndex("SOGIO")));
            luongDTO.setNgayThang(cursor.getString(cursor.getColumnIndex("NGAYTHANG")));
            luongDTO.setMaNhanvien(cursor.getInt(cursor.getColumnIndex("MANV")));
            arrayList.add(luongDTO);
            cursor.moveToNext();
        }
        return arrayList;
    }

    public List<LuongDTO> getListLuong(int manhanvien){
        List<LuongDTO> arrayList = new ArrayList<LuongDTO>();
        String query = "SELECT * FROM LUONG WHERE MANV ="+manhanvien;
        @SuppressLint("Recycle") Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LuongDTO luongDTO = new LuongDTO();

            luongDTO.setMaLuong(cursor.getInt(cursor.getColumnIndex("MALUONG")));
            luongDTO.setLuongThuong(cursor.getInt(cursor.getColumnIndex("LUONGTHUONG")));
            luongDTO.setLuongPhat(cursor.getInt(cursor.getColumnIndex("LUONGPHAT")));
            luongDTO.setSoGio(cursor.getInt(cursor.getColumnIndex("SOGIO")));
            luongDTO.setNgayThang(cursor.getString(cursor.getColumnIndex("NGAYTHANG")));
            luongDTO.setMaNhanvien(manhanvien);
            arrayList.add(luongDTO);
            cursor.moveToNext();
        }
        return arrayList;
    }


    public boolean check(int manhanvien,String thangNAM){
        List<LuongDTO> arrayList = new ArrayList<LuongDTO>();
        String query = "SELECT * FROM LUONG WHERE MANV ="+manhanvien+" AND NGAYTHANG='"+thangNAM+"'";
        @SuppressLint("Recycle") Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LuongDTO luongDTO = new LuongDTO();

            luongDTO.setMaLuong(cursor.getInt(cursor.getColumnIndex("MALUONG")));
            luongDTO.setLuongThuong(cursor.getInt(cursor.getColumnIndex("LUONGTHUONG")));
            luongDTO.setLuongPhat(cursor.getInt(cursor.getColumnIndex("LUONGPHAT")));
            luongDTO.setSoGio(cursor.getInt(cursor.getColumnIndex("SOGIO")));
            luongDTO.setNgayThang(cursor.getString(cursor.getColumnIndex("NGAYTHANG")));
            luongDTO.setMaNhanvien(manhanvien);
            arrayList.add(luongDTO);
            cursor.moveToNext();
        }
        return arrayList.size() == 0;
    }


}
