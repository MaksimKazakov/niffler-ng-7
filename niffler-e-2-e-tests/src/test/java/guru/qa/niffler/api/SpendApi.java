package guru.qa.niffler.api;

import guru.qa.niffler.model.SpendJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SpendApi {
    /*Описывает эндпоинты куда будем ходить в сервис Spend*/
    @POST("internal/spends/add")
    Call<SpendJson> createSpend(@Body SpendJson spend);




}
