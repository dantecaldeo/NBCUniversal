package EndPoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.web.client.RestTemplate;

public class SearchTest {

    String apiRoot = "https://images-api.nasa.gov/search";

    @Test(dataProvider="searchParameters")
    public void successResponse(String searchParam, String searchValue){
        //searchParam = q, center, description,...
        //searchValue = text

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiRoot + "?" + searchParam + "=" + searchValue, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test(dataProvider="searchParameters")
    public void responseIsCollectionAndJson(String searchParam, String searchValue){
        //searchParam = q, center, description,...
        //searchValue = text

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiRoot + "?" + searchParam + "=" + searchValue, String.class);
        Assert.assertTrue(response.getBody().contains("Collection"));

    }

    @Test(dataProvider="notAllowedSearchParameters")
    public void notSuccessResponse(String searchParam, String searchValue){
        //searchParam = q1, center1, description1,...
        //searchValue = text

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiRoot + "?" + searchParam + "=" + searchValue, String.class);
        Assert.assertFalse(response.getStatusCode().equals(HttpStatus.OK));
    }


}