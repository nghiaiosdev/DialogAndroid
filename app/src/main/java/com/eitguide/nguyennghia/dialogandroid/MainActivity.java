package com.eitguide.nguyennghia.dialogandroid;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_dialog_normal:
                final AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("This is title")
                        .setMessage("Nguyen Van Nghia")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.e(TAG, "OK");
                            }
                        }).setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.e(TAG, "Cancle");
                                dialogInterface.dismiss();
                            }
                        })
                        .setNeutralButton("Normal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.e(TAG, "Normal");
                            }
                        })
                        .create();

                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {

                    }
                });


                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {

                    }
                });

                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {

                    }
                });

                dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        return false;
                    }
                });

                dialog.show();
                break;

            case R.id.btn_dialog_custom:
                android.support.v7.app.AlertDialog dialogCustom = new android.support.v7.app.AlertDialog.Builder(this)
                        .setTitle("Custom dialog")
                        .setView(R.layout.edit_name_layout)
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();


                dialogCustom.show();
                break;
            case R.id.btn_dialog_listview:
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, new String[]{"Nguyen Van Nghia", "Nguyen Hoang Minh", "Pham Nguyen Tam Phu", "Tran Van Phuc", "Nguyen Ngoc Tien", "Nguyen Xuan Vien"});
                AlertDialog dialogListView = new AlertDialog.Builder(this)
                        .setTitle("Dialog ListView")
                        .setIcon(R.drawable.favicon)
                        .setAdapter(adapter, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.e(TAG, "onClick: " + adapter.getItem(which));
                            }
                        })
                        .create();
                dialogListView.show();

                break;
            case R.id.btn_dialog_single_select:
                android.support.v7.app.AlertDialog singleDialog = new android.support.v7.app.AlertDialog.Builder(this)
                        .setTitle("SingleSelect Dialog")
                        .setIcon(R.drawable.favicon)
                        .setSingleChoiceItems(new CharSequence[]{"Nguyen Nghia", "Hoang Minh", "Pham Phu", "Tran Phuc"}, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.e(TAG, "onClick: " + i);
                            }
                        })
                        .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();

                singleDialog.show();
                break;

            case R.id.btn_dialog_multi_select:
                final android.support.v7.app.AlertDialog multiDialog = new android.support.v7.app.AlertDialog.Builder(this)
                        .setTitle("Multi Dialog")
                        .setIcon(R.drawable.favicon)
                        .setMultiChoiceItems(new CharSequence[]{"Nguyen Nghia", "Hoang Minh", "Pham Phu", "Tran Phuc"}, new boolean[]{false, true, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                            }
                        })
                        .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();

                multiDialog.show();
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }
}
