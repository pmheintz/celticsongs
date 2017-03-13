package net.paulheintz.celticsongs;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonJig, buttonPipes;
    MediaPlayer mpJig, mpPipes;
    int playing = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonJig = (Button)findViewById(R.id.btnJig);
        buttonPipes = (Button)findViewById(R.id.btnBagpipes);
        mpJig = new MediaPlayer();
        mpJig = MediaPlayer.create(this, R.raw.jig);
        mpPipes = new MediaPlayer();
        mpPipes = MediaPlayer.create(this, R.raw.bagpipes);
        buttonJig.setOnClickListener(bJig);
        buttonPipes.setOnClickListener(bPipes);
    }

    Button.OnClickListener bJig = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpJig.start();
                    playing = 1;
                    buttonJig.setText("Pause Irish Jig");
                    buttonPipes.setEnabled(false);
                    buttonPipes.setTextColor(Color.BLACK);
                    break;
                case 1:
                    mpJig.pause();
                    playing = 0;
                    buttonJig.setText("Play Irish Jig");
                    buttonPipes.setEnabled(true);
                    buttonPipes.setTextColor(0xff00ff00);
                    break;
            }
        }
    };

    Button.OnClickListener bPipes = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpPipes.start();
                    playing = 1;
                    buttonPipes.setText("Pause Bagpipes Song");
                    buttonJig.setEnabled(false);
                    buttonJig.setTextColor(Color.BLACK);
                    break;
                case 1:
                    mpPipes.pause();
                    playing = 0;
                    buttonPipes.setText("Play Bagpipes Song");
                    buttonJig.setEnabled(true);
                    buttonJig.setTextColor(0xff00ff00);
                    break;
            }
        }
    };
}
