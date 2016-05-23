package com.androidbelieve.materialnavigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewAdapterDias extends RecyclerView.Adapter<RecyclerViewAdapterDias.ViewHolder> {
    String[] titles;
    TypedArray icons;
    Context context;
    Toolbar toolbar;
    DBHandler db;

   // The default constructor to receive titles,icons and context from MainActivity.
   RecyclerViewAdapterDias(String[] titles , TypedArray icons , Context context, Toolbar toolbar, DBHandler db){

            this.titles = titles;
            this.icons = icons;
            this.context = context;
            this.toolbar = toolbar;
            this.db = db;
    }

   /**
    *Its a inner class to RecyclerViewAdapter Class.
    *This ViewHolder class implements View.OnClickListener to handle click events.
    *If the itemType==1 ; it implies that the view is a single row_item with TextView and ImageView.
    *This ViewHolder describes an item view with respect to its place within the RecyclerView.
    *For every item there is a ViewHolder associated with it .
    */

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView  navTitle;
        ImageView navIcon;
        Context context;
        DBHandler db;

        public ViewHolder(View drawerItem , int itemType , Context context){

            super(drawerItem);
            this.context = context;
            drawerItem.setOnClickListener(this);
            if(itemType==1){
                navTitle = (TextView) itemView.findViewById(R.id.tv_NavTitle);
                navIcon = (ImageView) itemView.findViewById(R.id.iv_NavIcon);
            }
        }

       public void getDB (DBHandler db)
       {
           this.db = db;
       }

       /**
        *This defines onClick for every item with respect to its position.
        */

        @Override
        public void onClick(View v) {

            DiaActivity diaActivity = (DiaActivity)context;
            diaActivity.drawerLayout.closeDrawers();
            FragmentTransaction fragmentTransaction = diaActivity.getSupportFragmentManager().beginTransaction();

            Fragment wf = new DayFragment();
            //Fragment introFragment = new IntroFragment();
            fragmentTransaction.replace(R.id.containerView,wf);
            fragmentTransaction.commit();
            int rnd1,rnd2,rnd3,rnd4,rnd5;

            switch (getPosition()){

                case 1:
                    /*
                    Exercise ejercicio = db.traeEjercicio(rnd1);
                    String toString = ejercicio.toString();
                    i.putExtra("toString",toString);
                    i.putExtra("Dia","1");*/
                    toolbar.setTitle("Día 1");
                    break;
                case 2:
                    /*Exercise ejercicio2 = db.traeEjercicio(rnd2);
                    String toString2 = ejercicio2.toString();
                    i.putExtra("toString",toString2);
                    i.putExtra("Dia","2");*/
                    toolbar.setTitle("Día 2");
                    break;
                case 3:
                    /*Exercise ejercicio3 = db.traeEjercicio(rnd3);
                    String toString3 = ejercicio3.toString();
                    i.putExtra("toString",toString3);
                    i.putExtra("Dia","3");*/
                    toolbar.setTitle("Día 3");
                    break;
                case 4:
                    /*Exercise ejercicio4 = db.traeEjercicio(rnd4);
                    String toString4 = ejercicio4.toString();
                    i.putExtra("toString",toString4);
                    i.putExtra("Dia","4");*/
                    toolbar.setTitle("Día 4");
                    break;
                case 5:
                    /*Exercise ejercicio5 = db.traeEjercicio(rnd5);
                    String toString5 = ejercicio5.toString();
                    i.putExtra("toString",toString5);
                    i.putExtra("Dia","5");*/
                    toolbar.setTitle("Día 5");
                    break;
            }

            //context.startActivity(i);
        }
    }

   /**
    *This is called�every time�when we need a new ViewHolder and a new ViewHolder is required for every item in RecyclerView.
    *Then this ViewHolder is passed to onBindViewHolder to display items.
    */

    @Override
    public RecyclerViewAdapterDias.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(viewType==1){
                 View itemLayout =   layoutInflater.inflate(R.layout.drawer_item_layout,null);
                 return new ViewHolder(itemLayout,viewType,context);
            }
            else if (viewType==0) {
                View itemHeader = layoutInflater.inflate(R.layout.header_layout,null);
                return new ViewHolder(itemHeader,viewType,context);
            }



        return null;
    }

   /**
    *This method is called by RecyclerView.Adapter to display the data at the specified position.�
    *This method should update the contents of the itemView to reflect the item at the given position.
    *So here , if position!=0 it implies its a row_item and we set the title and icon of the view.
    */

    @Override
    public void onBindViewHolder(RecyclerViewAdapterDias.ViewHolder holder, int position) {

        if(position!=0){
            holder.navTitle.setText(titles[position - 1]);
            holder.navIcon.setImageResource(icons.getResourceId(position-1,-1));
        }

    }

     /**
      *It returns the total no. of items . We +1 count to include the header view.
      *So , it the total count is 5 , the method returns 6.
      *This 6 implies that there are 5 row_items and 1 header view with header at position zero.
      */

    @Override
    public int getItemCount() {
        return titles.length+1;
    }


   /**
    *This methods returns 0 if the position of the item is '0'.
    *If the position is zero its a header view and if its anything else
    *its a row_item with a title and icon.
    */

    @Override
    public int getItemViewType(int position) {
        if(position==0)return 0;
        else return 1;
    }


}
