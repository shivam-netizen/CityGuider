package com.example.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cityguide.Common.LoginSignup.ForgetPassword;
import com.example.cityguide.Common.LoginSignup.Login;
import com.example.cityguide.Common.LoginSignup.RetailerStartScreen;
import com.example.cityguide.HelperClasses.FeaturedAdapter;
import com.example.cityguide.HelperClasses.FeaturedHelperClass;
import com.example.cityguide.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {
    //Variables
    RecyclerView featuredRecycler,mostViewedRecycler, categoriesRecycler;
    FeaturedAdapter adapter;
    private GradientDrawable gradient1,gradient2,gradient3,gradient4;

    //Drawer Menu
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinator;
    private ImageView imgNavHeaderlogo, img2;
    private  LinearLayout layout;
    private TextView txtName, textappname;
    private Toolbar toolbarr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        SharedPreferences sharedPreferences = getSharedPreferences("WelcomeScreen", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IsFirtTime",false);
        editor.apply();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbarr=findViewById(R.id.toolbar);
        setSupportActionBar(toolbarr);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbarr, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.navigation_view);
        // Navigation view header
        navHeader =  navigationView.getHeaderView(0);
        txtName = navHeader.findViewById(R.id.menu_slogan);
        textappname= navHeader.findViewById(R.id.app_name);
        imgNavHeaderlogo = navHeader.findViewById(R.id.logo);
        img2 = navHeader.findViewById(R.id.img2);
        coordinator=findViewById(R.id.coordinator);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinator,"Fab Clicked", Snackbar.LENGTH_LONG).show();
            }
        });

        layout=findViewById(R.id.layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar=Snackbar.make(view,"Rishi Is Deleted", Snackbar.LENGTH_LONG);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view,"Rishi Is Recovered", Snackbar.LENGTH_LONG).show();
                    }
                });
                snackbar.show();
            }

        });

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        // mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        //categoriesRecycler = findViewById(R.id.categories_recycler);


        //Menu Hooks
        setNavigationDrawer();




        //Recycler views function calls
        featuredRecycler();
        //mostViewedRecycler();
        //categoriesRecycler();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_items, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.login_btn1:
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(findViewById(R.id.login_btn1), "transition_new");
               // pairs[0] = new Pair<View, String>(findViewById(R.id.login_btn1), "transition_signup");
                Intent intent = new Intent(getApplicationContext(),RetailerStartScreen.class);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(UserDashboard.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }

                //startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void setNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_aboutus:
                        Toast.makeText(getApplicationContext(),"About Us",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(UserDashboard.this, RetailerStartScreen.class);
                        startActivity(intent);
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_whyus:
                        Toast.makeText(getApplicationContext(),"WhyUs",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_subject:
                        Toast.makeText(getApplicationContext(),"Subject",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_setting:
                        Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_share:
                        Toast.makeText(getApplicationContext(),"Share",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_rateus:
                        Toast.makeText(getApplicationContext(),"rateus",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;


                }
                return  true;
            }
        });
    }

    //Recycler views functions

    //private void categoriesRecycler();

    //private void mostViewedRecycler();
    public void featuredRecycler(){
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.career_counselling,"Career Counselling", "Career Counselling is a process that focuses on helping one understand one’s own self, as well as work trends, so that one can take an informed decision about career and education."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.engaging_lect,"Engaging Lectures", "Through this students will get a chance to learn in lectures which are a blend of live and innovative classes including animations, videos and live experiments."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.book_store,"Book and Library Store", "Download free textE-books and books prescribed for students by our experts.."));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400,0xffaff600});


    }
}