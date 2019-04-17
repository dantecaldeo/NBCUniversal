package EndPoints;

import lib.DataProvider.SearchParameterDataProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.web.client.RestTemplate;

public class SearchTest {

    String apiRoot = "https://images-api.nasa.gov/search";

    @Test(dataProvider="searchParameters", dataProviderClass = SearchParameterDataProvider.class)
    public void successResponse(String searchParam, String searchValue){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiRoot + "?" + searchParam + "=" + searchValue, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK );
    }

   @Test(dataProvider="searchParameters", dataProviderClass = SearchParameterDataProvider.class)
    public void responseIsCollectionAndJson(String searchParam, String searchValue){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiRoot + "?" + searchParam + "=" + searchValue, String.class);
        Assert.assertTrue(response.getBody().contains("collection"));
        Assert.assertTrue(response.getBody().contains(apiRoot + "?" + searchParam + "=" + searchValue ));

    }

    @Test(dataProvider="notAllowedSearchParameters", dataProviderClass = SearchParameterDataProvider.class)
    public void badRequestResponse(String searchParam, String searchValue){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiRoot + "?" + searchParam + "=" + searchValue, String.class);
        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.BAD_REQUEST));

    }

}