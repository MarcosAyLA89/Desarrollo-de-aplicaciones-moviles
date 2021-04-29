package sv.edu.udb.actividadlab_consumirapi.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class servicio {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static DetalleAPI service =
            retrofit.create(DetalleAPI.class);
}
