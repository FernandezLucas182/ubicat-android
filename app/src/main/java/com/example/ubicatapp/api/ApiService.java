package com.example.ubicatapp.api;

import com.example.ubicatapp.models.LoginResponse;
import com.example.ubicatapp.models.Mascota;
import com.example.ubicatapp.models.ReporteMascota;
import com.example.ubicatapp.models.MascotaQRResponse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {

    // LOGIN
    @FormUrlEncoded
    @POST("api/Usuario/login")
    Call<LoginResponse> login(
            @Field("Usuario") String usuario,
            @Field("Clave") String clave
    );

    // MIS MASCOTAS
    @GET("api/mascota/mias")
    Call<List<Mascota>> misMascotas(
            @Header("Authorization") String token
    );

    // CREAR MASCOTA
    @Multipart
    @POST("api/mascota/crear")
    Call<Mascota> crearMascota(
            @Header("Authorization") String token,
            @Part MultipartBody.Part foto,
            @Part("mascota") RequestBody mascota
    );

    // REPORTAR VISTA
    @Multipart
    @POST("api/reportes/vista/{id}")
    Call<ReporteMascota> reportarVista(
            @Path("id") int idMascota,
            @Part MultipartBody.Part foto,
            @Part("ubicacion") RequestBody ubicacion,
            @Part("mensaje") RequestBody mensaje
    );

    // ESCANEO PUBLICO QR
    @GET("api/public/mascota/{codigo}")
    Call<MascotaQRResponse> mascotaPorQR(
            @Path("codigo") String codigoQR
    );
}
