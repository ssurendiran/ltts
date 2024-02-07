
import com.demo.builders.RequestBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.userBuilder;

public class RegistrationTest {





    @Test

    public void successfulRegister() {
        var response = RequestBuilder.buildRequest().body(new userBuilder().setEmail("eve.holt@reqres.in").setPassword("pistol")).post("/api/register");
        var actual = response.getStatusCode();
        var expected = 200;
        Assert.assertEquals(actual,expected);
}



    @Test
    public  void unsuccessRegister(){
    var response = RequestBuilder.buildRequest().body(new userBuilder().setEmail("eve.holt@reqres.in")).post("/api/register");
    var actual = response.getBody().asString();
    var expected = "{\"error\":\"Missing email or username\"}";
    Assert.assertEquals(actual,expected);

}


}
