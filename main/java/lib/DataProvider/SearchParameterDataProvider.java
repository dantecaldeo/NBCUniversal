package lib.DataProvider;

import org.testng.annotations.DataProvider;

public class SearchParameterDataProvider {


    @DataProvider(name="searchParameters")
    public static Object [][] searchParameters(){
        return new Object[][]{
                {"q","mars"},
                {"center","mars"},
                {"description","mars"},
                {"description_508","mars"},
                {"keywords","mars"},
                {"location","mars"},
                {"media_type","mars"},
                {"nasa_id","mars"},
                {"photographer","mars"},
                {"secondary_creator","mars"},
                {"title","mars"},
                {"year_start","2000"},
                {"year_end","2000"}

        };
    }

    @DataProvider(name="notAllowedSearchParameters")
    public static Object [][] notAllowedSearchParameters(){
        return new Object[][]{
                {"q1","mars"},
                {"center1","mars"}
        };
    }

}
