package com.sinhvien.orderdrinkapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.sinhvien.orderdrinkapp.Activities.HomeActivity;
import com.sinhvien.orderdrinkapp.CustomAdapter.AdapterDisplayStaff;
import com.sinhvien.orderdrinkapp.CustomAdapter.AdapterLuong;
import com.sinhvien.orderdrinkapp.DAO.LuongDAO;
import com.sinhvien.orderdrinkapp.DAO.NhanVienDAO;
import com.sinhvien.orderdrinkapp.DTO.LuongDTO;
import com.sinhvien.orderdrinkapp.R;

import java.util.List;


public class BlankFragmentLuong extends Fragment {
    private AdapterLuong adapterLuong;
    private GridView gridView;
    private LuongDAO luongDAO;
    private List<LuongDTO> luongDTOList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_luong, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity)getActivity()).getSupportActionBar().setTitle("Lương Thống kê");
        setHasOptionsMenu(true);
        gridView = view.findViewById(R.id.gvLuong);
        luongDAO = new LuongDAO(getActivity());
        HienThiDSNV(HomeActivity.maquyen);
    }

    private void HienThiDSNV(int quyen){
       if(quyen == 1){
           luongDTOList = luongDAO.getAll();
       }else{
           luongDTOList = luongDAO.getListLuong(HomeActivity.manv);
       }
        adapterLuong = new AdapterLuong(getActivity(),R.layout.customer_luong,luongDTOList);
        gridView.setAdapter(adapterLuong);
        adapterLuong.notifyDataSetChanged();
    }
}