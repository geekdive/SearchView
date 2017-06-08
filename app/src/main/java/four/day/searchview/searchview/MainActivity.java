package four.day.searchview.searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    SearchView sv;

    String[] tampungCourse =
            {
                    "Matematika",
                    "Multimedia",
                    "Pemrograman Android",
                    "Biologi",
                    "Teknologi Office"
            };

    int[] tampungGambar =
            {
                    R.drawable.check,
                    R.drawable.cloud,
                    R.drawable.data,
                    R.drawable.drive,
                    R.drawable.ice
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.lvData);
        sv = (SearchView)findViewById(R.id.svSearch);

        //Adapter
        final Adapter adapter = new Adapter(this, getModel());
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String search) {
                adapter.getFilter().filter(search);
                return false;
            }
        });


    }

    private ArrayList<Model> getModel(){
        ArrayList<Model> models = new ArrayList<Model>();
        Model model;

        for (int i = 0; i < tampungCourse.length; i++){
            model = new Model(tampungCourse[i], tampungGambar[i]);
            models.add(model);
        }
        return  models;
    }
}
