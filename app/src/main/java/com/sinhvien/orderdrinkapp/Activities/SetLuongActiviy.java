package com.sinhvien.orderdrinkapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.sinhvien.orderdrinkapp.CustomAdapter.AdapterLuong;
import com.sinhvien.orderdrinkapp.DAO.LuongDAO;
import com.sinhvien.orderdrinkapp.DTO.LuongDTO;
import com.sinhvien.orderdrinkapp.R;

public class SetLuongActiviy extends AppCompatActivity {
    private TextView tvManv;
    private EditText etLUONGTHUONG,etLUONGPHAT,etSoGio,etTHANGNAM;
    private Button btnThem;
    private LuongDAO luongDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_luong_activiy);
        tvManv = findViewById(R.id.tvMANV);
        etLUONGPHAT = findViewById(R.id.etLUONGPHAT);
        etLUONGTHUONG = findViewById(R.id.etLUONGTHUONG);
        etTHANGNAM = findViewById(R.id.etTHANGNAM);
        etSoGio = findViewById(R.id.etSOGIO);
        luongDAO = new LuongDAO(SetLuongActiviy.this);
        btnThem = findViewById(R.id.btnSET);
        int maNhanvien = getIntent().getIntExtra("MaNhanVien",1001);
        tvManv.setText("MÃ NHÂN VIÊN : "+ maNhanvien);

        btnThem.setOnClickListener(view ->{
            String luongthuong = etLUONGTHUONG.getText().toString();
            String luongphat = etLUONGPHAT.getText().toString();
            String sogio = etSoGio.getText().toString();
            String thangnam = etTHANGNAM.getText().toString();


            if(sogio.isEmpty()){
                Toast.makeText(SetLuongActiviy.this,"Số giờ không được bỏ trống",Toast.LENGTH_SHORT).show();
            }else if(luongDAO.check(maNhanvien,thangnam)==true){
                if(luongthuong.isEmpty()) luongthuong="0";
                if(luongphat.isEmpty()) luongphat="0";
                LuongDTO luongDTO = new LuongDTO(Integer.valueOf(luongthuong),Integer.valueOf(luongphat),Integer.valueOf(sogio),thangnam,maNhanvien);
                if(luongDAO.SetLuong(luongDTO)){
                    Toast.makeText(SetLuongActiviy.this,"Set Lương thành công",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SetLuongActiviy.this,"Lương tháng này đã tồn tại",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(SetLuongActiviy.this,"Lương tháng này đã tồn tại",Toast.LENGTH_SHORT).show();
            }
        });

    }
}