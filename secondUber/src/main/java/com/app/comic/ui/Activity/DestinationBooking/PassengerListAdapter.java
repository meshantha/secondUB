package com.app.comic.ui.Activity.DestinationBooking;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.comic.R;
import com.app.comic.api.ApiEndpoint;
import com.app.comic.ui.Model.Receive.ListRidesReceive;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

//import static com.app.tbd.ui.Activity.BookingFlight.FlightListFragment.getFareType;
//import static com.app.tbd.ui.Activity.BookingFlight.FlightPriceFragment.resetAdapterFromInside;

public class PassengerListAdapter extends BaseAdapter {

    private final Activity context;
    private final List<ListRidesReceive.Passenger> obj;
    private ListOfRidesFragment frag;

    public PassengerListAdapter(Activity context, ListOfRidesFragment frag, ArrayList<ListRidesReceive.Passenger> lists) {
        this.context = context;
        this.obj = lists;
        this.frag = frag;

    }

    @Override
    public int getCount() {
        return obj == null ? 0 : obj.size();
    }

    @Override
    public Object getItem(int position) {
        return obj == null ? null : obj.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {

        @InjectView(R.id.username)
        TextView username;

        @InjectView(R.id.btnSelectPassenger)
        TextView btnSelectPassenger;

        @InjectView(R.id.txtPhone)
        TextView txtPhone;

        @InjectView(R.id.btnCall)
        TextView btnCall;

        @InjectView(R.id.passengerList)
        LinearLayout passengerList;

        @InjectView(R.id.image_dp)
        CircularImageView image_dp;

    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.share_ride_passenger_list, parent, false);
            vh = new ViewHolder();
            ButterKnife.inject(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        if (obj.get(position).getUser_image() != null) {
            Glide.with(context).load(ApiEndpoint.imagePath()+""+obj.get(position).getUser_image())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    //.placeholder(ContextCompat.getDrawable(getActivity(), R.drawable.promo_home))
                    .into(vh.image_dp);
        }else{
            vh.image_dp.setImageResource(R.drawable.no_profile);
        }

        //vh.txtUsername.setText(obj.get(position).getBook_name());
        vh.username.setText(obj.get(position).getUsername());
        vh.txtPhone.setText(obj.get(position).getPhone());
        vh.btnSelectPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag.selectDriver(obj.get(position).getId());
            }
        });

        vh.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag.callPassenger(obj.get(position).getPhone());
            }
        });


        return view;

    }

}
