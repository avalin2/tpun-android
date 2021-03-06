package alexandre.valin.tpone;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class TweetAdapter extends ArrayAdapter<Personne> {

    public TweetAdapter(Context context, List<Personne> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.det_contact,parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va recuperer l'item [position] de la List<Tweet> tweets
        Personne personne = getItem(position);
        viewHolder.pseudo.setText(personne.getPseudo());
        viewHolder.text.setText(personne.getText());
        viewHolder.avatar.setImageDrawable(new ColorDrawable(personne.getColor()));

        return convertView;
    }

    private class TweetViewHolder{
        public TextView pseudo;
        public TextView text;
        public ImageView avatar;

    }
}