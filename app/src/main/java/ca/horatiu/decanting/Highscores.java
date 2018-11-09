package ca.horatiu.decanting;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.database.sqlite.*;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Highscores extends AppCompatActivity {
    private static HighscoresDataSource datasource;

    public static HighscoresDataSource getDatasource(){
        return datasource;
    }

    public Highscores(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);

        datasource = new HighscoresDataSource(this);
        datasource.open();

        /*datasource.reset();
        datasource.addScore("15", "1");
        datasource.addScore("7", "3");
        datasource.addScore("16", "3");
        datasource.addScore("2", "3");
        datasource.addScore("16", "4");
        datasource.addScore("16", "2");*/

        for(HighscoresItem a : datasource.getAllRecords()) {
            Log.d("Moves: ", " Level: " + a.getLevel() + " | Moves: " + a.getMoves());
        }

    }

    private void resetScores(){
        datasource.reset();
    }
}
