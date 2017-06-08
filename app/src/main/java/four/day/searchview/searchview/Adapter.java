package four.day.searchview.searchview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by septiyadi on 6/8/17.
 */

public class Adapter extends BaseAdapter implements Filterable{

    Context context;
    ArrayList<Model> models;
    CustomFilter filter;
    ArrayList<Model> filterlist;


    public Adapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
        this.filterlist = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return models.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.listitem, null);
        }

        TextView txNama = (TextView)convertView.findViewById(R.id.tvJudul);
        ImageView idGambar = (ImageView)convertView.findViewById(R.id.ivGambar);

        txNama.setText(models.get(position).getJudul());
        idGambar.setImageResource(models.get(position).getGambar());

        return convertView;
    }

    @Override
    public Filter getFilter() {

        if (filter == null){
            filter = new CustomFilter();
        }

        return filter;
    }

    //Inner Class (class turunan)
    class  CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            FilterResults results = new FilterResults();

            if (charSequence != null && charSequence.length() > 0) {
                charSequence = charSequence.toString().toUpperCase();

                ArrayList<Model> filters = new ArrayList<>();

                for (int i = 0; i < filterlist.size(); i++){
                    if (filterlist.get(i).getJudul().toUpperCase().contains(charSequence))  {
                        Model model = new Model(filterlist.get(i).getJudul(), filterlist.get(i).getGambar());

                        filters.add(model);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }else {
                results.count = filterlist.size();
                results.values = filterlist;
            }



            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {

            models = (ArrayList<Model>)filterResults.values;
            notifyDataSetChanged();

        }
    }
}
