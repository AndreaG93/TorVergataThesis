import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import serverless.aws.AWSLambdaFunction;

import static org.junit.jupiter.api.Assertions.fail;

public class TestJSON {

    private final static String functionName = "arn:aws:lambda:us-east-1:272360024508:function:CPU-Intensive";

    @Test
    public void validTestCase_1() {

        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("key", 3);

            System.out.println(jsonObject.toString());

            System.out.println("Test");

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void validTestCase_3232() {

        try {

            AWSLambdaFunction awsLambdaFunction = new AWSLambdaFunction(functionName);
            awsLambdaFunction.list();

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void innovationTest() {

        try {

            AWSLambdaFunction awsLambdaFunction = new AWSLambdaFunction(functionName);

            JSONObject inputPayload = new JSONObject();
            inputPayload.put("key1", 4);

            System.out.println(inputPayload.toString());


            // "{\n \"key1\": 4 \n}"

            awsLambdaFunction.executeWithPayload(null, inputPayload.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }


    @Test
    public void testUpdateMemorySize() {

        try {

            AWSLambdaFunction awsLambdaFunction = new AWSLambdaFunction(functionName);
            awsLambdaFunction.updateMemorySize(256);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

}
