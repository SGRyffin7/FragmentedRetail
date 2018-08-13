package com.example.sagarsharma4.retailfragmented;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.onContactClick {

    static FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    ArrayList<Data> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadContacts();

        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.container1)!=null){

            if(savedInstanceState!=null){
                return;
            }

            fragmentTransaction = fragmentManager.beginTransaction();

            ListFragment listFragment = new ListFragment();

            listFragment.setArguments(contacts);
            fragmentTransaction.add(R.id.container1, listFragment,null);
            fragmentTransaction.commit();

        }
    }

    private void loadContacts(){
        String phoneNumber ="";

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC");

        String id;
        String name;
//        int hasPhoneNumber;
//        Cursor cursor1;

//        cursor.moveToFirst();

        while(cursor.moveToNext()){
                id = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
                name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                phoneNumber =cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                contacts.add(new Data(R.drawable.ic_launcher_foreground, name, phoneNumber, "email@you.com", id));

        }
        cursor.close();
    }

    @Override
    public void onClickGetID(int pos) {
        fragmentTransaction = fragmentManager.beginTransaction();

        Data contact = contacts.get(pos);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setContactDetails(contact.name, contact.phoneNumber);
        fragmentTransaction.replace(R.id.container1, detailFragment, null);
        fragmentTransaction.commit();
    }
}
