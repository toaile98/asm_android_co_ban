//package com.example.ph13373;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import java.util.List;
//
//public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
//    private Context context;
//    private int layout;
//    private List<SinhVien> _lstSinhViens;
//    private LayoutInflater  inflater;
//
//    public SinhVienAdapter( Context context, int resource,  List<SinhVien> objects) {
//        super(context, resource, objects);
//        this.context=context;
//        this.layout=resource;
//        this._lstSinhViens=objects;
//
//        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position,  View convertView,  ViewGroup parent) {
////        viewHolder holder = new viewHolder();
////        if(convertView==null){
////            convertView=inflater.inflate(R.layout.item_lv_ds_sv,null);
////            holder.lbl_sttSV=(TextView)convertView.findViewById(R.id.lbl_stt_sv);
////            holder.lbl_tenSVV=(TextView)convertView.findViewById(R.id.lbl_tenSv);
////            holder.lbl_ngaySinhsv=(TextView)convertView.findViewById(R.id.lbl_ngaySinh);
////        }
////        else{
////            holder=(viewHolder)convertView.getTag();
////        }
////
////        SinhVien sv =_lstSinhViens.get(position);
////        holder.lbl_sttSV.setText(String.valueOf(position+1));
////        holder.lbl_tenSVV.setText(sv.getTenSV());
////        holder.lbl_ngaySinhsv.setText(sv.getNgaySinh());
//
//        return convertView;
//    }
//    public class viewHolder{
//        TextView lbl_sttSV,lbl_tenSVV,lbl_ngaySinhsv;
//    }
//}
