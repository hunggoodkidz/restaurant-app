package com.sinhvien.orderdrinkapp.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.sinhvien.orderdrinkapp.Activities.HomeActivity;
import com.sinhvien.orderdrinkapp.DAO.NhanVienDAO;
import com.sinhvien.orderdrinkapp.DTO.LuongDTO;
import com.sinhvien.orderdrinkapp.DTO.NhanVienDTO;
import com.sinhvien.orderdrinkapp.R;

import java.util.List;

public class AdapterLuong  extends BaseAdapter {
    Context context;
    int layout;
    List<LuongDTO> luongDTOList;
    AdapterLuong.ViewHolder viewHolder;
    NhanVienDAO nhanVienDAO;

    public AdapterLuong(Context context, int layout, List<LuongDTO> luongDTOList){
        this.context = context;
        this.layout = layout;
        this.luongDTOList = luongDTOList;
        nhanVienDAO = new NhanVienDAO(context);
    }

    @Override
    public int getCount() {
        return luongDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return luongDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return luongDTOList.get(position).getMaLuong();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new AdapterLuong.ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            viewHolder.tvNGAYTHANG = (TextView)view.findViewById(R.id.tvTHANGNAM);
            viewHolder.tvSOGIO = (TextView)view.findViewById(R.id.tvSOGIO);
            viewHolder.tvLUONGTHUONG = (TextView)view.findViewById(R.id.tvLUONGTHUONG);
            viewHolder.tvLUONGPHAT = (TextView)view.findViewById(R.id.tvLUONGPHAT);
            viewHolder.tvTONG = (TextView)view.findViewById(R.id.tvTONGLUONG);
            viewHolder.tvThongTin= view.findViewById(R.id.tongThogntin);

            view.setTag(viewHolder);
        }else {
            viewHolder = (AdapterLuong.ViewHolder) view.getTag();
        }
        LuongDTO luongDTO = luongDTOList.get(position);
        NhanVienDTO nhanVienDTO = nhanVienDAO.LayNVTheoMa(HomeActivity.manv);
        if(nhanVienDTO.getMAQUYEN()==1){
            NhanVienDTO nhanvien = nhanVienDAO.LayNVTheoMa(luongDTO.getMaNhanvien());
            String quyen = nhanvien.getMAQUYEN() ==2?"Chạy bàn":"Đầu bếp";
            viewHolder.tvThongTin.setText(nhanvien.getHOTENNV()+"---"+quyen);
        }else{
            viewHolder.tvThongTin.setVisibility(View.GONE);
        }
        int Tong = luongDTO.getSoGio()*25000+luongDTO.getLuongThuong()-luongDTO.getLuongPhat();
        viewHolder.tvNGAYTHANG.setText("Lương tháng "+luongDTO.getNgayThang());
        viewHolder.tvSOGIO.setText("Số giờ : "+luongDTO.getSoGio()+" X 25.000 = "+luongDTO.getSoGio()*25000);
        viewHolder.tvLUONGTHUONG.setText("Lương thưởng :    "+luongDTO.getLuongThuong());
        viewHolder.tvLUONGPHAT.setText("Lương phạt :    "+luongDTO.getLuongPhat());
        viewHolder.tvTONG.setText("TỔNG :    "+Tong);

        return view;
    }

    public class ViewHolder{
        TextView tvNGAYTHANG,tvSOGIO,tvLUONGTHUONG,tvLUONGPHAT,tvTONG,tvThongTin;
    }
}
