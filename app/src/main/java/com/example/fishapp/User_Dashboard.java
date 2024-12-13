package com.example.fishapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fishapp.databinding.ActivityUserDashboardBinding;
import com.example.fishapp.ui.home.HomeViewModel;
import com.example.fishapp.ui.sale.sale_menu;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class User_Dashboard extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityUserDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String username = getIntent().getStringExtra("USERNAME");

        // Inflate the layout and set it as the content view
        binding = ActivityUserDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set up the toolbar
        setSupportActionBar(binding.appBarUserDashboard.toolbar);

        // Set up the FloatingActionButton
        binding.appBarUserDashboard.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });

        // Set up the DrawerLayout and NavigationView
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top-level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_category)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_dashboard);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Pass the username to HomeViewModel
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.setUsername(username);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user__dashboard, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_dashboard);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void fried_bogue(View view){
        final TextView bogueprice = findViewById(R.id.bogueprice);
        bogueprice.setText("Ksh. 1000 per kg");
        String price = bogueprice.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.friedbogue);
        intent.putExtra("price", price);
        startActivity(intent);
        Toast.makeText(this, price, Toast.LENGTH_LONG).show();
    }


    public void indian_fry(View view){
        final TextView indianprice = findViewById(R.id.indianprice);
        indianprice.setText("Ksh. 1800 per kg");
        String price = indianprice.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.indianfry);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void kyenam_fry(View view){
        final TextView kyenamprice = findViewById(R.id.kyenam);
        kyenamprice.setText("Ksh. 2000 per kg");
        String price = kyenamprice.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.kyenamfry);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void batter_dripped(View view){
        final TextView batterdripped = findViewById(R.id.batter_dripped);
        batterdripped.setText("Ksh. 1650 per kg");
        String price = batterdripped.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.batterdrippedfry);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void cardilong_fry(View view){
        final TextView cardilongfry = findViewById(R.id.cardilong_fry);
        cardilongfry.setText("Ksh. 1656 per kg");
        String price = cardilongfry.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.cardilongfry);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void cripsy_fry(View view){
        final TextView cripsyfry = findViewById(R.id.cripsy_fry);
        cripsyfry.setText("Ksh. 1200 per kg");
        String price = cripsyfry.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.cripsyfry);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void southern_fry(View view){
        final TextView southernfry = findViewById(R.id.southern_fry);
        southernfry.setText("Ksh. 2000 per kg");
        String price = southernfry.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.southernfry);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void tilapia_fry(View view){
        final TextView tilapiafry = findViewById(R.id.tilapia_fry);
        tilapiafry.setText("Ksh. 2000 per kg");
        String price = tilapiafry.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.tilapiafry);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void vietnamese_fry(View view){
        final TextView vietnamesefry = findViewById(R.id.vietnamese_fry);
        vietnamesefry.setText("Ksh. 1850 per kg");
        String price = vietnamesefry.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.vietnamesefry);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void tilapia(View view){
        final TextView tilapia = findViewById(R.id.tilapia);
        tilapia.setText("Ksh. 2100 per kg");
        String price = tilapia.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.tilapia);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void perch(View view){
        final TextView perch = findViewById(R.id.perch);
        perch.setText("Ksh. 1750 per kg");
        String price = perch.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.perch);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void trout(View view){
        final TextView trout = findViewById(R.id.trout);
        trout.setText("Ksh. 18000 per kg");
        String price = trout.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.trout);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void bass(View view){
        final TextView bass = findViewById(R.id.bass);
        bass.setText("Ksh. 2700 per kg");
        String price = bass.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.bass);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void monk_fish(View view){
        final TextView monkfish = findViewById(R.id.monk_fish);
        monkfish.setText("Ksh. 2220 per kg");
        String price = monkfish.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.monk_fish);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void mahi_mahi(View view){
        final TextView mahimahi = findViewById(R.id.mahi_mahi);
        mahimahi.setText("Ksh. 2030 per kg");
        String price = mahimahi.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.mahi_mahi);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void halibut(View view){
        final TextView halibut = findViewById(R.id.halibut);
        halibut.setText("Ksh. 1950 per kg");
        String price = halibut.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.halibut);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void pike(View view){
        final TextView pike = findViewById(R.id.pike);
        pike.setText("Ksh. 2500 per kg");
        String price = pike.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.pike);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void roughy(View view){
        final TextView roughy = findViewById(R.id.roughy);
        roughy.setText("Ksh. 900 per kg");
        String price = roughy.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.roughy);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void red_snapper(View view){
        final TextView redsnapper = findViewById(R.id.red_snapper);
        redsnapper.setText("Ksh. 2080 per kg");
        String price = redsnapper.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.red_snapper);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void flounder(View view){
        final TextView flounder = findViewById(R.id.flounder);
        flounder.setText("Ksh. 3100 per kg");
        String price = flounder.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.flounder);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void sword_fish(View view){
        final TextView swordfish = findViewById(R.id.sword_fish);
        swordfish.setText("Ksh. 1000 per kg");
        String price = swordfish.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.swordfish);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void tuna(View view){
        final TextView tuna = findViewById(R.id.tuna);
        tuna.setText("Ksh. 1300 per kg");
        String price = tuna.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.tuna);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void cat_fish(View view){
        final TextView catfish = findViewById(R.id.cat_fish);
        catfish.setText("Ksh. 1500 per kg");
        String price = catfish.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.catfish);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void barramundi(View view){
        final TextView barramundi = findViewById(R.id.barramundi);
        barramundi.setText("Ksh. 2400 per kg");
        String price = barramundi.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.barramundiraw);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void salmon(View view){
        final TextView salmon= findViewById(R.id.salmon);
        salmon.setText("Ksh. 1100 per kg");
        String price = salmon.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.salmonraw);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void shell_fish(View view){
        final TextView shellfish = findViewById(R.id.shell_fish);
       shellfish.setText("Ksh. 1400 per kg");
        String price = shellfish.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.shellfishraw);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void sushi(View view){
        final TextView sushi = findViewById(R.id.sushi);
        sushi.setText("Ksh. 2060 per kg");
        String price = sushi.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.sushiraw);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void white_fish(View view){
        final TextView whitefish = findViewById(R.id.white_fish);
        whitefish.setText("Ksh. 2000 per kg");
        String price = whitefish.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.whiteraw);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void cod_fish(View view){
        final TextView whitefish = findViewById(R.id.cod_fish);
        whitefish.setText("Ksh. 1300 per kg");
        String price = whitefish.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.cod);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void fugu(View view){
        final TextView whitefish = findViewById(R.id.fugu);
        whitefish.setText("Ksh. 2000 per kg");
        String price = whitefish.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.fuguraw);
        intent.putExtra("price", price);
        startActivity(intent);
    }
    public void corvina_fish(View view){
        final TextView whitefish = findViewById(R.id.corvina_fish);
        whitefish.setText("Ksh. 2600 per kg");
        String price = whitefish.getText().toString();
        Intent intent = new Intent(User_Dashboard.this, sale_menu.class);
        intent.putExtra("resId", R.drawable.corvinaraw);
        intent.putExtra("price", price);
        startActivity(intent);
    }


}
