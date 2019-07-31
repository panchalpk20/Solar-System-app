package com.example.solar;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimerTask;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class MainActivity extends AppCompatActivity {

    String mercury, mars, earth, sun, venus, neptune, uranus, jupitar, saturn, comet;
    Button planetinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try{
            this.getSupportActionBar().hide();
        } catch (Exception e){}


        setContentView(R.layout.activity_main);

        planetinfo = findViewById(R.id.planet); //Button

        planetinfo.setVisibility(View.INVISIBLE);

        //---------------------------------------------------------------------------

          ObjectAnimator tvAnimation = ObjectAnimator.ofObject(
                  findViewById(R.id.welcome), // Object to animating ie welcome text
                  "textColor", // Property to animate
                  new ArgbEvaluator(), // Interpolation function
                  Color.CYAN,
                  Color.parseColor("#FFFF5252"),
                  Color.LTGRAY, Color.YELLOW, Color.CYAN,
                  Color.parseColor("#FFFF5252")
                  );
          tvAnimation.setDuration(2000);
          tvAnimation.setRepeatCount(ValueAnimator.INFINITE);
          tvAnimation.setRepeatMode(ValueAnimator.REVERSE);
          tvAnimation.start();



          //--------------=----------------------------------------------------------

        mercury = "The smallest planet in our solar system and nearest to the Sun," +
                " Mercury is only slightly larger than Earth's Moon.From the surface of Mercury," +
                " the Sun would appear more than three times as large as it does when viewed from Earth, " +
                "and the sunlight would be as much as seven times brighter. " +
                "Despite its proximity to the Sun, Mercury is not the hottest planet in our solar system – " +
                "that title belongs to nearby Venus, thanks to its dense atmosphere";


        mars = "The fourth planet from the Sun, Mars is a dusty, cold, desert world with a very thin atmosphere."+
        "This dynamic planet has seasons, polar ice caps and weather and canyons and extinct volacanoes," +
                " evidence of an even more active past.\n" +
                "\n" +
                "Mars is one of the most explored bodies in our solar system," +
                " and it's the only planet where we've sent rovers to roam the alien landscape. " +
                "" +
                "NASA currently has three spacecraft in orbit, one rover and one lander on the surface and another " +
                "rover under construction here on Earth. India and ESA also have spacecraft in orbit above Mars.\n" +
                "\n" +
                "These robotic explorers have found lots of evidence that Mars was much wetter and warmer, with a thicker atmosphere, billions of years ago.";


        earth = "Our home planet is the third planet from the Sun, " +
                "and the only place we know of so far that’s inhabited by living things." +
                " While Earth is only the fifth largest planet in the solar system, it is the only world " +
                "in our solar system with liquid water on the surface. Just slightly larger than nearby " +
                "Venus, Earth is the biggest of the four planets closest to the Sun, all of which are made of rock and metal.\n" +
                "\n" +
                "The name Earth is at least 1,000 years old." +
                " All of the planets, except for Earth, were named after Greek and Roman gods and goddesses." +
                " However, the name Earth is a Germanic word, which simply means “the ground.”";

        sun = "The Sun—the heart of our solar system—is a yellow dwarf star, " +
                "a hot ball of glowing gases.Its gravity holds the solar system together, " +
                "keeping everything from the biggest planets to the smallest particles of debris in its orbit." +
                " Electric currents in the Sun generate a magnetic field that is carried out through the " +
                "solar system by the solar wind—a stream of electrically charged gas " +
                "blowing outward from the Sun in all directions.\n" +
                "\n" +
                "The connection and interactions between the Sun and Earth drive the seasons, ocean currents," +
                " weather, climate, radiation belts and aurorae. " +
                "Though it is special to us, there are billions of stars like our Sun scattered across " +
                "the Milky Way galaxy.";


        venus = "A Japanese research group has identified a giant streak structure among " +
                "the clouds covering Venus based on observation from the spacecraft Akatsuki. " +
                "The team also revealed the origins of this structure using large-scale climate simulations. " +
                "The group was led by Project Assistant Professor Hiroki Kashimura " +
                "(Kobe University, Graduate School of Science) and these findings were " +
                "published on January 9 in Nature Communications.\n" +
                "\n" +
                "Second planet from the Sun and our closest " +
                "planetary neighbor, Venus is similar in structure and size to Earth, " +
                "but it is now a very different world. Venus spins slowly in the opposite direction most planets do. " +
                "Its thick atmosphere traps heat in a runaway greenhouse effect, " +
                "making it the hottest planet in our solar system—with surface temperatures hot enough to melt lead. " +
                "Glimpses below the clouds reveal volcanoes and deformed mountains.";


        neptune = "Dark, cold and whipped by supersonic winds, ice giant Neptune is the eighth and most distant planet in our solar system." +
                " More than 30 times as far from the Sun as Earth, Neptune is the only planet in our solar system not " +
                "visible to the naked eye and the first predicted by mathematics before its discovery. " +
                "In 2011 Neptune completed its first 165-year orbit since its discovery in 1846.\n" +
                "\n" +
                "NASA's Voyager 2 is the only spacecraft to have visited Neptune up close. It flew past in 1989 on its way out of the solar system.";


        uranus = " In April 2017, a global research team found hydrogen sulfide, " +
                "the odiferous gas that most people avoid, in Uranus " +
                "cloud tops—a striking difference from the gas giant planets located closer to the Sun.\n" +
                "\n" +
                "The first planet found with the aid of a telescope," +
                " Uranus was discovered in 1781 by astronomer William Herschel, " +
                "although he originally thought it was either a comet or a star. " +
                "It was two years later that the object was universally accepted as a new planet," +
                " in part because of observations by astronomer Johann Elert Bode. " +
                "Herschel tried unsuccessfully to name his discovery Georgium Sidus after King George III." +
                " Instead the planet was named for Uranus, the Greek god of the sky, as suggested by Johann Bode. ";


        jupitar = "Jupiter has a long history surprising scientists—all " +
                "the way back to 1610 when Galileo Galilei found the first moons beyond Earth." +
                " That discovery changed the way we see the universe.Fifth in line from the Sun, Jupiter is, by far, " +
                "the largest planet in the solar system – more than twice as massive as all the other planets combined.\n" +
                "\n" +
                "Jupiter's familiar stripes and swirls are actually cold, " +
                "windy clouds of ammonia and water, floating in an atmosphere of hydrogen and helium. " +
                "Jupiter’s iconic Great Red Spot is a giant storm bigger than Earth that has raged " +
                "for hundreds of years";


        saturn = "Saturn is the sixth planet from the Sun and the second largest planet in our solar system." +
                "Adorned with thousands of beautiful ringlets, Saturn is unique among the planets." +
                " It is not the only planet to have rings—made of chunks of ice and rock—but none are as spectacular " +
                "or as complicated as Saturn's.\n" +
                "\n" +
                "Like fellow gas giant Jupiter, Saturn is a massive ball made mostly of hydrogen and helium.";



        comet = "Comets are cosmic snowballs of frozen gases," +
                " rock and dust that orbit the Sun. When frozen, they are the size of " +
                "a small town. When a comet's orbit brings it close to the Sun, it heats up and " +
                "spews dust and gases into a giant glowing head larger than most planets. " +
                "The dust and gases form a tail that stretches away from the Sun for millions of miles. " +
                "There are likely billions of comets orbiting our Sun in the Kuiper Belt and even " +
                "more distant Oort Cloud.\n" +
                "\n" +
                "The current number of known comets is: 3,576 ";


     //   showDialog("earth", earth, R.drawable.earth);

    }





    public void planet(View view) {
        String planet = view.getTag().toString();
        switch (planet){
            case "mercury" :
                log("planet mercury");
                planetinfo.setText("Mercury");
            break;
            case  "venus" : log("planet venus");
            break;
            case  "earth" : log("planet earth\n\n" +earth);
            break;
            case "mars" : log("planet mars");
            break;
            case "Jupiter" : log("planet Jupiter");
            break;
            case  "saturn" : log("planet saturn");
            break;
            case  "uranus" : log("planet uranus");
            break;
            case  "neptune" : log("planet neptune");
            break;
            case  "sun" : log("planet sun");
            break;
        }

        planetinfo.setText(planet);

        planetinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillAlert();
            }
        });
        planetinfo.setVisibility(View.VISIBLE);

        new CountDownTimer(3000, 1000) {
            public void onFinish() {
               planetinfo.setVisibility(View.INVISIBLE
               );
            }
            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
        }.start();

    }

    private void fillAlert() {

        String lable = planetinfo.getText().toString();
        switch (lable){

            case "mercury" :
                showDialog("Mercury", mercury,R.drawable.mercury );
                break;
            case  "venus" :
                showDialog("Venus", venus,R.drawable.venus );

                break;
            case  "earth" :
                showDialog("Earth", earth,R.drawable.earth );

                break;
            case "mars" :
                showDialog("Mars", mercury,R.drawable.mars );

                break;
            case "Jupiter" :
                showDialog("Jupiter", jupitar,R.drawable.jupiter );

                break;
            case  "saturn" :
                showDialog("Saturn", saturn,R.drawable.saturn );

                break;
            case  "uranus" :
                showDialog("Uranus", uranus,R.drawable.uranus );

                break;
            case  "neptune" :
                showDialog("Neptune", neptune, R.drawable.neptune);
                break;
            case  "sun" :
                showDialog("Sun", sun,R.drawable.sun);

                break;
            case "comet":
                showDialog("Comet",comet,R.drawable.comet_real );

        }

    }


    public void log(String msg){
       // Toast.makeText(this, "Log Planet :: "+msg, Toast.LENGTH_SHORT).show();

        Log.e("","LOG:::::"+msg);
    }

    public void showDialog(String t, String d, int res){
        final Dialog info = new Dialog(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.info_dialog, null);
        info.setContentView(view);

        TextView title = view.findViewById(R.id.title);
        TextView desc = view.findViewById(R.id.desc);
        ImageView image = view.findViewById(R.id.image);
        desc.setMovementMethod(new ScrollingMovementMethod());



        image.setImageResource(res);
        title.setText(t);
        desc.setText(d);




        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window windowAlDl = info.getWindow();

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        if (windowAlDl != null) {
            windowAlDl.setAttributes(layoutParams);
        }


        view.findViewById(R.id.close_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.dismiss();
            }
        });



        info.show();

    }


    public void onBackPressed(){
        final Dialog d = new Dialog(MainActivity.this);
        final View exit = getLayoutInflater().inflate(R.layout.exit,null);
        d.setContentView(exit);

        exit.findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        exit.findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });

        d.show();



    }




}

