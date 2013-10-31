package blog.mehavel.dgup;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mlistView;
	private ActionBarDrawerToggle adToggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*Drawer start*/
		String[] drawerValues = {
				"Animals",
				"Alphabets",
				"Birds",
				"Colors",
				"flowers",
				"Fruits",
				"Planets",
				"Vehicles",
				"Xmas"
		};
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		adToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.open, R.string.close) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle("Home");
                TextView txt;
            	Typeface type=Typeface.createFromAsset(getApplicationContext().getAssets(), "Ubuntu-L.ttf");
            	for(int i=0;i<mlistView.getChildCount();i++){
            		if(mlistView.getChildAt(i) instanceof TextView){
            			txt = (TextView)mlistView.getChildAt(i);
            			txt.setTypeface(type);
            		}
            	}
            	TextView text = (TextView)findViewById(R.id.text1);
        		text.setTypeface(type);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
            	getActionBar().setTitle("Menu");
            	invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
       // mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerLayout.setDrawerListener(adToggle);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		mlistView = (ListView)findViewById(R.id.left_drawer);
		mlistView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, drawerValues));
		
		 
		
		/*Drawer end*/
		
		/*Grid view*/
		GridView gv = (GridView) findViewById(R.id.grid_view);
		gv.setAdapter(new MyAdapter(this));
		Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.flyinfromcenter);
		gv.setAnimation(anim);
		anim.start();
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				
				
			}
		});
		
		/*Grid view end*/
		
	}

	@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        adToggle.onConfigurationChanged(newConfig);
    }
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	 
	         // call ActionBarDrawerToggle.onOptionsItemSelected(), if it returns true
	        // then it has handled the app icon touch event
	        if (adToggle.onOptionsItemSelected(item)) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
         adToggle.syncState();
    }

}
