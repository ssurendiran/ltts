
import com.demo.builders.RequestBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserTest {




        @Test
        public void userValidationEmail() {
            var response = RequestBuilder.buildRequest().get("/api/users");
            var total_pages = response.jsonPath().getInt("total_pages");
            var expectedEmail = List.of("george.bluth@reqres.in", "janet.weaver@reqres.in", "emma.wong@reqres.in",
                    "eve.holt@reqres.in","charles.morris@reqres.in", "tracey.ramos@reqres.in", "michael.lawson@reqres.in",
                    "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in", "byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in");
            var actualEmail = new ArrayList<>();

            for(int i=1; i<=total_pages;i++){
                    var response1 = RequestBuilder.buildRequest().get("/api/users?page="+i+"");
                    actualEmail.addAll( response1.jsonPath().getList("data.email"));
            }

                Assert.assertEquals(actualEmail,expectedEmail);
        }






     @Test
        public void validatePagination(){
            var response = RequestBuilder.buildRequest().get("/api/users");
            var total = response.jsonPath().getInt("total");
            var expectedUsers =0;

            for(int i=1;i<=total;i++){

                expectedUsers++;
                var temp = RequestBuilder.buildRequest().get("/api/users?per_page="+i+"");
                var actualUsers  = temp.jsonPath().getList("data").size();
                Assert.assertEquals(actualUsers,expectedUsers);
            }

        }

        @Test

    public void   validateResponseTime(){
            var time  = RequestBuilder.buildRequest().get("/api/users").getTimeIn(TimeUnit.SECONDS);
                Assert.assertTrue(time<10);
        }




}



