package com.szhr.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.szhr.contacts.base.BaseListActivity;

public class SelectSimOrPhoneActivity extends BaseListActivity {

    public static final String TYPE_SIM = "sim";
    public static final String FOR_DELETE = "delete";
    private boolean forDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(getString(R.string.save_to));

        forDelete = getIntent().getBooleanExtra(FOR_DELETE, false);

        if (forDelete) {
            setTitle("删除");
        }

        final String[] data = {getString(R.string.sim_card), getString(R.string.mobile_phone)};
        setListData(data);

        setIndicatorType(INDICATOR_TYPE_INDEX);
    }

    @Override
    protected void onClickListItem(View view, int position) {

        Intent intent = new Intent();
        intent.putExtra(TYPE_SIM, position == 0);

        if (!forDelete) {
            intent.setClass(SelectSimOrPhoneActivity.this, EditContactActivity.class);
        } else {
            intent.putExtra(DeleteConfirmActivity.FOR_ALL, true);
            intent.setClass(SelectSimOrPhoneActivity.this, DeleteConfirmActivity.class);
        }
        startActivity(intent);
        finish();
    }

}
