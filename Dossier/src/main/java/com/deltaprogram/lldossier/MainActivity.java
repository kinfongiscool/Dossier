package com.deltaprogram.lldossier;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView displayName;
    private TextView displayNumApps;
    private TextView displayFavoritePerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person person = new Person("Kin", "Fong", 1, "Adam");

        displayName = (TextView) findViewById(R.id.textViewNameData);
        displayNumApps = (TextView) findViewById(R.id.textViewAppData);
        displayFavoritePerson = (TextView) findViewById(R.id.textViewFavoritePersonData);

        String displayStringName = person.getPersonFirstName() + " " + person.getPersonLastName();
        String displayStringNumApps = person.getPersonNumberOfAppsMade() + "";
        String displayStringFavoritePerson = person.getPersonFavoritePerson();

        displayName.setText(displayStringName);
        displayNumApps.setText(displayStringNumApps);
        displayFavoritePerson.setText(displayStringFavoritePerson);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
