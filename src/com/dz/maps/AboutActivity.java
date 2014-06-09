package com.dz.maps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

/**
 * Created by dz on 25.04.14.
 */
public class AboutActivity extends Activity{

     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_xml);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean ret;

        if (item.getItemId() == R.id.action_estimate) {
            // Handle Settings
            ret = true;

            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.dz.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        } else {
            ret = super.onOptionsItemSelected(item);
        }

        if (item.getItemId() == R.id.action_unlock) {
            // Handle Settings
            ret = true;

//всплывающее окно для покупки полной версии
            AlertDialog.Builder ad;
            final Context context;
            context = AboutActivity.this;
            String title = "Скачать полную версию";
            String message = "В полной версии:\n1.Отсутствует реклама\n2.Доступны почти все Российские АЗС\n3.Улучшен голосовой ввод\n" +
                    "4. Множество других интересных особенностей";
            String button1String = "Скачать";
            String button2String = "Нет, спасибо";


            ad = new AlertDialog.Builder(context);
            ad.setTitle(title);  // заголовок
            ad.setMessage(message); // сообщение
            ad.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.dz.promaps");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
            ad.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    Toast.makeText(context, "Возможно в другой раз", Toast.LENGTH_LONG)
                            .show();
                }
            });
            ad.setCancelable(true);
            ad.show();

        } else {
            ret = super.onOptionsItemSelected(item);
        }

        if (item.getItemId() == R.id.action_question) {
            // Handle Settings
            ret = true;

            //Окно информации
            String message = "В приложении доступно голосовое управление,\n" +
                    "для ввода команды нужно:\n\n" +
                    "1.Нажать микрофон в главном меню\n"+
                    "2.Произнести фразу в виде:\n" +
                    "\"бензин [марка] остаток [кол-во] литров расход [кол-во] литров на 100 км\"";

            final AlertDialog.Builder infodialog = new AlertDialog.Builder(this);
            infodialog.setTitle("Голосовой ввод");
            infodialog.setMessage(message);
            infodialog.create();
            infodialog.show();

        } else {
            ret = super.onOptionsItemSelected(item);
        }
        return ret;
    }
}
