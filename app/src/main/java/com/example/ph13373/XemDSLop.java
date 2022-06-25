package com.example.ph13373;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class XemDSLop extends AppCompatActivity {
    ListView lv_dsLop;
    LopDAL lopDAL;
    List<Lop> _lstLops = new ArrayList<>();
    ArrayAdapter<Lop> adapter;
    SinhVienDAL sinhVienDAL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_dslop);
        lv_dsLop=findViewById(R.id.lv_dsLop);
        lopDAL =new LopDAL(XemDSLop.this);
        sinhVienDAL=new SinhVienDAL(XemDSLop.this);
        _lstLops =lopDAL.get_lstLops();

        LopAdapter adapter = new LopAdapter(this,R.layout.item_lv_dslop,_lstLops);
        lv_dsLop.setAdapter(adapter);

        lv_dsLop.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder aBuilder = new AlertDialog.Builder(XemDSLop.this);
                aBuilder.setMessage("Ban co muon xoa lop?");
                aBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        sinhVienDAL.deleteSV_lop(_lstLops.get(position).getMaLop());
                        String tb=lopDAL.deleteLop(_lstLops.get(position).getMaLop());
                        finish();
                        startActivity(getIntent());
                    }
                });
                aBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog = aBuilder.create();
                alertDialog.show();


                return false;
            }

        });
    }
}