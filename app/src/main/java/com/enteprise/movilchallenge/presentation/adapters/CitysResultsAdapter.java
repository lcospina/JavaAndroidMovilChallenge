package com.enteprise.movilchallenge.presentation.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.enteprise.movilchallenge.frameworks.containers.AppContainer;
import com.enteprise.movilchallenge.databinding.CityItemBinding;
import com.enteprise.movilchallenge.domain.models.City;
import com.enteprise.movilchallenge.domain.models.CitySpecificData;
import com.enteprise.movilchallenge.domain.usecases.city.SearchWeatherByCityImp;
import com.enteprise.movilchallenge.presentation.utils.Utilitys;

import java.util.ArrayList;
import java.util.List;


public class CitysResultsAdapter extends RecyclerView.Adapter<CitysResultsAdapter.CitysResultsHolder> {
    private List<City> results = new ArrayList<>();
    private AppContainer appContainer = null;

    public CitysResultsAdapter(AppContainer containerRepostory) {
        this.appContainer = containerRepostory;
    }

    @NonNull
    @Override
    public CitysResultsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CityItemBinding binding = CityItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CitysResultsHolder(binding);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull CitysResultsHolder holder, int position) {
        City city = results.get(position);
        holder.viewBinding.cityTitle.setText(city.getName());
        holder.viewBinding.cityType.setText(city.getType());
        //holder.times.setVisibility(View.GONE);


        holder.viewBinding.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setExpanden(!city.isExpanden());
                notifyItemChanged(position);
            }
        });

        if (city.isExpanden()) {
            if (city.getCitySpecificData() == null) {
                holder.viewBinding.timesLayout.setVisibility(View.GONE);
                holder.viewBinding.progressBar.setVisibility(View.VISIBLE);
                getDataCity(city, holder.viewBinding.cardItem.getContext(), holder, true);
            } else {
                holder.viewBinding.timesLayout.setVisibility(View.VISIBLE);
                holder.viewBinding.progressBar.setVisibility(View.GONE);
                getDataCity(city, holder.viewBinding.cardItem.getContext(), holder, false);
            }
        } else {
            holder.viewBinding.timesLayout.setVisibility(View.GONE);
            holder.viewBinding.progressBar.setVisibility(View.GONE);
        }
    }

    private void getDataCity(City city, Context context, CitysResultsHolder holder, boolean withInternet) {

        MutableLiveData<City> informationCity = new MutableLiveData<>();

        informationCity.observe((LifecycleOwner) context, new Observer<City>() {
            @Override
            public void onChanged(City city) {
                if (city == null || city.getCitySpecificData() == null || city.getCitySpecificData().getConsolidated_weather().size() < 4) {

                    holder.viewBinding.timesLayout.setVisibility(View.GONE);
                    holder.viewBinding.progressBar.setVisibility(View.GONE);

                } else {

                    Glide.with(holder.viewBinding.weatherImgDay1)
                            .load("https://www.metaweather.com/static/img/weather/png/" + city.getCitySpecificData().getConsolidated_weather().get(0).getWeather_state_abbr() + ".png")
                            .into(holder.viewBinding.weatherImgDay1);
                    holder.viewBinding.weatherDate1.setText(city.getCitySpecificData().getConsolidated_weather().get(0).getApplicable_date());
                    holder.viewBinding.weatherState1.setText(city.getCitySpecificData().getConsolidated_weather().get(0).getWeather_state_name());
                    holder.viewBinding.weatherTemp1.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(0).getMin_temp()) + "°C");
                    holder.viewBinding.weatherTempMax1.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(0).getMax_temp()) + "°C");
                    holder.viewBinding.weatherWint1.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(0).getWind_speed()) + "mph");


                    Glide.with(holder.viewBinding.weatherImgDay2)
                            .load("https://www.metaweather.com/static/img/weather/png/" + city.getCitySpecificData().getConsolidated_weather().get(1).getWeather_state_abbr() + ".png")
                            .into(holder.viewBinding.weatherImgDay2);
                    holder.viewBinding.weatherDate2.setText(city.getCitySpecificData().getConsolidated_weather().get(1).getApplicable_date());
                    holder.viewBinding.weatherState2.setText(city.getCitySpecificData().getConsolidated_weather().get(1).getWeather_state_name());
                    holder.viewBinding.weatherTemp2.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(1).getMin_temp()) + "°C");
                    holder.viewBinding.weatherTempMax2.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(1).getMax_temp()) + "°C");
                    holder.viewBinding.weatherWint2.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(1).getWind_speed()) + "mph");

                    Glide.with(holder.viewBinding.weatherImgDay3)
                            .load("https://www.metaweather.com/static/img/weather/png/" + city.getCitySpecificData().getConsolidated_weather().get(2).getWeather_state_abbr() + ".png")
                            .into(holder.viewBinding.weatherImgDay3);
                    holder.viewBinding.weatherDate3.setText(city.getCitySpecificData().getConsolidated_weather().get(2).getApplicable_date());
                    holder.viewBinding.weatherState3.setText(city.getCitySpecificData().getConsolidated_weather().get(2).getWeather_state_name());
                    holder.viewBinding.weatherTemp3.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(2).getMin_temp()) + "°C");
                    holder.viewBinding.weatherTempMax3.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(2).getMax_temp()) + "°C");
                    holder.viewBinding.weatherWint3.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(2).getWind_speed()) + "mph");

                    Glide.with(holder.viewBinding.weatherImgDay4)
                            .load("https://www.metaweather.com/static/img/weather/png/" + city.getCitySpecificData().getConsolidated_weather().get(3).getWeather_state_abbr() + ".png")
                            .into(holder.viewBinding.weatherImgDay4);
                    holder.viewBinding.weatherDate4.setText(city.getCitySpecificData().getConsolidated_weather().get(3).getApplicable_date());
                    holder.viewBinding.weatherState4.setText(city.getCitySpecificData().getConsolidated_weather().get(3).getWeather_state_name());
                    holder.viewBinding.weatherTemp4.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(3).getMin_temp()) + "°C");
                    holder.viewBinding.weatherTempMax4.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(3).getMax_temp()) + "°C");
                    holder.viewBinding.weatherWint4.setText(Utilitys.stringCut(city.getCitySpecificData().getConsolidated_weather().get(3).getWind_speed()) + "mph");

                    holder.viewBinding.timesLayout.setVisibility(View.VISIBLE);
                    holder.viewBinding.progressBar.setVisibility(View.GONE);
                }

            }
        });


        if (withInternet) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    city.setCitySpecificData(null);

                    SearchWeatherByCityImp searchWeatherByCityImp = new SearchWeatherByCityImp(appContainer.cityRepository);
                    CitySpecificData additionalDataCity = searchWeatherByCityImp.searchWeatherByCity(city.getIdWebService());
                    city.setCitySpecificData(additionalDataCity);
                    informationCity.postValue(city);

                }
            }).start();
        } else {
            informationCity.postValue(city);
        }


    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<City> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class CitysResultsHolder extends RecyclerView.ViewHolder {

        private CityItemBinding viewBinding;

        public CitysResultsHolder(@NonNull CityItemBinding binding) {
            super(binding.getRoot());
            viewBinding = binding;

        }
    }
}
