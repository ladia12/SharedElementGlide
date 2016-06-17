package sample.com.sharedelementglide;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by ladia on 17/06/16.
 */
public class ArticleRecyclerViewAdapter extends RecyclerView.Adapter {

    private Context mCtx;
    private ArrayList<ArticleModel> mArticles = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    public ArticleRecyclerViewAdapter(Context context) {
        generateDummyArticleData();
        mCtx = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_list_card, parent, false);
        ArticlesCardViewHolder viewHolder = new ArticlesCardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ArticlesCardViewHolder vh = ((ArticlesCardViewHolder)holder);
        ArticleModel article = mArticles.get(position);
        vh.articlesText.setText(article.text);
        vh.articleTitle.setText(article.title);
        Glide.with(mCtx).load(article.imageUrl).thumbnail(0.1f).fitCenter().centerCrop().into(vh.articleImage);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public void generateDummyArticleData() {
        mImageUrls.add("http://cdn-static.denofgeek.com/sites/denofgeek/files/styles/article_main_wide_image/public/2015/10/main.jpg?itok=MLAE6BF6");
        mImageUrls.add("https://cdn.theatlantic.com/assets/media/img/mt/2016/01/superman/lead_960.jpg?1454104448");
        mImageUrls.add("https://images5.alphacoders.com/668/thumb-350-668680.jpg");
        mImageUrls.add("http://im.ziffdavisinternational.com/t/ign_de/blogroll/s/spider-man/spider-man-director-and-actor-finalists-reportedly_dpuu.640.jpg");
        mImageUrls.add("http://static.new.tuoitre.vn/tto/i/s626/2016/01/15/the-incredible-hulk-wallpaper-broken-glass-1452833502.jpg");
        for (int i = 0; i < 5; i++) {
            ArticleModel model = new ArticleModel();
            model.imageUrl = mImageUrls.get(i);
            model.title = "SuperHero " + (i+1);
            model.text = "Time for Action!";
            mArticles.add(model);
        }
    }

    public class ArticlesCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView articlesText;
        TextView articleTitle;
        ImageView articleImage;

        public ArticlesCardViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            articlesText = (TextView) itemView.findViewById(R.id.card_text);
            articleTitle = (TextView) itemView.findViewById(R.id.card_title);
            articleImage = (ImageView) itemView.findViewById(R.id.card_image);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(mCtx ,ArticleActivity.class);
            String transitionName = v.getContext().getString(R.string.transition_string);
            i.putExtra("article",mArticles.get(this.getLayoutPosition()));
            View viewStart = v.findViewById(R.id.card_image);

            ActivityOptionsCompat options =

                    ActivityOptionsCompat.makeSceneTransitionAnimation((HomeActivity)mCtx,
                            viewStart,   // Starting view
                            transitionName    // The String
                    );
            //Start the Intent
            ActivityCompat.startActivity((HomeActivity)mCtx, i, options.toBundle());
        }
    }

}
