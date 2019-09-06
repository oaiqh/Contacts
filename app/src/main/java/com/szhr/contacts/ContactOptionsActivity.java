package com.szhr.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.szhr.contacts.base.BaseActivity;
import com.szhr.contacts.base.BaseListActivity;
import com.szhr.contacts.model.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactOptionsActivity extends BaseListActivity {

    public static final String KEY_CONTACT = "contact";

    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contact = (Contact) getIntent().getSerializableExtra(KEY_CONTACT);

        final String[] data = {"拨号", "IP拨号", "写短信", "查看内容", "编辑", "删除当前记录", "删除全部记录", "复制当前记录"
                , "复制全部记录", "高级复制", "发送名片"};
        setListData(data);

        setIndicatorType(INDICATOR_TYPE_CYCLE);

    }

    @Override
    protected void onClickListItem(View view, int position) {
        Intent intent;
        switch (position) {
            case 3:
                intent = new Intent(ContactOptionsActivity.this, ShowContactDetailActivity.class);
                intent.putExtra(KEY_CONTACT, contact);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(ContactOptionsActivity.this, EditContactActivity.class);
                intent.putExtra(EditContactActivity.FOR_UPDATE, true);
                intent.putExtra(KEY_CONTACT, contact);
                startActivity(intent);
            default:
                break;
        }
    }
}
