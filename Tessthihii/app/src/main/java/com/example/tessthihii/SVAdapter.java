package com.example.tessthihii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SVAdapter extends ArrayAdapter {
    // khai bao thanh phan
    private Context context;
    private  int resource;
    private List<SinhVien> listSV;

    public SVAdapter( Context context, int resource, List<SinhVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listSV = objects;
    }
    class ViewHolder{
        // Khai bao cac thanh phan trong item_list_sv
        TextView tvMaSv, tvHoTen, tvLop, tvDiaChi, tvSdt;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // khai bap viewholder
        ViewHolder viewHolder;
        //ktra giao dien view xem co rong khong
        // neu rong -> set hien thi item_list len
        // neu khong thi settag noi dung len
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_listsv, viewGroup,false);
            viewHolder= new ViewHolder();
            // anh xa (lay du lieu)
            viewHolder.tvMaSv = (TextView) view.findViewById(R.id.tv_MaSv);
            viewHolder.tvHoTen = (TextView) view.findViewById(R.id.tv_HoTen);
            viewHolder.tvLop = (TextView) view.findViewById(R.id.tv_Lop);
            viewHolder.tvDiaChi = (TextView) view.findViewById(R.id.tv_DiaChi);
            viewHolder.tvSdt = (TextView) view.findViewById(R.id.tv_Sdt);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        // thiet lap gtri
        SinhVien sv = listSV.get(i);
        viewHolder.tvMaSv.setText(sv.getMaSv());
        viewHolder.tvHoTen.setText(sv.getHoTen());
        viewHolder.tvLop.setText(sv.getLop());
        viewHolder.tvDiaChi.setText(sv.getDiaChi());
        viewHolder.tvSdt.setText(sv.getSdt());

        return view;
    }

}
