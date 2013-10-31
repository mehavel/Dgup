package blog.mehavel.dgup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class MyAdapter extends BaseAdapter {
	
	private Context mContext;
	
	public MyAdapter(Context C){
		System.out.println("constructor!!!!!!!!!!!!!!!!!!!!!!!!!!");
		this.mContext = C;
	}

	@Override
	public int getCount() {
		System.out.println("getcount@@@@@@@@@@@@@@@@@@@@@@@");
		return mIds.length;
	}

	@Override
	public Object getItem(int position) {
		System.out.println("getitem..............................");
		return mIds[position];
	}

	@Override
	public long getItemId(int arg0) {
		System.out.println("getitemId.. .. .. .. .. .. ..  .  ...  ..   ...");
		return 0;
	}

	@SuppressLint("NewApi")
	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		Button btn;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            btn = new Button(mContext);
            btn.setLayoutParams(new GridView.LayoutParams(190, 150));
            
        } else {
        	btn = (Button) convertView;
        }
        //btn.setMinimumWidth(10);
        
        btn.setCompoundDrawablesWithIntrinsicBounds(0, iconIds[position], 0, 0);
        btn.setText(mIds[position]);
        Typeface type=Typeface.createFromAsset(mContext.getAssets(), "Ubuntu-L.ttf");
        btn.setTypeface(type);
        btn.setBackground(mContext.getResources().getDrawable(R.drawable.shape));
        btn.setTextColor(Color.GRAY);
        btn.setPadding(8, 40, 8, 8);
        return btn;
	}
	
	private AssetManager getAssets() {
		// TODO Auto-generated method stub
		return null;
	}

	private String[] mIds = {
		
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
	
	private Integer[] iconIds = {
		R.drawable.animals,
		R.drawable.alphabets,
		R.drawable.birds,
		R.drawable.colors,
		R.drawable.flowers,
		R.drawable.fruits,
		R.drawable.planets,
		R.drawable.vehicles,
		R.drawable.xmas
	};

}
