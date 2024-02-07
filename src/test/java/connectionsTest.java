import com.demo.builders.RequestBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class connectionsTest {





@Test


    public void getConnections(){
    var statusCode  = RequestBuilder.buildRequest().get("").getStatusCode();
        Assert.assertEquals(statusCode,200);
}


}
