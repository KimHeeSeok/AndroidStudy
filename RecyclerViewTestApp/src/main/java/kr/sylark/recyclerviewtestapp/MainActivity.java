package kr.sylark.recyclerviewtestapp;

import android.app.Activity;
import android.content.Context;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.LauncherApps;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(kr.pe.sylark.recyclerviewtestapp.R.layout.activity_main);

        RecyclerView grid = findViewById(kr.pe.sylark.recyclerviewtestapp.R.id.grid);
        int space = convertDpToPixel(5, this);
        grid.addItemDecoration(new SpacesItemDecoration(space));

        List<Item> items = new ArrayList<>();

        ItemsRecyclerAdapter adapter = new ItemsRecyclerAdapter(this, items);

        grid.setAdapter(adapter);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float densityPxPerDp = displayMetrics.density;
        float densityPxPerSp = displayMetrics.scaledDensity;


        LauncherApps launcherApps = (LauncherApps) getSystemService(LAUNCHER_APPS_SERVICE);

        List<LauncherActivityInfo> activityInfos = launcherApps.getActivityList(null, android.os.Process.myUserHandle());

        for(int i=0; i< 16; i++) {
//        for (LauncherActivityInfo activityInfo : activityInfos) {

                LauncherActivityInfo activityInfo = activityInfos.get(i);

            Item item = new Item();
            item.name = (String) activityInfo.getLabel();
            item.packageName = activityInfo.getComponentName().toString();

            item.icon = activityInfo.getIcon(0);

            items.add(item);
        }


    }

    public static int convertDpToPixel(float dp, Context context){

        Resources resources = context.getResources();

        int px = (int) (TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics()));
        return px;
    }

}
